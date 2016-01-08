package lle.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import lle.DataPoint;
import lle.ExtDataPoint;

public class ExtDataPointTest {

	@Test
	public void testIsNeighborTrue() {
		//given
//		double[] dimensionSet1 = {1.,2.,3.};
//		ExtDataPoint point1 = new ExtDataPoint(dimensionSet1, 1);
//		double[] dimensionSet2 = {2.,3.,4.};
//		ExtDataPoint point2 = new ExtDataPoint(dimensionSet2, 1);
//		double[] dimensionSet3 = {3.,4.,5.};
//		ExtDataPoint point3 = new ExtDataPoint(dimensionSet3, 1);
//		ArrayList<ExtDataPoint> dataSet = new ArrayList<ExtDataPoint>();
//		dataSet.add(point1);
//		dataSet.add(point2);
//		dataSet.add(point3);
	}
	
	@Test
	public void testIsNeighborFalse() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddNeighbor() {
		//given
			double[] a =new double[3];
			a[0]=1.0;
			a[1]=2.0;
			a[2]=3.0;
			ExtDataPoint b= new ExtDataPoint(a,1);
			DataPoint c= new DataPoint(a);
		//when
			b.addNeighbor(c);
		//then
			assertEquals(1.0, b.neighborMatrix[0][0], 0.00000001);
			assertEquals(2.0, b.neighborMatrix[1][0], 0.00000001);
			assertEquals(3.0, b.neighborMatrix[2][0], 0.00000001);
	}

	@Test
	public void testMatrixSubtraction() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcCovariance() {
		fail("Not yet implemented");
	}

	@Test
	public void testSolveLinearSystem() {
		fail("Not yet implemented");
	}

}
