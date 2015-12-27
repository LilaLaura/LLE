package lle;

import java.io.File;
import java.util.ArrayList;

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
		
    }
}
