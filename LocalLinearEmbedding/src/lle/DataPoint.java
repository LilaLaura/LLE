package lle;

import java.util.ArrayList;

public class DataPoint {
	private ArrayList<Double> dimensions;
	
	public DataPoint(ArrayList<Double> dimensions) {
		super();
		this.dimensions = dimensions;
	}

	public ArrayList<Double> getAllDimensions(){
		return this.dimensions;
	}
	
	public Double getDimensionN(int n){
		return this.dimensions.get(n);
	}
	
	public int getNumberOfDimensions(){
		return this.dimensions.size();
	}
}
