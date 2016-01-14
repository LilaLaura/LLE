package lle.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import lle.DataPoint;
import lle.ExtDataPoint;

public class ExtDataPointTest {

	@Test
	public void testIsNeighbor() {
		//given
		double[] dimensionSet1 = {1.,2.,3.};
		ExtDataPoint point1 = new ExtDataPoint(dimensionSet1, 1);
		double[] dimensionSet2 = {2.,3.,4.};
		DataPoint point2 = new DataPoint(dimensionSet2);
		double[] dimensionSet3 = {3.,4.,5.};
		DataPoint point3 = new DataPoint(dimensionSet3);
		point1.addNeighbor(point2);
		//when
		boolean test1 = point1.isNeighbor(point2);
		boolean test2 = point1.isNeighbor(point3);
		//then
		assertTrue("Point2 is a not neighbor", test1);
		assertFalse("Point3 is a neighbor", test2);
		
	}

	@Test
	public void testAddNeighbor() {
		//given
			double[] a =new double[3];
			a[0]=1.0;
			a[1]=2.0;
			a[2]=3.0;
			ExtDataPoint b= new ExtDataPoint(a, 1);
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
		//given
		double[] dimensionSet1 = {1.,1.,1.};
		double[][] distanceMatrix = new double[3][3];
		distanceMatrix[0][0] = 2.;
		distanceMatrix[1][0] = 3.;
		distanceMatrix[2][0] = 4.;
		distanceMatrix[0][1] = 2.5;
		distanceMatrix[1][1] = 3.5;
		distanceMatrix[2][1] = 4.5;
		distanceMatrix[0][2] = 2.75;
		distanceMatrix[1][2] = 3.75;
		distanceMatrix[2][2] = 4.75;
		//just initializing a ExtDataPoint to call the function; values does not matter
		ExtDataPoint a = new ExtDataPoint(dimensionSet1, 1);
		//when
		double[][] result = a.matrixSubtraction(dimensionSet1, distanceMatrix);
		//then
		assertEquals(1., result[0][0], 0.00000001);
		assertEquals(2., result[1][0], 0.00000001);
		assertEquals(3., result[2][0], 0.00000001);
		assertEquals(1.5, result[0][1], 0.00000001);
		assertEquals(2.5, result[1][1], 0.00000001);
		assertEquals(3.5, result[2][1], 0.00000001);
		assertEquals(1.75, result[0][2], 0.00000001);
		assertEquals(2.75, result[1][2], 0.00000001);
		assertEquals(3.75, result[2][2], 0.00000001);
	}

	@Test
	public void testCalcCovariance() {
		//given
		double[] dimensionSet1 = {1.,1.,1.};
		double[][] subtractedNeighborMatrix = new double[3][3];
		subtractedNeighborMatrix[0][0] = 2.;
		subtractedNeighborMatrix[1][0] = 3.;
		subtractedNeighborMatrix[2][0] = 4.;
		subtractedNeighborMatrix[0][1] = 2.5;
		subtractedNeighborMatrix[1][1] = 3.5;
		subtractedNeighborMatrix[2][1] = 4.5;
		subtractedNeighborMatrix[0][2] = 2.75;
		subtractedNeighborMatrix[1][2] = 3.75;
		subtractedNeighborMatrix[2][2] = 4.75;
		//just initializing a ExtDataPoint to call the function; values does not matter
		ExtDataPoint a = new ExtDataPoint(dimensionSet1, 1);
		//when
		double[][] result = a.calcCovariance(subtractedNeighborMatrix);
		//then
		assertEquals(29, result[0][0], 0.00000001);
		assertEquals(33.5, result[1][0], 0.00000001);
		assertEquals(35.75, result[2][0], 0.00000001);
		assertEquals(33.5, result[0][1], 0.00000001);
		assertEquals(38.75, result[1][1], 0.00000001);
		assertEquals(41.375, result[2][1], 0.00000001);
		assertEquals(35.75, result[0][2], 0.00000001);
		assertEquals(41.375, result[1][2], 0.00000001);
		assertEquals(44.1875, result[2][2], 0.00000001);
	}

	@Test
	public void testSolveLinearSystem() {
		double[] dimensionSet1 = {1.,1.,1.};
		double[][] covarianceNeighborMatrix = new double[3][3];
		covarianceNeighborMatrix[0][0] = 1.;
		covarianceNeighborMatrix[1][0] = 2.;
		covarianceNeighborMatrix[2][0] = 3.;
		covarianceNeighborMatrix[0][1] = 2.;
		covarianceNeighborMatrix[1][1] = 3.;
		covarianceNeighborMatrix[2][1] = 1.;
		covarianceNeighborMatrix[0][2] = 3.;
		covarianceNeighborMatrix[1][2] = 1.;
		covarianceNeighborMatrix[2][2] = 2.;
		//just initializing a ExtDataPoint to call the function; values does not matter
		ExtDataPoint a = new ExtDataPoint(dimensionSet1, 1);
		//when
		double[] result = a.solveLinearSystem(covarianceNeighborMatrix);
		//then
		assertEquals(1./6, result[0], 0.00000001);
		assertEquals(1./6, result[1], 0.00000001);
		assertEquals(1./6, result[2], 0.00000001);
	}

}
