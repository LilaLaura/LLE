package lle;

import java.util.ArrayList;

public class DataPoint {
	private double[] dimensions;
	
	public DataPoint(double[] dimensions) {
		super();
		this.dimensions = dimensions;
	}

	public double[] getAllDimensions(){
		return this.dimensions;
	}
	
	public double getDimensionN(int n){
		return this.dimensions[n];
	}
	
	public int getNumberOfDimensions(){
		return this.dimensions.length;
	}
}
