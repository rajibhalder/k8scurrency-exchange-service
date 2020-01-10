///*
//package com.in28minutes.microservices.currencyexchangeservice;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
//
//public class CurrecnyExchangeSteps {
//
//    String output = "";
//
//    @Given("^from (.*) and to (.*)$")
//    public void when_a_user_with_username_in_minutes_and_password_dummy(String name, String password) throws Exception {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, 3);
//            driver.get("http://localhost:8082");
//            driver.findElement(By.id("username")).sendKeys(name);
//            driver.findElement(By.id("password")).sendKeys(password);
//            driver.findElement(By.xpath("/html/body/div[@class='container']/form[@class='form-signin']/button[@class='btn btn-lg btn-primary btn-block']")).click();
//            WebElement firstResult = wait.until(presenceOfElementLocated(By.xpath("/html/body/nav[@class='navbar navbar-default']/div[1]/a[@class='navbar-brand']")));
//            output = firstResult.getText();
//            System.out.println(firstResult.getText());
//        } catch (Exception e) {
//            output = "failure";
//        } finally {
//            driver.quit();
//        }
//    }
//
//    @When("^tries to login to todo web application$")
//    public void tries_to_login_to_the_application() throws Exception {
//    }
//
//    @Then("^It should login (.*)$")
//    public void thenCheckOutput(String response) {
//       Assert.assertEquals(output, response);
//    }
//
//    public static void main(String[] args) {
//    }
//}
//*/
