package org.es.project.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class EvaluationTest {
	Evaluation eva0;
	Evaluation eva1;

	@Before
	public void initialization() {
		eva0 = new Evaluation(7);
		eva1 = new Evaluation(9, "Get in the damn robot Shinji!!");

	}
	
	@Test
	public void getGradeTest(){
		Assert.assertEquals(eva0.getGrade(), 7);
		Assert.assertEquals(eva1.getGrade(), 9);
	}
	
	@Test
	public void getCommentTest(){
		Assert.assertEquals(eva0.getComment(), "");
		Assert.assertEquals(eva1.getComment(), "Get in the damn robot Shinji!!");
	}
	
	@Test
	public void getId(){
		Assert.assertTrue(eva0.getId() == null);
		Assert.assertTrue(eva1.getId() == null);

	}
	
	@Test
	public void constructorTest1(){
		Assert.assertEquals(eva0.getComment(), "");
		Assert.assertEquals(eva0.getGrade(), 7);		
		
	}
	
	@Test
	public void constructorTest2(){
		Assert.assertEquals(eva1.getComment(), "Get in the damn robot Shinji!!");
		Assert.assertEquals(eva1.getGrade(), 9);	
		
	}
	

}
