package lle.tests;



import java.util.ArrayList;

import lle.DataPoint;
import lle.ExtDataPoint;
import lle.LLE;

import org.junit.Test;

import Jama.Matrix;
import static org.junit.Assert.*;

public class LLETest {
	
	@Test
	public void testEmbeddingMatrix() {
		fail("Not yet implemented");
//		//given
//		double[][] a= {{3./2,-7./6,1./2,-1.,-2.3},{-7./6,14./9,-3./4,1./2,1./9},{1./2,-3./4,13./8,-1./4,-1./3},{-1.,1./2,-1./4,3./2,-1./6},{-2./3,1./9,-1./3,-1./6,14./9}};
		
	}

	@Test
	public void testCalcSmallestEigenValues() {
		//given
		double[][] a= {{3./2,-7./6,1./2,-1.,-2./3},{-7./6,14./9,-3./4,1./2,1./9},{1./2,-3./4,13./8,-1./4,-1./3},{-1.,1./2,-1./4,3./2,-1./6},{-2./3,1./9,-1./3,-1./6,14./9}};
		LLE f= new LLE(null,0);
		//when
		Integer[] smallestEigenValues=f.calcSmallestEigenValues(a,2);
		//then
		assertEquals(0,smallestEigenValues[0],0.00000001);
		assertEquals(1,smallestEigenValues[1],0.00000001);
		assertEquals(2,smallestEigenValues[2],0.00000001);
	}

	@Test
	public void testCalcSparseMatrix() {
		//given
		double[][] a= {{0.,0.,2.,0.,1.},{1.,0.,0.,0.,1.},{0.,1.,0.,3.,0.},{2.,0.,0.,0.,0.},{0.,3.,4.,1.,0.}};
		LLE f= new LLE(null,0);
		//when
		double[][] M= f.calcSparseMatrix(a);
		//then
		assertEquals(6.0, M[0][0], 0.00000001);
		assertEquals(-1.0, M[1][0], 0.00000001);
		assertEquals(-2.0, M[2][0], 0.00000001);
		assertEquals(-2.0, M[3][0], 0.00000001);
		assertEquals(0.0, M[4][0], 0.00000001);
		assertEquals(-1.0, M[0][1], 0.00000001);
		assertEquals(11.0, M[1][1], 0.00000001);
		assertEquals(11.0, M[2][1], 0.00000001);
		assertEquals(6.0, M[3][1], 0.00000001);
		assertEquals(-4.0, M[4][1], 0.00000001);
		assertEquals(-2.0, M[0][2], 0.00000001);
		assertEquals(11.0, M[1][2], 0.00000001);
		assertEquals(21.0, M[2][2], 0.00000001);
		assertEquals(1.0, M[3][2], 0.00000001);				
		assertEquals(-2.0, M[4][2], 0.00000001);
		assertEquals(-2.0, M[0][3], 0.00000001);
		assertEquals(6.0, M[1][3], 0.00000001);
		assertEquals(1.0, M[2][3], 0.00000001);
		assertEquals(11.0, M[3][3], 0.00000001);
		assertEquals(-1.0, M[4][3], 0.00000001);
		assertEquals(0.0, M[0][4], 0.00000001);
		assertEquals(-4.0, M[1][4], 0.00000001);
		assertEquals(-2.0, M[2][4], 0.00000001);
		assertEquals(-1.0, M[3][4], 0.00000001);
		assertEquals(3.0, M[4][4], 0.00000001);
	}

	@Test
	public void testConstructWeightMatrix() {
		//given
		double[] za =new double[3];
		za[0]=0.0;
		za[1]=0.0;
		za[2]=0.0;
		ExtDataPoint ad= new ExtDataPoint(za,2);
		DataPoint dad= new DataPoint(za);
		double[] zb =new double[3];
		zb[0]=1.0;
		zb[1]=1.0;
		zb[2]=1.0;
		ExtDataPoint bd= new ExtDataPoint(zb,2);
		DataPoint dbd= new DataPoint(zb);
		double[] zc =new double[3];
		zc[0]=2.0;
		zc[1]=2.0;
		zc[2]=2.0;
		ExtDataPoint cd= new ExtDataPoint(zc,2);
		DataPoint dcd= new DataPoint(zc);
		double[] zd =new double[3];
		zd[0]=3.0;
		zd[1]=3.0;
		zd[2]=3.0;
		ExtDataPoint dd= new ExtDataPoint(zd,2);
		DataPoint ddd=new DataPoint(zd);
		double[] ze= new double[3];
		ze[0]=4.0;
		ze[1]=4.0;
		ze[2]=4.0;
		ExtDataPoint ed= new ExtDataPoint(ze,2);
		DataPoint ded= new DataPoint(ze);
		ad.addNeighbor(dbd);
		ad.addNeighbor(ddd);
		bd.addNeighbor(dcd);
		bd.addNeighbor(ded);
		cd.addNeighbor(dad);
		cd.addNeighbor(ded);
		dd.addNeighbor(dcd);
		dd.addNeighbor(ded);
		ed.addNeighbor(dad);
		ed.addNeighbor(dbd);
		ad.linearVector[0]=1.;
		ad.linearVector[1]=2.;
		bd.linearVector[0]=1.;
		bd.linearVector[1]=3.;
		cd.linearVector[0]=2.;
		cd.linearVector[1]=4.;
		dd.linearVector[0]=3.;
		dd.linearVector[1]=1.;
		ed.linearVector[0]=1.;
		ed.linearVector[1]=1.;
		ArrayList<ExtDataPoint> data= new ArrayList<ExtDataPoint>();
		data.add(ad);
		data.add(bd);
		data.add(cd);
		data.add(dd);
		data.add(ed);
		LLE d= new LLE(null,0);
		//when
		double[][] weight=d.constructWeightMatrix(data);
		//then
		assertEquals(0.0, weight[0][0], 0.00000001);
		assertEquals(1.0, weight[1][0], 0.00000001);
		assertEquals(0.0, weight[2][0], 0.00000001);
		assertEquals(2.0, weight[3][0], 0.00000001);
		assertEquals(0.0, weight[4][0], 0.00000001);
		assertEquals(0.0, weight[0][1], 0.00000001);
		assertEquals(0.0, weight[1][1], 0.00000001);
		assertEquals(1.0, weight[2][1], 0.00000001);
		assertEquals(0.0, weight[3][1], 0.00000001);
		assertEquals(3.0, weight[4][1], 0.00000001);
		assertEquals(2.0, weight[0][2], 0.00000001);
		assertEquals(0.0, weight[1][2], 0.00000001);
		assertEquals(0.0, weight[2][2], 0.00000001);
		assertEquals(0.0, weight[3][2], 0.00000001);
		assertEquals(4.0, weight[4][2], 0.00000001);
		assertEquals(0.0, weight[0][3], 0.00000001);
		assertEquals(0.0, weight[1][3], 0.00000001);
		assertEquals(3.0, weight[2][3], 0.00000001);
		assertEquals(0.0, weight[3][3], 0.00000001);
		assertEquals(1.0, weight[4][3], 0.00000001);
		assertEquals(1.0, weight[0][4], 0.00000001);
		assertEquals(1.0, weight[1][4], 0.00000001);
		assertEquals(0.0, weight[2][4], 0.00000001);
		assertEquals(0.0, weight[3][4], 0.00000001);
		assertEquals(0.0, weight[4][4], 0.00000001);
		
	}

	@Test
	public void testFindAllNeighbors() {
		//given
			double[] za =new double[3];
			za[0]=1.0;
			za[1]=2.0;
			za[2]=3.0;
			DataPoint ad= new DataPoint(za);
			double[] zb =new double[3];
			zb[0]=1.0;
			zb[1]=1.0;
			zb[2]=1.0;
			DataPoint bd= new DataPoint(zb);
			double[] zd =new double[3];
			zd[0]=0.0;
			zd[1]=1.0;
			zd[2]=1.0;
			DataPoint dd= new DataPoint(zd);
			double[] ze =new double[3];
			ze[0]=5.0;
			ze[1]=7.0;
			ze[2]=9.0;
			DataPoint ed= new DataPoint(ze);
			ArrayList<DataPoint> zc =new ArrayList<DataPoint>();
			zc.add(ad);
			zc.add(bd);
			zc.add(dd);
			zc.add(ed);
			LLE d= new LLE(null,0);
			double[][] e= d.calcDistanceMatrix(zc);
		//when
			ArrayList<ExtDataPoint> f= d.findAllNeighbors(2, zc, e);
		//then
			assertEquals(4,f.size());
			assertTrue(f.get(0).isNeighbor(bd));
			assertTrue(f.get(0).isNeighbor(dd));
			assertFalse(f.get(0).isNeighbor(ed));
			assertTrue(f.get(1).isNeighbor(ad));
			assertTrue(f.get(1).isNeighbor(dd));
			assertFalse(f.get(1).isNeighbor(ed));
			assertTrue(f.get(2).isNeighbor(ad));
			assertTrue(f.get(2).isNeighbor(bd));
			assertFalse(f.get(2).isNeighbor(ed));
			assertTrue(f.get(3).isNeighbor(ad));
			assertTrue(f.get(3).isNeighbor(bd));
			assertFalse(f.get(3).isNeighbor(dd));
	}

	@Test
	public void testFindNeighbours() {
		//given
		double[] za =new double[3];
		za[0]=1.0;
		za[1]=2.0;
		za[2]=3.0;
		DataPoint ad= new DataPoint(za);
		double[] zb =new double[3];
		zb[0]=1.0;
		zb[1]=1.0;
		zb[2]=1.0;
		DataPoint bd= new DataPoint(zb);
		double[] zd= new double[3];
		zd[0]=9.0;
		zd[1]=4.0;
		zd[2]=7.0;
		DataPoint dd= new DataPoint(zd);
		ArrayList<DataPoint> zc =new ArrayList<DataPoint>();
		zc.add(ad);
		zc.add(bd);
		zc.add(dd);
		LLE d= new LLE(null,0);
		double[][] e= d.calcDistanceMatrix(zc);
	//when
		Integer[] f= d.findNeighbours(1, 1, e);
	//then
		assertEquals(1,f.length);
		assertEquals(0,f[0].intValue());
	}

	@Test
	public void testBubbleSort() {
		//given
				LLE a= new LLE(null,0);
				double[] b= new double[5];
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
	public void testCalcDistanceMatrix() {
		//given
				double[] a= {0.0,0.0,0.0};
				DataPoint x= new DataPoint(a);
				double[] b= {-8.0,-4.0,-1.0};
				DataPoint y= new DataPoint(b);
				double[] c = {8.,4.,1.};
				DataPoint z= new DataPoint(c);
				ArrayList<DataPoint>g= new ArrayList<DataPoint>();
				g.add(x);
				g.add(y);
				g.add(z);
				LLE MyLLE = new LLE (null, 0);
				//when
				double[][] dist = MyLLE.calcDistanceMatrix( g );
				//then
				assertEquals(0.0, dist[0][0], 0.00000001);
				assertEquals(0.0, dist[1][1], 0.00000001);
				assertEquals(0.0, dist[2][2], 0.00000001);
				assertEquals(9.0, dist[0][1], 0.00000001);
				assertEquals(9.0, dist[1][0], 0.00000001);
				assertEquals(9.0, dist[2][0], 0.00000001);
				assertEquals(9.0, dist[0][2], 0.00000001);
				assertEquals(18.0, dist[1][2], 0.00000001);
				assertEquals(18.0, dist[2][1], 0.00000001);
	}

	@Test
	public void testCalcDistance() {
		//given
		double[] a= {5.,4.,8.};
		DataPoint x= new DataPoint(a);
		double[] b= {4.,3.,6.};		
		DataPoint y= new DataPoint(b);
		LLE MyLLE = new LLE (null, 0);
		//when
		double output= MyLLE.calcDistance(x, y);
		//then
		double expectedA = 2.449489742783178;
		assertEquals(expectedA,output , 0.00000001);
	}
}
