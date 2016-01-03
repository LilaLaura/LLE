package lle;

import java.util.ArrayList;


public class LLE {
	ArrayList<DataPoint> data;
	double[][] distances;
	ArrayList<ExtDataPoint> dataWithNeighbors;
	
	/* constructor 
	 * 
	 * @param k number of expected neighbors
	 */
	public LLE(ArrayList<DataPoint> data, int k) {
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
		}
	}
	
	public void createAllSparseMatrix(ArrayList<ExtDataPoint> data){
		for(int i=0; i<=data.size()-1; i++){
			data.get(i).createSparseMatrix();
		}
	}
	
	public void costructAllWeightMatrix(ArrayList<ExtDataPoint> data){
		for(int i=0; i<=data.size()-1; i++){
			double[][] weightMatrix=this.constructWeightMatrix(data, i);
			data.get(i).weightMatrix=weightMatrix;
		}
	}
	
	public double[][] constructWeightMatrix(ArrayList<ExtDataPoint> data, int i){
		double[] linearVector= data.get(i).linearVector;
		double[][] weightMatrix= new double[linearVector.length][data.size()-1];
		for(int j=0; j<=data.size()-1; j++){
			for(int h=0; h<=linearVector.length-1; h++){
				if(data.get(i).isNeighbor(data.get(j))){
					weightMatrix[h][j]=linearVector[h];
				}
				else{
					weightMatrix[h][j]=0;
				}
			}
			
		}
		return weightMatrix; //weightmatrix for datapoint i
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
	
	public void subractAllRows(ArrayList<ExtDataPoint> data){
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
			ArrayList<Integer> neighbors=this.findNeighbours(k,i, distances);
			ExtDataPoint temp= new ExtDataPoint(data.get(i).getAllDimensions(),k);
			for(int j=0; j<neighbors.size(); j++){
				temp.addNeighbor(data.get(neighbors.get(j)));
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
	public ArrayList<Integer> findNeighbours(int k, int i, double[][] distances){
		ArrayList<Integer> result = null;
		Integer[] sortedList = this.BubbleSort(distances[i]);
		for (int j = 1; j < k + 1; j++) {
			result.add(sortedList[j]);
		}
		return result;
	}
		public Integer[] BubbleSort(double[] b){
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
			System.out.println("k=: "+data.get(i).getNumberOfDimensions());
			for(int j=0; j<=data.get(i).getNumberOfDimensions()-1; j++){
				System.out.println("j=: "+j);
				if(j!=i){
					System.out.println("distance=: "+calcDistance(data.get(i),data.get(j-1)));
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
		for(int i=0; i<x.getNumberOfDimensions(); i++){
			double diff= x.getDimensionN(i)-y.getDimensionN(i);
			double square= diff*diff;
			sum=sum+square;
		}
		result=Math.sqrt(sum);
		return result;
	}
}
	
