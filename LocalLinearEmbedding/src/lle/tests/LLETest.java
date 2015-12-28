package lle.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import lle.DataPoint;
import lle.ExtDataPoint;
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
		LLE MyLLE = new LLE (null, 0);
		//when
		Double output= MyLLE.calcDistance(x, y);
		//then
				assert output == 2.0;
				
				
	}
	
	@Test
	public void TestDistanceMatrics(){
		//given
		ArrayList<Double> a= new ArrayList<Double>();
		a.add(0.0);
		a.add(0.0);
		a.add(0.0);
		DataPoint x= new DataPoint(a);
		ArrayList<Double> b= new ArrayList<Double>();
		b.add(-8.0);
		b.add(-4.0);
		b.add(-1.0);
		DataPoint y= new DataPoint(b);
		ArrayList<Double> c= new ArrayList<Double>();
		c.add(8.0);
		c.add(4.0);
		c.add(1.0);
		DataPoint z= new DataPoint(c);
		ArrayList<DataPoint>g= new ArrayList<DataPoint>();
		g.add(x);
		g.add(y);
		g.add(z);
		LLE MyLLE = new LLE (null, 0);
		//when
		Double[][] dist = MyLLE.calcDistanceMatrix( g );
		//then
		assert dist[0][0] == 0.0;
		assert dist[1][1] == 0.0;
		assert dist[2][2] == 0.0;
		assert dist[0][1] == 1.0;
		assert dist[0][2] == 9.0;
		assert dist[1][0] == 9.0;
		assert dist[1][2] == 18.0;
		assert dist[2][0] == 9.0;
		assert dist[2][1] == 18.0;
	
		
	}
	
	@Test
	public void TestAddNeighbor(){
	//given
		ArrayList<Double> a =new ArrayList<Double>();
		a.add(1.0);
		a.add(2.0);
		a.add(3.0);
		ExtDataPoint b= new ExtDataPoint(a,2);
		DataPoint c= new DataPoint(a);
	//when
		b.addNeighbor(c);
	//then
		assert b.neighborMatrix[0][0]==1.0;
		assert b.neighborMatrix[0][1]==2.0;
		assert b.neighborMatrix[0][2]==3.0;
	}
	
	@Test
	public void TestBubbleSort(){
	//given
		LLE a= new LLE(null,0);
		Double[] b= new Double[5];
		b[0]=1.0;
		b[1]=6.0;
		b[2]=3.0;
		b[3]=2.0;
		b[4]=5.0;
	//when
		Integer[] c= a.BubbleSort(b);
	//then
		assert c[0]==0;
		assert c[1]==3;
		assert c[2]==2;
		assert c[3]==4;
		assert c[4]==2;
		
		
		
	}
}
