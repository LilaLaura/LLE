package lle;

import java.util.ArrayList;

import Jama.EigenvalueDecomposition;
import Jama.Matrix;


public class LLE {
	ArrayList<DataPoint> data;
	double[][] distances;
	ArrayList<ExtDataPoint> dataWithNeighbors;
	double[][] weightMatrix;
	double[][] sparseMatrix;
	Integer[] smallestEigenValues;
	double[][] embeddingMatrix;
	/* constructor 
	 * 
	 * @param k number of expected neighbors
	 */
	public LLE(ArrayList<DataPoint> data, int k, int d) {
		super();
		//ensure input data is not null, this would raise a nullPointerException
		if( data != null && k != 0)
		{
			//remember initial list of DataPoints
			this.data = data;
			//calculate and remember distances between all DataPoints
			this.distances = this.calcDistanceMatrix(data);
			//calculate and remember the neighbors of all DataPoints
			this.dataWithNeighbors = this.findAllNeighbors(k, data, distances);
			this.subtractAllRows(dataWithNeighbors);
			this.calcAllCovariance(dataWithNeighbors);
			this.calcAllLinearSystems(dataWithNeighbors);
			this.weightMatrix=this.constructWeightMatrix(dataWithNeighbors);
			this.sparseMatrix=this.calcSparseMatrix(weightMatrix);
			this.smallestEigenValues=this.calcSmallestEigenValues(sparseMatrix, d);
			this.embeddingMatrix=this.embeddingMatrix(sparseMatrix, smallestEigenValues);
		}
	}
	
	public double[][] embeddingMatrix(double[][] sparseMatrix, Integer[] smallestEigenValues){
		double[][] embeddingMatrix= new double[sparseMatrix.length][smallestEigenValues.length-1];
		Matrix M= new Matrix(sparseMatrix);
		EigenvalueDecomposition x= new EigenvalueDecomposition(M);
		Matrix V=x.getV();
		double[][] vArray=V.getArray();
		for(int i=1; i<=smallestEigenValues.length-1; i++){
			for(int j=0; j<=vArray.length-1; j++){
				embeddingMatrix[j][i-1]=vArray[j][smallestEigenValues[i]];
			}
		}
		return embeddingMatrix;
	}
	
	public Integer[] calcSmallestEigenValues(double[][] sparseMatrix, int d){
		Integer[] smallestEigenValues= new Integer[d+1];
		Matrix M= new Matrix(sparseMatrix);
		EigenvalueDecomposition x= new EigenvalueDecomposition(M);
		Integer[] EigenValues=this.bubbleSortIndexByDistance(x.getRealEigenvalues());
		for(int i=0; i<=d; i++){
			smallestEigenValues[i]=EigenValues[i];
		}
		return smallestEigenValues;
	}
	
//	Matrix dimension NxN
	public double[][] calcSparseMatrix(double[][] weightMatrix){
		Matrix I= Matrix.identity(weightMatrix.length,weightMatrix[0].length);
		Matrix W=new Matrix(weightMatrix);
		Matrix subtract=I.minus(W);
		Matrix transpose = subtract.transpose();
		Matrix M= transpose.times(subtract);
		return M.getArray();
	}
	
	public double[][] constructWeightMatrix(ArrayList<ExtDataPoint> data){
		double[][] weightMatrix= new double[data.size()][data.size()];
		for(int i=0; i<=data.size()-1; i++){
			double[] linearVector= data.get(i).linearVector;
			int h=0;
			double sum=0.0;
			for(int f=0; f<=linearVector.length-1; f++){
				sum+=linearVector[f];
			}
			for(int j=0; j<=data.size()-1; j++){
				if(data.get(i).isNeighbor(data.get(j))){
					System.out.println(j+" "+i+" :"+sum);
					weightMatrix[j][i]=linearVector[h]/sum;
					h++;
				}
				else{
					weightMatrix[j][i]=0;
				}
			}
			
		}
		return weightMatrix; //weightmatrix for datapoint i, dimension NxN
	}
	
	public void calcAllLinearSystems(ArrayList<ExtDataPoint> data){
		for(int i=0; i<=data.size()-1; i++){
			data.get(i).doSolvingLinearSystem();
		}
	}
	
	public void calcAllCovariance(ArrayList<ExtDataPoint> data){
		for(int i=0; i<=data.size()-1; i++){
			data.get(i).doCovariance();
		}
	}
	
	public void subtractAllRows(ArrayList<ExtDataPoint> data){
		for(int i=0; i<=data.size()-1; i++){
			data.get(i).doSubtraction();
		}
	}
	
		/*
	 * find all neighbors for all DataPoints
	 * @param k number of expected neighbors
	 */
	public ArrayList<ExtDataPoint> findAllNeighbors(int k, ArrayList<DataPoint> data, double[][] distances){
		ArrayList<ExtDataPoint> result = new ArrayList<ExtDataPoint>();                                                                  
		for(int i=0; i<data.size(); i++){
			Integer[] neighbors=this.findNeighbours(k,i, distances);
			ExtDataPoint temp= new ExtDataPoint(data.get(i).getAllDimensions(),k);
			for(int j=0; j<neighbors.length; j++){
				temp.addNeighbor(data.get(neighbors[j]));
			}
			result.add(temp);
		}
		return result;
		
	}
	
	/*
	 * find all neighbors for a single DataPoint
	 * @param k number of expected neighbors
	 * @param i index of the "home"-DataPoint
	 * @param distances distance matrix for neighbor calculation
	 */
	public Integer[] findNeighbours(int k, int i, double[][] distances){
		Integer[] result = new Integer[k];
		Integer[] sortedIndexList = this.bubbleSortIndexByDistance(distances[i]);
		for (int j = 1; j <= k; j++) {
			result[j-1] = sortedIndexList[j];
		}
		return this.bubbleSort(result);
	}
		public Integer[] bubbleSortIndexByDistance(double[] b){
			double temp;
			Integer temp2;
			Integer[] index = new Integer[b.length];
			for(int p=0; p<b.length; p++){
				index[p]=p;
			}
			for(int i=1; i<b.length; i++) {
				for(int j=0; j<b.length-i; j++) {
					if(b[j]>b[j+1]) {
						temp=b[j];
						b[j]=b[j+1];
						b[j+1]=temp;
						temp2=index[j];
						index[j]=index[j+1];
						index[j+1]=temp2;
					}
					
				}
			}
			return index; 
		}
		public Integer[] bubbleSort(Integer[] result){
			Integer temp;
			Integer[] index = new Integer[result.length];
			for(int i=1; i<result.length; i++) {
				for(int j=0; j<result.length-i; j++) {
					if(result[j]>result[j+1]) {
						temp=result[j];
						result[j]=result[j+1];
						result[j+1]=temp;
					}
					
				}
			}
			return result; 
		}
	/*
	 * calculates the distance matrix for a given set of DataPoint
	 * TODO optimize! Distance matrices are symmetric therefore calculating
	 * distances twice could be avoided
	 */
	public double[][] calcDistanceMatrix( ArrayList<DataPoint> data ){
		double[][] result = new double[data.size()][data.size()];
		System.out.println(data.size());
		for(int i=0; i<=data.size()-1; i++){
			System.out.println("i=: "+i);
			for(int j=0; j<=data.size()-1; j++){
				System.out.println("j=: "+j);
				if(j!=i){
					System.out.println("distance=: "+calcDistance(data.get(i),data.get(j)));
					result[i][j]=calcDistance(data.get(i),data.get(j));
				}
				else{
					result[i][j]=0.0;
				}
			}
		}
		return result;
	}
	
	public double calcDistance(DataPoint x,DataPoint y){
		double result=0.0;
		double sum=0.0;
		//TODO check dimension length
		for(int i=0; i<=x.getNumberOfDimensions()-1; i++){
			double diff= x.getDimensionN(i)-y.getDimensionN(i);
			double square= diff*diff;
			sum=sum+square;
		}
		result=Math.sqrt(sum);
		return result;
	}
}
	
