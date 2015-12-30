package lle;

import java.io.File;
import java.util.ArrayList;

import Jama.EigenvalueDecomposition;
import Jama.Matrix;

public class Main {
	public static void main(String[] args) { 
//		//specify source file for parsing
//		File myFile = new File("testData/Minimal.csv");
//		
//		//Initialize MyParser
//		MyParser parser = new MyParser(myFile);
//		
//		//parse source file
//		ArrayList<DataPoint> myDataPoints = parser.parseFile2DataPoints();
//
//		//Initialize LLE class which will do the computing
//		LLE myLLE = new LLE(myDataPoints, 0);
		
		//TODO tell myLLE to do some fancy calculating
		double[][] array = {{1.,2.,3},{4.,5.,6.},{7.,8.,10.}};
		Matrix A = new Matrix(array);
		EigenvalueDecomposition B= new EigenvalueDecomposition(A);
		Matrix C = B.getD();
		C.print(3, 5);
		Matrix D = B.getV();
		D.print(3, 5);
		double[] E= B.getRealEigenvalues();
		
    }
}
