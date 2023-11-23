package instabug.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomePage
{
WebDriver driver;

String url = "https://www.saucedemo.com/";

By usernameTextBoxLocator = By.xpath(("//input[@id='user-name']"));
By passwordTextBoxLocator = By.xpath(("//input[@id='password']"));
By loginButtonLocator = By.xpath(("//input[@id='login-button']"));


//By errorMessageLocator = By.xpath(("//input[@class='error-message-container']"));

public HomePage(EdgeDriver driver)
{

this.driver = driver;

}
public void open()
{

driver.get(url);
driver.manage().window().maximize();

}

public void close() {
	driver.close();
}

public ResultPage login(String username, String password)
{

WebElement usernameField = driver.findElement(usernameTextBoxLocator);

usernameField.sendKeys(username);

WebElement passwordField = driver.findElement(passwordTextBoxLocator);

passwordField.sendKeys(password);

WebElement LoginButton = driver.findElement(loginButtonLocator);

LoginButton.click();




return new ResultPage(this.driver);

}
}


