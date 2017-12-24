package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class LoginTests {
  private static WebConversation conversation;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conversation=new WebConversation();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		conversation=null;
	}

	@Test
	public void testLoginAppWithValidCredentials() {
		WebResponse  response=null,response1=null;
		WebForm form=null;
		String actualOutput=null;
		try{
			//get Access to index.html page as response
			response=conversation.getResponse("http://localhost:2525/LoginApp-HttpUnit/index.html");
			//get access to form page of index.html response page
			form=response.getForms()[0];
			//set request param values to form
			form.setParameter("uname","raja");
			form.setParameter("pwd","rani");
			//submit the form
			response1=form.submit();
			//get actual Output
			actualOutput=response1.getText().trim();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		assertEquals("test1", "<h1>Valid Credentials</h1>", actualOutput);
		}//method
	
	@Test
	public void testLoginAppWithInValidCredentials() {
		WebResponse  response=null,response1=null;
		WebForm form=null;
		String actualOutput=null;
		try{
			//get Access to index.html page as response
			response=conversation.getResponse("http://localhost:2525/LoginApp-HttpUnit/index.html");
			//get access to form page of index.html response page
			form=response.getForms()[0];
			//set request param values to form
			form.setParameter("uname","raja1");
			form.setParameter("pwd","rani");
			//submit the form
			response1=form.submit();
			//get actual Output
			actualOutput=response1.getText().trim();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		assertEquals("test2", "<h1>InValid Credentials</h1>", actualOutput);
		}//method
	
	@Test
	public void testLoginAppWithOutCredentials() {
		WebResponse  response=null,response1=null;
		WebForm form=null;
		String actualOutput=null;
		try{
			//get Access to index.html page as response
			response=conversation.getResponse("http://localhost:2525/LoginApp-HttpUnit/index.html");
			//get access to form page of index.html response page
			form=response.getForms()[0];
			//set request param values to form
			form.setParameter("uname","");
			form.setParameter("pwd","");
			//submit the form
			response1=form.submit();
			//get actual Output
			actualOutput=response1.getText().trim();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		assertEquals("test3", "Provide Inputs", actualOutput);
		}//method



}

