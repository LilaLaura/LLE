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
		File myFile = new File("testData/TestDaten.csv");
		
		//Initialize MyParser
		MyParser parser = new MyParser(myFile);
		
		//parse source file
		ArrayList<DataPoint> myDataPoints = parser.parseFile2DataPoints();

		//Initialize LLE class which will do the computing
		LLE myLLE = new LLE(myDataPoints, 15,3);
		Matrix embeddedMatrix= new Matrix(myLLE.embeddingMatrix);
		
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

		
    }
}
