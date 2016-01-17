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
		LLE myLLE = new LLE(myDataPoints, 25,3);
		Matrix embeddedMatrix= new Matrix(myLLE.embeddingMatrix);
		
		File outputfile = new File ("testData/output.csv");
	    PrintWriter printWriter;
		try {
			printWriter = new PrintWriter (outputfile);
			embeddedMatrix.print(printWriter, 3, 5);
			 printWriter.close ();    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block   
			e.printStackTrace();
		}    
		//TODO tell myLLE to do some fancy calculating

		
    }
}
