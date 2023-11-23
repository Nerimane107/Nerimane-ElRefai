package instabug.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

import instabug.models.HomePage;
import instabug.models.ResultPage;
import junit.framework.Assert;

public class LoginTests {

	private static final long MAX_PAGE_LOAD_TIME = 3;

	@Test
	public void Login_ValidData_SuccessfulLogin() {
		
		String localDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.edge.driver",
				localDir+ "\\edgedriver_win64\\msedgedriver.exe");

		// initializing the Home Page which initializes the EdgeDriver and sets the
		// strings that will be given to findElement in the driver.
		HomePage home = new HomePage(new EdgeDriver());
		// gets the url specified in instabug Task
		home.open();
		// finds the textboxes and buttons then gives them the input username and
		// password.
		ResultPage result = home.login("standard_user", "secret_sauce");

		String actualURL = result.returnURL();
		String expectedURL = "https://www.saucedemo.com/inventory.html";

		home.close();
		// check if the expected output is the same as the actual output
		assertEquals(actualURL, expectedURL);

		
	}
	
	
	@Test
	public void Login_InValidData_UnsuccessfulLogin() {


String localDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.edge.driver",
				localDir+ "\\edgedriver_win64\\msedgedriver.exe");


		// initializing the Home Page which initializes the EdgeDriver and sets the
		// strings that will be given to findElement in the driver.
		HomePage home = new HomePage(new EdgeDriver());
		// gets the url specified in instabug Task
		home.open();
		// finds the textboxes and buttons then gives them the input username and
		// password.
		ResultPage result = home.login("NotStandard_user", "NotSecret_sauce");
        String actualErrorMessage = result.errorMessage();
        System.out.println(actualErrorMessage);
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
		String actualURL = result.returnURL();
		String expectedURL = "https://www.saucedemo.com/";

		home.close();
		// check if the expected output is the same as the actual output
		assertEquals(actualURL, expectedURL);
		assertEquals(actualErrorMessage,expectedErrorMessage);

	
	}

	@Test
	public void Login_EmptyFields_UnsuccessfulLogin() {
String localDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.edge.driver",
				localDir+ "\\edgedriver_win64\\msedgedriver.exe");


		// initializing the Home Page which initializes the EdgeDriver and sets the
		// strings that will be given to findElement in the driver.
		HomePage home = new HomePage(new EdgeDriver());
		// gets the url specified in instabug Task
		home.open();
		// finds the textboxes and buttons then gives them the input username and
		// password.
		ResultPage result = home.login("", "");
        String actualErrorMessage = result.errorMessage();
        String expectedErrorMessage = "Epic sadface: Username is required";
		String actualURL = result.returnURL();
		String expectedURL = "https://www.saucedemo.com/";

		home.close();
		// check if the expected output is the same as the actual output
		assertEquals(actualURL, expectedURL);
		assertEquals(actualErrorMessage,expectedErrorMessage);

	}
	
	@Test
	public void Login_EmptyUsername_UnsuccessfulLogin() {
String localDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.edge.driver",
				localDir+ "\\edgedriver_win64\\msedgedriver.exe");


		// initializing the Home Page which initializes the EdgeDriver and sets the
		// strings that will be given to findElement in the driver.
		HomePage home = new HomePage(new EdgeDriver());
		// gets the url specified in instabug Task
		home.open();
		// finds the textboxes and buttons then gives them the input username and
		// password.
		ResultPage result = home.login("", "secret_sauce");
        String actualErrorMessage = result.errorMessage();
        String expectedErrorMessage = "Epic sadface: Username is required";
		String actualURL = result.returnURL();
		String expectedURL = "https://www.saucedemo.com/";

		home.close();
		// check if the expected output is the same as the actual output
		assertEquals(actualURL, expectedURL);
		assertEquals(actualErrorMessage,expectedErrorMessage);

	}
	
	@Test
	public void Login_EmptyPassword_UnsuccessfulLogin() {
String localDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.edge.driver",
				localDir+ "\\edgedriver_win64\\msedgedriver.exe");


		// initializing the Home Page which initializes the EdgeDriver and sets the
		// strings that will be given to findElement in the driver.
		HomePage home = new HomePage(new EdgeDriver());
		// gets the url specified in instabug Task
		home.open();
		// finds the textboxes and buttons then gives them the input username and
		// password.
		ResultPage result = home.login("standard_user", "");
        String actualErrorMessage = result.errorMessage();
        String expectedErrorMessage = "Epic sadface: Password is required";
		String actualURL = result.returnURL();
		String expectedURL = "https://www.saucedemo.com/";

		home.close();
		// check if the expected output is the same as the actual output
		assertEquals(actualURL, expectedURL);
		assertEquals(actualErrorMessage,expectedErrorMessage);

	}
 
	@Test
	public void Login_LockedUser_UnsuccessfulLogin() {
String localDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.edge.driver",
				localDir+ "\\edgedriver_win64\\msedgedriver.exe");

		// initializing the Home Page which initializes the EdgeDriver and sets the
		// strings that will be given to findElement in the driver.
		HomePage home = new HomePage(new EdgeDriver());
		// gets the url specified in instabug Task
		home.open();
		// finds the textboxes and buttons then gives them the input username and
		// password.
		ResultPage result = home.login("locked_out_user", "secret_sauce");
        String actualErrorMessage = result.errorMessage();
        
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
		String actualURL = result.returnURL();
		String expectedURL = "https://www.saucedemo.com/";

		home.close();
		// check if the expected output is the same as the actual output
		assertEquals(actualURL, expectedURL);
		assertEquals(actualErrorMessage,expectedErrorMessage);

	}
    
	@Test
	
	public void Login_PerformanceGlitch_SuccessfulLogin() {
String localDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.edge.driver",
				localDir+ "\\edgedriver_win64\\msedgedriver.exe");


		// initializing the Home Page which initializes the EdgeDriver and sets the
		// strings that will be given to findElement in the driver.
		HomePage home = new HomePage(new EdgeDriver());
		// gets the url specified in instabug Task
		home.open();
		// finds the textboxes and buttons then gives them the input username and
		// password.
		long startTime = System.currentTimeMillis();
		ResultPage result = home.login("performance_glitch_user", "secret_sauce");
	    long endTime = System.currentTimeMillis();
	    long pageLoadTime = endTime - startTime;
	    System.out.println("Page load time: " + pageLoadTime + " milliseconds");
       
		String actualURL = result.returnURL();
		String expectedURL = "https://www.saucedemo.com/inventory.html";

		home.close();
		// check if the expected output is the same as the actual output
		assertEquals(actualURL, expectedURL);
	    assertTrue(pageLoadTime > MAX_PAGE_LOAD_TIME);

		
	}
	

}
