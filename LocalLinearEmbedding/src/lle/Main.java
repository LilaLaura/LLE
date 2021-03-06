package lle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Jama.EigenvalueDecomposition;
import Jama.Matrix;

public class Main {
	public static void main(String[] args) { 
		//specify source file for parsing
		File myFile = new File("testData/Tests.csv");
		
		//Initialize MyParser
		MyParser parser = new MyParser(myFile);
		
		//parse source file
		ArrayList<DataPoint> myDataPoints = parser.parseFile2DataPoints();

		//Initialize LLE class which will do the computing
		LLE myLLE = new LLE(myDataPoints,2,2);
		Matrix embeddedMatrix= new Matrix(myLLE.embeddingMatrix);
		ExtDataPoint myExtDataPoint= new ExtDataPoint(myDataPoints.get(0).getAllDimensions(), 2);
		
		
		File outputfile = new File ("testData/output.csv");
		try {
			PrintWriter printWriter=new PrintWriter(outputfile);
			for(int i=0; i<=myLLE.embeddingMatrix.length-1; i++){
				String temp="";
				for(int j=0; j<=myLLE.embeddingMatrix[0].length-1; j++){
					temp+= myLLE.embeddingMatrix[i][j];
					temp+=";";
				}
				printWriter.write(temp+"\r\n");
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block   
			e.printStackTrace();
		}    
		//TODO tell myLLE to do some fancy calculating
//		Matrix distancematrix= new Matrix(myLLE.distances);
//		distancematrix.print(5, 2);
//		Matrix neighbor= new Matrix(myLLE.dataWithNeighbors.get(3).neighborMatrix);
//		neighbor.print(4, 2);
//		Matrix subtract= new Matrix(myLLE.dataWithNeighbors.get(3).subtractedNeighborMatrix);
//		subtract.print(4, 2);
//		Matrix covariance= new Matrix(myLLE.dataWithNeighbors.get(3).covarianceNeighborMatrix);
//		covariance.print(2, 5);
//		Matrix linVec= new Matrix(myLLE.dataWithNeighbors.get(3).linearVector,1);
//		linVec.print(5,5);
//		Matrix weightmatrix= new Matrix(myLLE.weightMatrix);
//		weightmatrix.print(5, 5);
//		Matrix sparsematrix= new Matrix(myLLE.sparseMatrix);
//		sparsematrix.print(5, 5);
		embeddedMatrix.print(5, 5);
	}
}
