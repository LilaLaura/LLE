package lle.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import lle.DataPoint;

public class DataPointTest {

	@Test
	public void testGetAllDimensions() {
		//given
		double[] a = {1.,2.,3.};
		DataPoint b= new DataPoint(a);
		//when
		double[] c = b.getAllDimensions();
		//then
		assertEquals(1.,c[0], 0.00000001);
		assertEquals(2.,c[1], 0.00000001);
		assertEquals(3.,c[2], 0.00000001);
	}

	@Test
	public void testGetDimensionN() {
		//given
		double[] a = {1.,2.,3.};
		DataPoint b= new DataPoint(a);
		//when
		double c = b.getDimensionN(0);
		double d = b.getDimensionN(1);
		double e = b.getDimensionN(2);
		//then
		assertEquals(1.,c, 0.00000001);
		assertEquals(2.,d, 0.00000001);
		assertEquals(3.,e, 0.00000001);
	}

	@Test
	public void testGetNumberOfDimensions() {
		//given
		double[] a = {1.,2.,3.};
		DataPoint b= new DataPoint(a);
		//when
		double c = b.getNumberOfDimensions();
		//then
		assertEquals(3.,c, 0.00000001);
	}

}
