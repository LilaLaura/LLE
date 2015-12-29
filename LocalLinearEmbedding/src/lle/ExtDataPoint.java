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
	public Double[][]subtractedNeighborMatrix;

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
	
	public Double[][] matrixSubtraction(ArrayList<Double> dimensions, Double[][] neighbor){
		Double[][] result = neighbor;
		for(int i=0; i< neighbor.length; i++){
			for(int j=0; j<neighbor[0].length; j++){
				result[i][j]=neighbor[i][j]-dimensions.get(j);
			}
		}
		return result;
	}
	
	public void doSubtraction(){
		this.subtractedNeighborMatrix=this.matrixSubtraction(super.getAllDimensions(), this.neighborMatrix);
	}
	

}
