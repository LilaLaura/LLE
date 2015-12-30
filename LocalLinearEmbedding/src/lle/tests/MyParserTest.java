package lle.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import lle.MyParser;

public class MyParserTest {

	@Test
	public void testParseRow() {
		//given
		String testData = "1.0;2.1;3.2;"; 
		MyParser testParser = new MyParser(new File(""));
		//when
		ArrayList<double> output = testParser.parseSingleRow(testData);
		//then
		assert output.get(0) == 1.0;
		assert output.get(1) == 2.1;
		assert output.get(2) == 3.2;
		
	}
	@Test
	public void testParseString() {
		//given
		String testData = "NaN; ;3.2;"; 
		MyParser testParser = new MyParser(new File(""));
		//when
		ArrayList<double> output = testParser.parseSingleRow(testData);
		//then
		assert output.get(0) == 0.0;
		assert output.get(1) == 0.0;
		assert output.get(2) == 3.2;
		
	}
	public void testParseFile(){
		//given
		
		
	}

}
