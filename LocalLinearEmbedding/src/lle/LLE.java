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
	public ArrayList<ExtDataPoint> subractAllRows(ArrayList<ExtDataPoint> data){
		ArrayList<ExtDataPoint> result = new ArrayList<ExtDataPoint>();
		for(int i=0; i<data.size(); i++){
			
		}
		return result;
	}
	
		/*
	 * find all neighbors for all DataPoints
	 * @param k number of expected neighbors
	 */
	public ArrayList<ExtDataPoint> findAllNeighbors(int k, ArrayList<DataPoint> data, Double[][] distances){
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
	public ArrayList<Integer> findNeighbours(int k, int i, Double[][] distances){
		ArrayList<Integer> result = null;
		Integer[] sortedList = this.BubbleSort(distances[i]);
		for (int j = 1; j < k + 1; j++) {
			result.add(sortedList[j]);
		}
		return result;
	}
		public Integer[] BubbleSort(Double[] b){
			Double temp;
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
	public Double[][] calcDistanceMatrix( ArrayList<DataPoint> data ){
		Double[][] result = new Double[data.size()][data.size()];
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
	
