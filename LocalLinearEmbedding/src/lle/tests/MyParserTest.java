package lle.tests;



import java.io.File;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

import lle.MyParser;

public class MyParserTest {

	@Test
	public void testParseRow() {
		//given
		String testData = "1.0;2.1;3.2;"; 
		MyParser testParser = new MyParser(new File(""));
		//when
		double[] output = testParser.parseSingleRow(testData);
		//then
		assertEquals(1.0 ,output[0], 0.00000001);
		assertEquals(2.1 ,output[1], 0.00000001);
		assertEquals(3.2 ,output[2], 0.00000001);
		
	}
	@Test
	public void testParseString() {
		//given
		String testData = "NaN; ;3.2;"; 
		MyParser testParser = new MyParser(new File(""));
		//when
		double[] output = testParser.parseSingleRow(testData);
		//then
		assertEquals(0.0 ,output[0], 0.00000001);
		assertEquals(0.1 ,output[1], 0.00000001);
		assertEquals(3.2 ,output[2], 0.00000001);		
	}

}
