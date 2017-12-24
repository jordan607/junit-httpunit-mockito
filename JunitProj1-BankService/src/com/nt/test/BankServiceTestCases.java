/**
 * 
 */
package com.nt.test;

import static  org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.nt.service.BankService;
import com.nt.service.BankServiceImpl;

/**
 * @author nareshit
 *
 */
public class BankServiceTestCases {
   private static BankService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BankServiceTestCases::setUpBeforeCase()");
		service=new BankServiceImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static  void tearDownAfterClass() throws Exception {
		System.out.println("BankServiceTestCases::tearDownAfterClass()");
		service=null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("BankServiceTestCases::setUp()");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("BankServiceTestCases::tearDown()");
	}

	/**
	 * Test method for {@link com.nt.service.BankServiceImpl#calcSimpleIntrAmt(float, float, float)}.
	 */
	@Test(timeout=25000)
	public void testCalcSimpleIntrAmtWithInts() {
		int pAmt=10000;
		int rate=2;
		int time=20;
		float expectedIntrAmt=4000.0f;
		float actualIntrAmt=service.calcSimpleIntrAmt(pAmt, rate, time);
		assertEquals("test1", expectedIntrAmt, actualIntrAmt, 0.0f);
	}
	
	@Test
	//@Ignore
	public void testCalcSimpleIntrAmtWithFloats() {
		float pAmt=10000.4f;
		float rate=2.1f;
		float time=20.2f;
		float expectedIntrAmt=4242.16968f;
		float actualIntrAmt=service.calcSimpleIntrAmt(pAmt, rate, time);
		assertEquals("test2", expectedIntrAmt, actualIntrAmt, 1.0f);
	}
	
	@Test
	//@Ignore
	public void testCalcSimpleIntrAmtWithBigValues() {
		float pAmt=10000000.4f;
		float rate=2.1f;
		float time=2000.2f;
		float expectedIntrAmt=420042016.80168f;
		float actualIntrAmt=service.calcSimpleIntrAmt(pAmt, rate, time);
		assertEquals("test3", expectedIntrAmt, actualIntrAmt, 10.0f);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	//@Ignore
	public void testCalcSimpleIntrAmtWithInValidInputs() {
		float pAmt=0.0f;
		float rate=2.1f;
		float time=-3.0f;
		float actualIntrAmt=service.calcSimpleIntrAmt(pAmt, rate, time);
        fail("Exception is exptected in the previous line");
	}

	@Test
    public void  testIsAccountBlockedWithValidInputs(){
    	assertTrue("test5",service.isAccountBlocked(100001));
    }
	
	@Test
    public void  testIsAccountBlockedWithInValidInputs(){
    	assertFalse("test6",service.isAccountBlocked(300001));
		
    }
	
	@Test(expected=IllegalArgumentException.class)
	@Ignore
    public void  testIsAccountBlockedWithWrongAccno(){
    	assertTrue("test7",service.isAccountBlocked(-300001));
    	fail("Excpetion should come in the previous codeline");
    }



}
