package lle;

import java.util.ArrayList;


public class LLE {
	ArrayList<DataPoint> data;
	Double[][] distances;
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
	
	/*
	 * find all neighbors for all DataPoints
	 * @param k number of expected neighbors
	 */
	public ArrayList<ExtDataPoint> findAllNeighbors(int k, ArrayList<DataPoint> data, Double[][] distances){
		ArrayList<ExtDataPoint> result = new ArrayList<ExtDataPoint>();
		
		return result;
		
	}
	
	/*
	 * find all neighbors for a single DataPoint
	 * @param k number of expected neighbors
	 * @param i index of the "home"-DataPoint
	 * @param distances distance matrix for neighbor calculation
	 */
	public Integer findNeighbours(int k, int i, Double[][] distances){
		Integer result = null;
		
		
		return result;
	}

	/*
	 * calculates the distance matrix for a given set of DataPoint
	 * TODO optimize! Distance matrices are symmetric therefore calculating
	 * distances twice could be avoided
	 */
	public Double[][] calcDistanceMatrix( ArrayList<DataPoint> data ){
		Double[][] result = new Double[data.size()][data.size()];
		for(int i=0; i<data.size()-1; i++){
			for(int j=0; j<data.size()-1; j++){
				if(j!=i){
					result[i][j]=calcDistance(data.get(i),data.get(j));
				}
				else{
					result[i][j]=0.0;
				}
			}
			
		}
		return result;
	}
	
	public Double calcDistance(DataPoint x,DataPoint y){
		Double result=0.0;
		Double sum=0.0;
		//TODO check dimension length
		for(int i=0; i<x.getNumberOfDimensions(); i++){
			Double diff= x.getDimensionN(i)-y.getDimensionN(i);
			Double square= diff*diff;
			sum=sum+square;
		}
		result=Math.sqrt(sum);
		return result;
	}
}
	
