package lle;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner; 


public class LLE {
	ArrayList<DataPoint> data;
	ArrayList<DataPoint> neighbors;
	
	public LLE(ArrayList<DataPoint> data) {
		super();
		this.data = data;
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
	
