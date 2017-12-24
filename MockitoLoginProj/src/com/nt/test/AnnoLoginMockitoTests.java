package com.nt.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.nt.dao.LoginDAO;
import com.nt.service.LoginService;
import com.nt.service.LoginServiceImpl;

public class AnnoLoginMockitoTests {
	private static LoginService service=null;
	@Mock
	private static LoginDAO mockDao=null;

	@Before
	public  void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		service=new LoginServiceImpl();
		//assign MockDAO obj to Service class
		((LoginServiceImpl)service).setDao(mockDao);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		mockDao=null;
		service=null;
	}

	@Test
	public void testAuthenticateWithValidCredentials() {
		try{
		String actual=null;
		Mockito.when(mockDao.verify("raja","rani")).thenReturn(1);
		actual=service.authenticate("raja","rani");
		assertEquals("test1","Valid Crendetials" ,actual);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAuthenticateWithInValidCredentials() {
		try{
		String actual=null;
		Mockito.when(mockDao.verify("raja","rani1")).thenReturn(0);
		actual=service.authenticate("raja","rani1");
		assertEquals("test1","InValid Crendetials" ,actual);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAuthenticateWithNoCredentials() throws Exception{
		String actual=null;
		Mockito.when(mockDao.verify("","")).thenThrow(IllegalArgumentException.class);
		Mockito.when(mockDao.verify("raja","")).thenThrow(IllegalArgumentException.class);
		Mockito.when(mockDao.verify("","rani")).thenThrow(IllegalArgumentException.class);
		
		actual=service.authenticate("","rani");
		fail("Exception is expected in the previous line");

	}
	
	

}
