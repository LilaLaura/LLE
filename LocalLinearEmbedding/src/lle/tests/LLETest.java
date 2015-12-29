package lle.tests;

import static org.junit.Assert.assertEquals;

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
		Double expectedA = 2.449489742783178;
		assertEquals(expectedA,output);		
				
				
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
		Double expectedA = 0.0;
		assertEquals(dist[0][0], expectedA);
		assertEquals(dist[1][1], expectedA);
		assertEquals(dist[2][2], expectedA);
		Double expectedB = 9.0;
		assertEquals(dist[0][1], expectedB);
		assertEquals(dist[1][0], expectedB);
		assertEquals(dist[2][0], expectedB);
		assertEquals(dist[0][2], expectedB);
		Double expectedC = 18.0;
		assertEquals(dist[1][2], expectedC);
		assertEquals(dist[2][1], expectedC);
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
		Double expectedA = 1.0;
		assertEquals(b.neighborMatrix[0][0], expectedA);
		Double expectedB = 2.0;
		assertEquals(b.neighborMatrix[0][1], expectedB);
		Double expectedC = 3.0;
		assertEquals(b.neighborMatrix[0][2], expectedC);
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
		Integer expectedA = 0;
		assertEquals(c[0], expectedA);
		Integer expectedB = 3;
		assertEquals(c[1], expectedB);
		Integer expectedC = 2;
		assertEquals(c[2], expectedC);
		Integer expectedD = 4;
		assertEquals(c[3], expectedD);
		Integer expectedE = 1;
		assertEquals(c[4], expectedE);
	}
	
	@Test
	public void TestFindAllNeighbor(){
	//given
		ArrayList<Double> za =new ArrayList<Double>();
		za.add(1.0);
		za.add(2.0);
		za.add(3.0);
		DataPoint ad= new DataPoint(za);
		ArrayList<Double> zb =new ArrayList<Double>();
		zb.add(1.0);
		zb.add(1.0);
		zb.add(1.0);
		DataPoint bd= new DataPoint(zb);
		ArrayList<DataPoint> zc =new ArrayList<DataPoint>();
		zc.add(ad);
		zc.add(bd);
		LLE d= new LLE(null,0);
		Double[][] e= d.calcDistanceMatrix(zc);
	//when
		ArrayList<ExtDataPoint> f= d.findAllNeighbors(1, zc, e);
	//then
		assertEquals(2,f.size());
	}
}
