package lle.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import lle.DataPoint;
import lle.LLE;
import lle.MyParser;

import org.junit.Test;

public class LLETest {

	@Test
	public void TestDistance() {
		//given
		ArrayList<Double> a= new ArrayList<Double>();
		a.add(5.0);
		a.add(4.0);
		a.add(8.0);
		DataPoint x= new DataPoint(a);
		ArrayList<Double> b= new ArrayList<Double>();
		b.add(4.0);
		b.add(3.0);
		b.add(6.0);
		DataPoint y= new DataPoint(b);
		LLE MyLLE = new LLE (null);
		//when
		Double output= MyLLE.calcDistance(x, y);
		//then
				assert output == 2.0;
				
				
	}

}
