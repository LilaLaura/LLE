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
		neighborMatrix= new double[k][dimensions.length];
		counter=0;
		// TODO Auto-generated constructor stub
	}
	
//	/*
//	 * add a neighbors as DataPoint
//	 */
//	public void addNeighbor(DataPoint neighbor){
//		this.neighbors.add(neighbor);
//	}
	
	/*
	 * 
	 */
	
	public boolean isNeighbor(ExtDataPoint neighbor){
		for(int i=0; i<neighborMatrix.length; i++){
			if(Arrays.equals(this.neighborMatrix[i],neighbor.getAllDimensions())){
				return true;
			}
		}
		return false;
	}
	
	public void addNeighbor(DataPoint neighbor){
		for(int i=0; i<neighbor.getNumberOfDimensions(); i++){
			neighborMatrix[counter][i]=neighbor.getDimensionN(i);
		}
		counter++;
	}
	
	public double[][] matrixSubtraction(double[] dimensions, double[][] neighbor){
		double[][] result = neighbor;
		for(int i=0; i< neighbor.length; i++){
			for(int j=0; j<neighbor[0].length; j++){
				result[i][j]=neighbor[i][j]-dimensions[j];
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
	
	public double[] solveLinearSystem(double[][] covarianceNeighborMatrix){
		double[][] coloumnVector= new double[covarianceNeighborMatrix.length][1];
		for(int i=0; i<covarianceNeighborMatrix.length; i++){
			coloumnVector[i][0]=1;
		}
		Matrix C= new Matrix(covarianceNeighborMatrix);
		Matrix ColVec= new Matrix(coloumnVector);
		Matrix w = C.solve(ColVec);
		return w.getRowPackedCopy();
	}
	
	public void doSolvingLinearSystem(){
		this.linearVector=this.solveLinearSystem(this.covarianceNeighborMatrix);
	}

	public double[][] calcSparseMatrix(double[][] weightMatrix){
		Matrix I= Matrix.identity(weightMatrix.length,weightMatrix[0].length);
		Matrix W=new Matrix(weightMatrix);
		Matrix subtract=I.minus(W);
		Matrix transpose = subtract.transpose();
		Matrix M= transpose.times(subtract);
		return M.getArray();
	}
	
	public void createSparseMatrix(){
		this.sparseMatrix=this.calcSparseMatrix(this.weightMatrix);
	}
	
	public
}
