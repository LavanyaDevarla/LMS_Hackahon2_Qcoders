package stepDefinition;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//import io.cucumber.java.bs.I.Is;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
//import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;


public class Steps {
  
  public WebDriver driver;
  public LoginPage lp;
  

@Given("User Launch chrome browser")
public void user_launch_chrome_browser() {
  WebDriverManager.chromedriver().setup();
  driver=new ChromeDriver();
  driver.get("https://admin-demo.nopcommerce.com/login");
  lp = new LoginPage(driver);
    
}

@When("user opens URL {string}")
public void user_opens_url(String url) {
   
  driver.get(url);
  driver.manage().window().maximize();
  
}


@When("user enters email as {string} and password as {string}")
public void user_enters_email_as_and_password_as(String email, String password)throws InterruptedException {
  
  lp.setUserName(email);
  lp.setPassword(password);
   Thread.sleep(1000); 
}

@When("click on Login")
public void click_on_login() throws InterruptedException {
    
  lp.ClickLogin();
  Thread.sleep(1000);
}

@Then("Page title should be {string}")
public void page_title_should_be(String title) throws InterruptedException{
   
  if(driver.getPageSource().contains("Login was unsuccessful."))
  {
    driver.close();
    Assert.assertTrue(false);
    //System.out.println("title is---------"+driver.getTitle());
  }
  else {
    
      Assert.assertEquals(title,driver.getTitle());
   
  }
  Thread.sleep(1000);
  
}

@When("user clicks on Logout")
public void user_clicks_on_logout() throws InterruptedException{
  lp.ClickLogout();
    Thread.sleep(3000);
}

@Then("close browser")
public void close_browser() {
  driver.quit();
}}