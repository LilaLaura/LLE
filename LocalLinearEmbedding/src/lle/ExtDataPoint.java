/**
 * 
 */
package lle;

import java.util.ArrayList;
import java.util.Arrays;

import Jama.Matrix;

/**
 * @author 
 * extended DataPoint class
 * this DataPoints can also carry information about their neighbors 
 */
public class ExtDataPoint extends DataPoint {
	
	//two ways to represent neighbors, we will see which is more useful later
	//TODO clean up before release
	//ArrayList<DataPoint> neighbors;
	//ArrayList<Integer> neighborsIndex;
	public double[][] neighborMatrix;
	Integer counter;
	public double[][]subtractedNeighborMatrix;
	public double[][]covarianceNeighborMatrix;
	public double[]linearVector;
	public double[][]weightMatrix;
	public double[][]sparseMatrix;

	public ExtDataPoint(double[] dimensions,Integer k) {
		super(dimensions);
		neighborMatrix= new double[dimensions.length][k];
		counter=0;
		this.linearVector=new double[k];
		// TODO Auto-generated constructor stub
	}
	

	/*
	 * 
	 */
	
	public boolean isNeighbor(DataPoint neighbor){
		for(int i=0; i<=neighborMatrix[0].length-1; i++){
			double[] temp = new double[neighbor.getNumberOfDimensions()];
			for(int j=0; j<=neighbor.getNumberOfDimensions()-1; j++){
				temp[j] = this.neighborMatrix[j][i];
			}
			if(Arrays.equals(temp,neighbor.getAllDimensions())){
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Overloaded function so both, DataPoints and ExtDataPoints can be used to
	 * check if it is a neighbor
	 */
	public boolean isNeighbor(ExtDataPoint neighbor){
		for(int i=0; i<=neighborMatrix[0].length-1; i++){
			double[] temp = new double[neighbor.getNumberOfDimensions()];
			for(int j=0; j<=neighbor.getNumberOfDimensions()-1; j++){
				temp[j] = this.neighborMatrix[j][i];
			}
			if(Arrays.equals(temp,neighbor.getAllDimensions())){
				return true;
			}
		}
		return false;
	}
	
	//Matrix dimension dxk
	public void addNeighbor(DataPoint neighbor){
		for(int i=0; i<=neighbor.getNumberOfDimensions()-1; i++){
			this.neighborMatrix[i][counter]=neighbor.getDimensionN(i); 
		}
		counter++;
	}
	
	/*
	 * substracting a given datapoint from a given distance matrix
	 * 
	 */
	public double[][] matrixSubtraction(double[] dimensions, double[][] neighbor){
		double[][] result = new double[neighbor.length][neighbor[0].length];
		for(int i=0; i<= neighbor[0].length-1; i++){
			for(int j=0; j<= neighbor.length-1; j++){
				result[j][i]=neighbor[j][i]-dimensions[j];
			}
		}
		return result;
	}
	
	public void doSubtraction(){
		this.subtractedNeighborMatrix=this.matrixSubtraction(super.getAllDimensions(), this.neighborMatrix);
	}
	
	public double[][] calcCovariance(double[][] subtractedNeighborMatrix){
		Matrix A = new Matrix(subtractedNeighborMatrix);
		Matrix transpose = A.transpose();
		Matrix C= transpose.times(A);
		return C.getArray();
	}
	
	public void doCovariance(){
		this.covarianceNeighborMatrix=this.calcCovariance(this.subtractedNeighborMatrix);
	}
	
	//Vector dimension kx1
	public double[] solveLinearSystem(double[][] covarianceNeighborMatrix){
		double[][] coloumnVector= new double[covarianceNeighborMatrix.length][1];
		for(int i=0; i<covarianceNeighborMatrix.length; i++){
			coloumnVector[i][0]=1;
		}
		Matrix C= new Matrix(covarianceNeighborMatrix);
		Matrix ColVec= new Matrix(coloumnVector);
		Matrix w = C.solve(ColVec);
		return w.getColumnPackedCopy();
	}
	
	public void doSolvingLinearSystem(){
		this.linearVector=this.solveLinearSystem(this.covarianceNeighborMatrix);
	}
	
	
}
