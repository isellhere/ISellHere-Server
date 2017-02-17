package org.es.project.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PointOfSaleTest {
	User user1;
	User user2;
	User user3;
	User user4;
	PointOfSale point1;
	PointOfSale point2;
	PointOfSale point3;
	PointOfSale point4;

	@Before
	public void initialization() {
		user1 = new User("user 1", "user1@email.com", "1a2b3c4d5e");
		user2 = new User("user 2", "use2@email.com", "12a34fghdsfa1");
		user3 = new User("user 3", "user3@email.com", "dadaf21973");
		user4 = new User("user 4", "use4@email.com", "65574fgfsfav1");

		point1 = new PointOfSale(user1, "Crack", 23.0987, 134.567);
		point2 = new PointOfSale(user2, "Hot Deal", 134.0001, 12.67, "Memorable");
		point3 = new PointOfSale(user3, "The corner", 111.222, null, 111.00086);
		point4 = new PointOfSale(user4, "The Pit", 345.0009, 100.10001, "Lit as hell", null);

	}

	@Test
	public void constructorTest1() {
		Assert.assertEquals(point1.getComment(), "");
		Assert.assertEquals(point1.getCreator(), new User("user 1", "user1@email.com", "1a2b3c4d5e"));
		Assert.assertEquals(point1.getName(), "Crack");
		Assert.assertEquals(point1.getLatitude(), 134.567, 0.00001);
		Assert.assertEquals(point1.getLongitude(), 23.0987, 0.00001);
		Assert.assertEquals(point1.getClass(), PointOfSale.class);
		Assert.assertTrue(point1.getImage() == null);

	}

	@Test
	public void constructorTest2() {
		Assert.assertEquals(point2.getComment(), "Memorable");
		Assert.assertEquals(point2.getCreator(), new User("user 2", "use2@email.com", "12a34fghdsfa1"));
		Assert.assertEquals(point2.getName(), "Hot Deal");
		Assert.assertEquals(point2.getLatitude(), 12.67, 0.00001);
		Assert.assertEquals(point2.getLongitude(), 134.0001, 0.00001);
		Assert.assertEquals(point2.getClass(), PointOfSale.class);
		Assert.assertTrue(point2.getImage() == null);

	}

	@Test
	public void constructorTest3() {
		Assert.assertEquals(point3.getComment(), "");
		Assert.assertEquals(point3.getCreator(), new User("user 3", "user3@email.com", "dadaf21973"));
		Assert.assertEquals(point3.getName(), "The corner");
		Assert.assertEquals(point3.getLatitude(), 111.00086, 0.00001);
		Assert.assertEquals(point3.getLongitude(), 111.222, 0.00001);
		Assert.assertEquals(point3.getClass(), PointOfSale.class);
		Assert.assertTrue(point3.getImage() == null);

	}

	@Test
	public void constructorTest4() {
		Assert.assertEquals(point4.getComment(), "Lit as hell");
		Assert.assertEquals(point4.getCreator(), new User("user 4", "use4@email.com", "65574fgfsfav1"));
		Assert.assertEquals(point4.getName(), "The Pit");
		Assert.assertEquals(point4.getLatitude(), 100.10001, 0.00001);
		Assert.assertEquals(point4.getLongitude(), 345.0009, 0.00001);
		Assert.assertEquals(point4.getClass(), PointOfSale.class);
		Assert.assertTrue(point4.getImage() == null);

	}

	@Test
	public void addProductTest1() {
		point1.addProduct(user1, "product1", 100.99);
		point1.addProduct(user1, "product2", 15.99);
		point1.addProduct(user1, "product3", 67.99);
		point1.addProduct(user1, "product4", 80.99);

		List<Product> list1 = new ArrayList<>();
		list1.add(new Product(user1, point1, "product1", 100.99));
		list1.add(new Product(user1, point1, "product2", 15.99));
		list1.add(new Product(user1, point1, "product3", 67.99));
		list1.add(new Product(user1, point1, "product4", 80.99));
		Assert.assertTrue(point1.getProducts().equals(list1));

	}

	@Test
	public void addProductTest2() {

		point2.addProduct(user2, "product1", 100.99, null);
		point2.addProduct(user2, "product2", 15.99, null);
		point2.addProduct(user2, "product3", 67.99, null);
		point2.addProduct(user2, "product4", 80.99, null);
		List<Product> list1 = new ArrayList<>();

		list1.add(new Product(user2, point2, "product1", 100.99, "", null));
		list1.add(new Product(user2, point2, "product2", 15.99, "", null));
		list1.add(new Product(user2, point2, "product3", 67.99, "", null));
		list1.add(new Product(user2, point2, "product4", 80.99, "", null));
		Assert.assertTrue(point2.getProducts().equals(list1));
	}

	@Test
	public void addProductTest3() {

		point3.addProduct(user3, "product1", "Surprise Mister", 100.99);
		point3.addProduct(user3, "product2", "Heroes never die", 15.99);
		point3.addProduct(user3, "product3", "Death is not the end", 67.99);
		point3.addProduct(user3, "product4", "Despair and behold", 80.99);
		List<Product> list1 = new ArrayList<>();

		list1.add(new Product(user3, point3, "product1", 100.99, "Surprise Mister"));
		list1.add(new Product(user3, point3, "product2", 15.99, "Heroes never die"));
		list1.add(new Product(user3, point3, "product3", 67.99, "Death is not the end"));
		list1.add(new Product(user3, point3, "product4", 80.99, "Despair and behold"));
		Assert.assertTrue(point3.getProducts().equals(list1));

	}

	@Test
	public void addProductTest4() {

		point4.addProduct(user4, "product1", null, 100.99);
		point4.addProduct(user4, "product2", null, 15.99);
		point4.addProduct(user4, "product3", null, 67.99);
		point4.addProduct(user4, "product4", null, 80.99);
		List<Product> list1 = new ArrayList<>();

		list1.add(new Product(user4, point4, "product1", 100.99, "", null));
		list1.add(new Product(user4, point4, "product2", 15.99, "", null));
		list1.add(new Product(user4, point4, "product3", 67.99, "", null));
		list1.add(new Product(user4, point4, "product4", 80.99, "", null));
		Assert.assertTrue(point4.getProducts().equals(list1));

	}

	@Test
	public void deleProductTest() {

		point4.addProduct(user4, "product1", null, 100.99);
		point4.addProduct(user4, "product2", null, 15.99);
		point4.addProduct(user4, "product3", null, 67.99);
		point4.addProduct(user4, "product4", null, 80.99);
		Assert.assertTrue(!point4.getProducts().isEmpty());

		point4.deleteProduct("product1");
		point4.deleteProduct("product2");
		point4.deleteProduct("product3");
		point4.deleteProduct("product4");
		Assert.assertTrue(point4.getProducts().isEmpty());

	}

	@Test
	public void showRecentCommentsTest1() {
		String[] strList = new String[3];

		point1.addEvaluation(10);
		point1.addEvaluation(5);
		point1.addEvaluation(4);
		Assert.assertArrayEquals(point1.showRecentComments(), strList);
		point1.addEvaluation(9);
		point1.addEvaluation(8);
		Assert.assertArrayEquals(point1.showRecentComments(), strList);

	}

	@Test
	public void showRecentCommentsTest2() {
		String[] strList = new String[3];

		strList[2] = "Wabbajack";
		strList[1] = "Dementia";
		strList[0] = "Mania";
		point1.addEvaluation(10, "Wabbajack");
		point1.addEvaluation(5, "Dementia");
		point1.addEvaluation(4, "Mania");

		Assert.assertArrayEquals(point1.showRecentComments(), strList);

		point1.addEvaluation(9, "Destiny");
		point1.addEvaluation(8, "Fate");
		point1.showRecentComments();
		// strList[0] = "Mania";
		// strList[1] = "Destiny";
		// strList[2] = "Fate";
		// Assert.assertArrayEquals(point1.showRecentComments(), strList);

	}
	
	@Test
	public void showProductGradeTest1() {
		point1.addEvaluation(10);
		point1.addEvaluation(5);
		point1.addEvaluation(4);
		Assert.assertEquals(point1.showPointOfSaleGrade(), 19.0 / 3, 0.00001);
		point1.addEvaluation(9);
		point1.addEvaluation(8);
		Assert.assertEquals(point1.showPointOfSaleGrade(), 36.0 / 5, 0.00001);

	}
	
	@Test
	public void showProductGradeTest2(){
		point1.addEvaluation(10, "Wabbajack");
		point1.addEvaluation(5, "We exist");
		point1.addEvaluation(4, "The show must go on");
		Assert.assertEquals(point1.showPointOfSaleGrade(), 19.0/3, 0.00001);
		point1.addEvaluation(9, "Despair");
		point1.addEvaluation(8, "Bello");
		Assert.assertEquals(point1.showPointOfSaleGrade(), 36.0/5, 0.00001);

		
	}
	

}
