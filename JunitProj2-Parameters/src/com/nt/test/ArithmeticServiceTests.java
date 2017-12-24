package com.nt.test;

import static org.junit.Assert.*;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import com.nt.service.ArithmeticService;
import com.nt.service.ArithmeticServiceImpl;

@RunWith(Parameterized.class)
public class ArithmeticServiceTests {
	private static ArithmeticService service;
	@Parameter(value=0)
	public int p1;
	@Parameter(value=1)
	public  int p2;
	
	/*private int p1;
	private int p2;*/
	
	/*public ArithmeticServiceTests() {
		System.out.println("ArithmeticServiceTest:0-param constructor");
	}*/
	
	/*public ArithmeticServiceTests(int p1, int p2) {
		System.out.println("ArithmeticServiceTest:2-param constructor");
	  this.p1=p1;
	  this.p2=p2;
	}*/

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service=new ArithmeticServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service=null;
	}

	@Test
	public void testAdd(){
		assertEquals("test1",p1+p2, service.add(p1,p2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddWithZeros(){
		service.add(0, 0);
		fail("Exception should be raised");
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] data=new Object[][]{ {10,20},{10000,20000},{-10,-20}};
		return Arrays.asList(data);
	}
	
	
}
