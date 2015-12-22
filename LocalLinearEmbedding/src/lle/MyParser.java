package lle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyParser {
	private File dataFile;
	
	public MyParser(File dataFile) {
		super();
		this.dataFile = dataFile;
	}

	/* 
	 * parse a whole file to a list of DataPoint's
	*/
	public ArrayList<DataPoint> parseFile2DataPoints(){
		ArrayList<DataPoint> result = new ArrayList<DataPoint>();
		
		Scanner scanner; 
        try { 
        	            
        	//process the file row by row using the Scanner class
        	scanner = new Scanner(dataFile, "UTF-8");
            int i= 0; 
            while (scanner.hasNext()) { 
                String oneRow = scanner.next();
                //don't process the first line which is the table header
                if(i==0){
                	i++;
                	continue;
                }
                //parse the actual row
                ArrayList<Double> parsedRow = this.parseSingleRow(oneRow);
                //create a DataPoint based on the parsed row
                DataPoint newDataPoint = new DataPoint(parsedRow);
                //add new DataPoint to result list
                result.add(newDataPoint);                
            } 
            scanner.close(); 
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } 
        return result;
	}
	
	/*
	 * parse a single row to a list of Double's
	 */
	public ArrayList<Double> parseSingleRow(String aRow){
		//initialize result list
		ArrayList<Double> result = new ArrayList<Double>();
		
		Scanner scanner; 
        
    	//process the file row by row using the Scanner class
    	scanner = new Scanner(aRow);
    	//specify the delimiter that is used within a row
    	//TODO make this dynamic
    	scanner.useDelimiter(";");
    	System.out.println("new row: ");
        while (scanner.hasNext()) { 
        	//add each field of the row to the result list
        	Double oneField = 0.0;
        	String oneField2 = scanner.next();
        	try{
        		oneField=Double.parseDouble(oneField2);
        	}
    		catch(Exception e){
    			oneField=0.0;
    		}
    		
            System.out.println("double value: " + oneField);
        	result.add(oneField);
        	
        } 
        scanner.close(); 
		return result;
	}
	
	//TODO implement
	public void close(){
		//this.destroy();
	}
}
