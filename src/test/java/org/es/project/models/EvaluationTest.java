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
