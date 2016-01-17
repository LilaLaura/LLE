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
		fail("Not yet implemented");
	}

	@Test
	public void testCalcAllLinearSystems() {
		fail("Not yet implemented");
//		//given
//		double[] dimensionSet1 = {1.,1.,1.};
//		double[] a= {1.,6.,3.};
//		ExtDataPoint x= new ExtDataPoint(a,3);
//		double[] b= {1.,5.,10.};
//		ExtDataPoint y= new ExtDataPoint(b,3);
//		double[] c= {7.,4.,9.};
//		ExtDataPoint z= new ExtDataPoint(c,3);
//		ArrayList<ExtDataPoint> g= new ArrayList<ExtDataPoint>();
//		g.add(x);
//		g.add(y);
//		g.add(z);
//		ExtDataPoint a = new ExtDataPoint(dimensionSet1, 1);
//		//when
//		double[] linSysVec= a.calcAllLinearSystems(g);
//		//then
//		assertEquals(0.1, linSysVec[0], 0.00000001);
//		assertEquals(0.0625, linSysVec[1], 0.00000001);
//		assertEquals(0.05, linSysVec[2], 0.00000001);
	}

	@Test
	public void testCalcAllCovariance() {
		fail("Not yet implemented");
//		//given
//		double[] a= {1.,2.,3.};
//		ExtDataPoint x= new ExtDataPoint(a,3);
//		double[] b= {4.,5.,6.};
//		ExtDataPoint y= new ExtDataPoint(b,3);
//		double[] c= {7.,8.,9.};
//		ExtDataPoint z= new ExtDataPoint(c,3);
//		ArrayList<ExtDataPoint> g= new ArrayList<ExtDataPoint>();
//		g.add(x);
//		g.add(y);
//		g.add(z);
//		LLE d= new LLE(null,0);
//		//when
//		double[][] covar= d.calcAllCovariance(g);
//		//then
//		assertEquals(66.0, covar[0][0], 0.00000001);
//		assertEquals(78.0, covar[1][0], 0.00000001);
//		assertEquals(90.0, covar[2][0], 0.00000001);
//		assertEquals(78.0, covar[0][1], 0.00000001);
//		assertEquals(93.0, covar[1][1], 0.00000001);
//		assertEquals(108.0, covar[2][1], 0.00000001);
//		assertEquals(90.0, covar[0][2], 0.00000001);
//		assertEquals(108.0, covar[1][2], 0.00000001);
//		assertEquals(126.0, covar[2][2], 0.00000001);
	}

	@Test
	public void testSubractAllRows() {
		fail("Not yet implemented");
//		//given
//		double[] a= {1.,4.,7.};
//		ExtDataPoint x= new ExtDataPoint(a,3);
//		double[] b= {2.,5.,8.};
//		ExtDataPoint y= new ExtDataPoint(b,3);
//		double[] c= {3.,6.,9.};
//		ExtDataPoint z= new ExtDataPoint(c,3);
//		double[] point={1.,2.,3.};
//		ExtDataPoint xi= new ExtDataPoint(point,3);
//		ArrayList<ExtDataPoint> g= new ArrayList<ExtDataPoint>();
//		g.add(x);
//		g.add(y);
//		g.add(z);
//		LLE d= new LLE(null,0);
//		//when
//		double[][] subtract= d.subtractAllRows(g);
//		//then
//		assertEquals(0.0, subtract[0][0], 0.00000001);
//		assertEquals(2.0, subtract[1][0], 0.00000001);
//		assertEquals(4.0, subtract[2][0], 0.00000001);
//		assertEquals(1.0, subtract[0][1], 0.00000001);
//		assertEquals(3.0, subtract[1][1], 0.00000001);
//		assertEquals(5.0, subtract[2][1], 0.00000001);
//		assertEquals(2.0, subtract[0][2], 0.00000001);
//		assertEquals(4.0, subtract[1][2], 0.00000001);
//		assertEquals(6.0, subtract[2][2], 0.00000001);
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
			ArrayList<DataPoint> zc =new ArrayList<DataPoint>();
			zc.add(ad);
			zc.add(bd);
			LLE d= new LLE(null,0);
			double[][] e= d.calcDistanceMatrix(zc);
		//when
			ArrayList<ExtDataPoint> f= d.findAllNeighbors(1, zc, e);
		//then
			assertEquals(2,f.size());
	}

	@Test
	public void testFindNeighbours() {
		fail("Not yet implemented");
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
