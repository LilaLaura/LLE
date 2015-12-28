/**
 * 
 */
package lle;

import java.util.ArrayList;

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
	public Double[][] neighborMatrix;
	Integer counter;
	
	public ExtDataPoint(ArrayList<Double> dimensions,Integer k) {
		super(dimensions);
		neighborMatrix= new Double[k][dimensions.size()];
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
	public void addNeighbor(DataPoint neighbor){
		for(int i=0; i<neighbor.getNumberOfDimensions(); i++){
			neighborMatrix[counter][i]=neighbor.getDimensionN(i);
		}
		counter++;
	}

}
