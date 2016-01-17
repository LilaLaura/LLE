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
                double[] parsedRow = this.parseSingleRow(oneRow);
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
	 * parse a single row to a list of double's
	 */
	public double[] parseSingleRow(String aRow){
		
		//get the number of columns 
		int i = 0;
		String[] temp = aRow.split(";");
		i= temp.length;
		
		//initialize result list		
		double[] result = new double[i];
        
    	//process the file row by row using the Scanner class
		Scanner scanner = new Scanner(aRow);
    	//specify the delimiter that is used within a row
    	//TODO make this dynamic
    	scanner.useDelimiter(";");
    	int j=0;
        while (scanner.hasNext()) { 
        	//add each field of the row to the result list
        	double oneField = 0.0;
        	String oneField2 = scanner.next();
        	try{
        		oneField=Double.parseDouble(oneField2);
        	}
    		catch(Exception e){
    			oneField=0.0;
    		}
    		
            System.out.println("double value: " + oneField);
        	result[j] = oneField;
        	j++;
        } 
        scanner.close(); 
		return result;
	}
	
	//TODO implement
	public void close(){
		//this.destroy();
	}
}
