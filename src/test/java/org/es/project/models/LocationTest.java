package org.es.project.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LocationTest {
	Location locat1;
	Location locat2;

	@Before
	public void initialization() {
		locat1 = new Location(100.012, 67.987);
		locat1 = new Location(30.0132, 39.708);

	}

	@Test
	public void constructorTest() {
		Assert.assertEquals(locat1.getLatitude(), 67.987, 0.00001);
		Assert.assertEquals(locat1.getLongitude(), 100.012, 0.00001);

	}

	@Test
	public void getLongitudeTest() {
		Assert.assertEquals(locat1.getLongitude(), 100.012, 0.00001);
		Assert.assertEquals(locat2.getLongitude(), 30.0132, 0.00001);

	}

	@Test
	public void getLatitudeTest() {
		Assert.assertEquals(locat1.getLatitude(), 67.987, 0.00001);
		Assert.assertEquals(locat2.getLatitude(), 39.708, 0.00001);

	}

}
