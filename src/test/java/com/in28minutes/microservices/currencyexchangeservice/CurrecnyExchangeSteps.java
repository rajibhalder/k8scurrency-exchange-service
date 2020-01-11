
package com.in28minutes.microservices.currencyexchangeservice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import org.junit.Assert;

import static io.restassured.RestAssured.when;

public class CurrecnyExchangeSteps {

    float output = 0f;

    @Given("^conversion rate for (.*) to (.*)$")
    public void conversion_rate_for_fromcurrency_to_tocurrency(String from, String to) throws Exception {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
        output = when().request(Method.GET,"/currency-exchange/from/"+from+"/to/"+to).then().statusCode(200).extract().path("conversionMultiple");
    }

    @When("^the system is asked to provide the conversion rate$")
    public void the_system_is_asked_to_provide_the_conversion_rate() throws Exception {
    }

    @Then("^It should output (.*)$")
    public void thenCheckOutput(float response) {
       Assert.assertEquals(output, response,0.5);

    }

    public static void main(String[] args) {
    }
}

