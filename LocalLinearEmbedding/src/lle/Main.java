package lle;

import java.io.File;
import java.util.ArrayList;

import Jama.Matrix;

public class Main {
	public static void main(String[] args) { 
		//specify source file for parsing
		File myFile = new File("testData/Minimal.csv");
		
		//Initialize MyParser
		MyParser parser = new MyParser(myFile);
		
		//parse source file
		ArrayList<DataPoint> myDataPoints = parser.parseFile2DataPoints();

		//Initialize LLE class which will do the computing
		LLE myLLE = new LLE(myDataPoints, 0);
		
		//TODO tell myLLE to do some fancy calculating
		double[][] array = {{1.,2.,3},{4.,5.,6.},{7.,8.,10.}};
		Matrix A = new Matrix(array);
		Matrix b = Matrix.random(3,1);
		Matrix x = A.solve(b);
		Matrix Residual = A.times(x).minus(b);
		double rnorm = Residual.normInf();
    }
}
