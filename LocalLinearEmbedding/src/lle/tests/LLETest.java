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
	
	@Test
	public void TestDistanceMatrics(){
		//given
		ArrayList<Double> a= new ArrayList<Double>();
		a.add(5.0);
		a.add(4.0);
		a.add(8.0);
		DataPoint x= new DataPoint(a);
		ArrayList<Double> b= new ArrayList<Double>();
		b.add(4.0);
		b.add(2.0);
		b.add(6.0);
		DataPoint y= new DataPoint(b);
		//ArrayList<Double> c= new ArrayList<Double>();
		//c.add(3.0);
		//c.add(1.0);
		//c.add(4.0);
		//DataPoint z= new DataPoint(c);
		ArrayList<DataPoint>g= new ArrayList<DataPoint>();
		g.add(x);
		g.add(y);
		//g.add(z);
		LLE MyLLE = new LLE (g);
//		when
		Double[][] dist = MyLLE.calcDistanceMatrics();
		//then
		assert dist[0][0] == 0.0;
		assert dist[1][1] == 0.0;
		//assert dist[2][2] == 0.0;
		assert dist[0][1] == 3.0;
		//assert dist[0][2] == 3.0;
		assert dist[1][0] == 3.0;
		//assert dist[1][2] == 1.0;
		//assert dist[2][0] == 3.0;
		//assert dist[2][1] == 0.0;
		
	}
	

}
