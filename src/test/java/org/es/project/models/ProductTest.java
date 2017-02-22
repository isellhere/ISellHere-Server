package org.es.project.models;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	private Product product1;
	private Product product2;
	private Product product3;
	private Product product4;

	PointOfSale point1;
	PointOfSale point2;
	PointOfSale point3;

	User creator1;
	User creator2;
	User creator3;

	@Before
	public void initialization() {
		User creator1 = new User("user 1", "user1@mail.com", "123456Brasil");
		User creator2 = new User("user 2", "user2@mail.com", "456789Brasil");
		User creator3 = new User("user 3", "user3@mail.com", "1234567896543@@@Brasil");

		point1 = new PointOfSale(creator1, "point 1", 500, 500);
		point2 = new PointOfSale(creator2, "point 2", 250, 250);
		point3 = new PointOfSale(creator3, "point 3", 15, 150);

		product1 = new Product(creator1, point1, "Heart", 10);
		product2 = new Product(creator2, point2, "Willpower", 1100.54, "Not worth the price");
		product3 = new Product(null, null, "no name", null, 0);
		product4 = new Product(creator3, point3, "Wabbajack", 1230, "Wabbajack", null);
	}

	@Test
	public void testConstructor1() {
		User tempUser = new User("user 1", "user1@mail.com", "123456Brasil");
		PointOfSale tempPoint = new PointOfSale(tempUser, "point 1", 500, 500);
		Assert.assertTrue(product1.getName().equals("Heart"));
		Assert.assertTrue(product1.getComment() == "");
		Assert.assertTrue(product1.getPrice() == 10);
		Assert.assertTrue(product1.getImage() == null);
		Assert.assertTrue(product1.getCreator().equals(tempUser));
		//Assert.assertEquals(product1.getPointOfSale(),new PointOfSale(creator1, "point 1", 500, 500));
		Assert.assertTrue(product1.getClass().equals(Product.class));

	}

	@Test
	public void testConstructor2() {

		Assert.assertTrue(product2.getName().equals("Willpower"));
		Assert.assertTrue(product2.getComment() == "Not worth the price");
		Assert.assertTrue(product2.getPrice() == 1100.54);
		Assert.assertTrue(product2.getImage() == null);
		Assert.assertEquals(product2.getCreator(), new User("user 2", "user2@mail.com", "456789Brasil"));
		// Assert.assertEquals(product2.getPointOfSale(),new PointOfSale(creator2, "point 2", 250, 250));
		Assert.assertTrue(product2.getClass().equals(Product.class));

	}

	@Test
	public void testConstructor3() {
		Assert.assertTrue(product3.getName().equals("no name"));
		Assert.assertTrue(product3.getComment() == "");
		Assert.assertTrue(product3.getPrice() == 0);
		Assert.assertTrue(product3.getImage() == null);
		Assert.assertTrue(product3.getCreator() == null);
		Assert.assertTrue(product3.getPointOfSale() == null);
		Assert.assertTrue(product3.getClass().equals(Product.class));

	}

	@Test
	public void testConstructor4() {
		Assert.assertTrue(product4.getName().equals("Wabbajack"));
		Assert.assertTrue(product4.getComment() == "Wabbajack");
		Assert.assertTrue(product4.getPrice() == 1230);
		Assert.assertTrue(product4.getImage() == null);
		Assert.assertTrue(product4.getCreator().equals(new User("user 3", "user3@mail.com", "1234567896543@@@Brasil")));
		// Assert.assertEquals(product3.getPointOfSale(),new PointOfSale(creator3, "point 3", 15, 150));
		Assert.assertTrue(product4.getClass().equals(Product.class));

	}

	@Test
	public void showProductGradeTest1() {
		product1.addEvaluation(10, "Maria");
		product1.addEvaluation(5, "Benicio");
		product1.addEvaluation(4, "Jose");
		Assert.assertEquals(product1.showProductGrade(), 19.0 / 3, 0.00001);
		product1.addEvaluation(9, "Chuck");
		product1.addEvaluation(8, "Blair");
		Assert.assertEquals(product1.showProductGrade(), 36.0 / 5, 0.00001);

	}

	@Test
	public void showProductGradeTest2() {
		product1.addEvaluation(10, "Wabbajack");
		product1.addEvaluation(5, "We exist");
		product1.addEvaluation(4, "The show must go on");
		Assert.assertEquals(product1.showProductGrade(), 19.0 / 3, 0.00001);
		product1.addEvaluation(9, "Despair");
		product1.addEvaluation(8, "Bello");
		Assert.assertEquals(product1.showProductGrade(), 36.0 / 5, 0.00001);

	}

	@Test
	public void showRecentCommentsTest1() {
		String[] strList = new String[3];

		product1.addEvaluation(10, "Maria");
		product1.addEvaluation(5, "Benicio");
		product1.addEvaluation(4, "Jose");
		Assert.assertArrayEquals(product1.showRecentComments(), strList);
		product1.addEvaluation(9, "Chuck");
		product1.addEvaluation(8, "Blair");
		Assert.assertArrayEquals(product1.showRecentComments(), strList);

	}

	@Test
	public void showRecentCommentsTest2() {
		String[] strList = new String[3];

		strList[2] = "Wabbajack";
		strList[1] = "Dementia";
		strList[0] = "Mania";
		product1.addEvaluation(10, "Wabbajack");
		product1.addEvaluation(5, "Dementia");
		product1.addEvaluation(4, "Mania");

		Assert.assertArrayEquals(product1.showRecentComments(), strList);

		product1.addEvaluation(9, "Destiny");
		product1.addEvaluation(8, "Fate");
		product1.showRecentComments();
		// strList[0] = "Mania";
		// strList[1] = "Destiny";
		// strList[2] = "Fate";
		// Assert.assertArrayEquals(product1.showRecentComments(), strList);

	}

	@Test
	public void getNameTest() {
		Assert.assertTrue(product1.getName().equals("Heart"));
		Assert.assertTrue(product2.getName().equals("Willpower"));
		Assert.assertTrue(product3.getComment() == "");
		Assert.assertTrue(product4.getName().equals("Wabbajack"));

	}

	@Test
	public void getCommentTest() {
		Assert.assertTrue(product1.getComment() == "");
		Assert.assertTrue(product2.getComment() == "Not worth the price");
		Assert.assertTrue(product4.getComment() == "Wabbajack");
		Assert.assertTrue(product4.getComment() == "Wabbajack");

	}

	@Test
	public void getPriceTest() {
		Assert.assertTrue(product1.getPrice() == 10);
		Assert.assertTrue(product2.getPrice() == 1100.54);
		Assert.assertTrue(product3.getPrice() == 0);
		Assert.assertTrue(product4.getPrice() == 1230);

	}

	@Test
	public void getCreatorTest() {
		Assert.assertTrue(product1.getCreator().equals(new User("user 1", "user1@mail.com", "123456Brasil")));
		Assert.assertTrue(product2.getCreator().equals(new User("user 2", "user2@mail.com", "456789Brasil")));
		Assert.assertTrue(product3.getCreator() == null);
		Assert.assertTrue(product4.getCreator().equals(new User("user 3", "user3@mail.com", "1234567896543@@@Brasil")));

	}
	
	@Test
	public void getPointOfSaleTest(){
		Assert.assertEquals(product1.getPointOfSale(),new PointOfSale(new User("user 1", "user1@mail.com", "123456Brasil"), "point 1", 500, 500));
		Assert.assertEquals(product2.getPointOfSale(),new PointOfSale(new User("user 2", "user2@mail.com", "456789Brasil"), "point 2", 250, 250));
		Assert.assertEquals(product4.getPointOfSale(),new PointOfSale(new User("user 3", "user3@mail.com", "1234567896543@@@Brasil"), "point 3", 15, 150));


	}
}
