package org.es.project.models;

import org.junit.Assert;
import org.junit.Test;

public class LocationTest {

	@Test
	public void constructorTest() {
		Location locat = new Location(100.012, 67.987);
		Assert.assertEquals(locat.getLatitude(), 67.987, 0.00001);
		Assert.assertEquals(locat.getLongitude(), 100.012, 0.00001);

	}
}
