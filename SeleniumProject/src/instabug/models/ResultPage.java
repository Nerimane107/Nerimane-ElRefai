package instabug.models;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {

WebDriver driver;


public ResultPage(WebDriver driver)
{

this.driver = driver;

}

public String returnURL () {
	return driver.getCurrentUrl();
}

public String errorMessage() {
	return  driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
}




}
