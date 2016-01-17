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
		double[][] a= {{3./2,-7./6,1./2,-1.,-2./3},{-7./6,14./9,-3./4,1./2,1./9},{1./2,-3./4,13./8,-1./4,-1./3},{-1.,1./2,-1./4,3./2,-1./6},{-2./3,1./9,-1./3,-1./6,14./9}};
		Matrix A = new Matrix(a);
		EigenvalueDecomposition B= new EigenvalueDecomposition(A);
		Matrix C = B.getD();
		C.print(3, 5);
		Matrix D = B.getV();
		D.print(3, 5);
		double[] E= B.getRealEigenvalues();
		
    }
}
