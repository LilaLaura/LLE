package lle.tests;



import java.util.ArrayList;

import lle.DataPoint;
import lle.ExtDataPoint;
import lle.LLE;

import org.junit.Test;
import static org.junit.Assert.*;

public class LLETest {
	
	@Test
	public void testEmbeddingMatrix() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcSmallestEigenValues() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcSparseMatrix() {
		fail("Not yet implemented");
	}

	@Test
	public void testConstructWeightMatrix() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcAllLinearSystems() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcAllCovariance() {
		fail("Not yet implemented");
	}

	@Test
	public void testSubractAllRows() {
		fail("Not yet implemented");
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
