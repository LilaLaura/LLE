package lle;

import java.util.ArrayList;


public class LLE {
	ArrayList<DataPoint> data;
	Double[][] distances;
	
	/* constructor
	 * stores a list of DataPoint
	 * create and stores distance matrix
	 */
	public LLE(ArrayList<DataPoint> data) {
		super();
		//ensure input data is not null, this would raise a nullPointerException
		if( data != null)
		{
			this.data = data;
			this.distances = this.calcDistanceMatrix(data);
		}
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
	public void findNeighbours(){
		
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
	
