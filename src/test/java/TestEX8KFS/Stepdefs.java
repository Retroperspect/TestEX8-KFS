package TestEX8KFS;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.eo.Do;

import static org.junit.jupiter.api.Assertions.*;

public class Stepdefs {
    private String today;
    private String actualAnswer;
    private Polygon triangle;
    private double result;
    private double[] triangleSides;

    /*
    @Given("^today is Sunday$")
    public void today_is_Sunday() {
        this.today = "Sunday";
    }

    @Given("^today is Friday")
    public void today_is_Friday() {
        this.today = "Friday";
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_is_s_Friday_yet() {
        this.actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
    */

    @Given("^A Triangle with sides (\\d+),(\\d+),(\\d+)$")
    public void aTriangleWithSides(int arg0, int arg1, int arg2) throws Throwable {
        this.triangle = new PolygonHandlerImpl().CreatePolygon(new double[] {arg0, arg1, arg2});
    }

    @When("^I ask for the Perimeter of the triangle$")
    public void iAskForThePerimeterOfTheTriangle() throws Throwable {
        this.result = new PolygonHandlerImpl().calculatePerimeter(this.triangle);
    }

    @Then("^I should be told (\\d+)$")
    public void iShouldBeTold(double arg0) throws Throwable {
        System.out.print(result);
        System.out.print(result);
        assertEquals(arg0, this.result);
    }

    @When("^I ask the area$")
    public void iAskTheArea() throws Throwable {
        System.out.print(this.triangle.sides[0]+","+this.triangle.sides[1]+","+this.triangle.sides[2]);
        this.result = new PolygonHandlerImpl().CalculateArea(this.triangle);
        //System.out.print(result);

        //this.result = new PolygonHandlerImpl().CalculateArea(new PolygonHandlerImpl().CreatePolygon(this.triangle.sides));
    }

    @When("^I ask the Angles$")
    public void iAskTheAngles() throws Throwable {
        this.triangleSides = new PolygonHandlerImpl().CalculateAnglesFromTriangle(this.triangle);
    }

    @Then("^I should be given \"([^\"]*)\"$")
    public void iShouldBeGiven(String arg0) throws Throwable {
        assertEquals(arg0,this.triangleSides[0]+","+this.triangleSides[1]+","+this.triangleSides[2]);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void iShouldBeTold(String arg0) throws Throwable {
        assertEquals(arg0, Double.toString(this.result));
    }


}

class IsItFriday {
    static String isItFriday(String today) {
        if (today == "Friday")
        {
            return "Yes";
        }
        else {
            return "Nope";
        }
    }
}