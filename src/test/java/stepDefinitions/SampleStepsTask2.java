package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SampleStepsTask2 {
    private WebDriver driver;

    public SampleStepsTask2() {
        this.driver = Hooks.driver;
    }


    //Scenario Outline: Adding one more person to the existing list


    @Given("^I am on the Task2 home page$")
    public void iAmOnTheTask2HomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }
    @And("^I click Add person button$")
    public void iClickAddPersonButton() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @And("^I enter person's name: \"([^\"]*)\"$")
    public void iEnterPersonsName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter job: \"([^\"]*)\"$")
    public void iEnterJob(String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^I click Add button$")
    public void iClickAddButton() throws Throwable {
        driver.findElement(By.id("modal_button")).click();
        Thread.sleep(2000);
    }

    @Then("^I can see name \"([^\"]*)\" appeared$")
    public void iCanSeeNameAppeared(String name) throws Throwable {
        assertEquals(name, driver.findElement(By.xpath("//*[@id=\"person3\"]/span[3]")).getText());
    }

    @And("^I can see job \"([^\"]*)\" appeared$")
    public void iCanSeeJobAppeared(String job) throws Throwable {
        assertEquals(job, driver.findElement(By.xpath("//*[@id=\"person3\"]/span[4]")).getText());
    }


    //Scenario: Edit a person


    @And("^I click Pencil button on the first person$")
    public void iClickPencilButtonOnTheFirstPerson() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]/i")).click();
        Thread.sleep(2000);
    }

    @And("^I enter \"([^\"]*)\" as a new name$")
    public void iEnterAsANewName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter \"([^\"]*)\" as a new job$")
    public void iEnterJobAsANewJob(String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^I click Edit button$")
    public void iClickEditButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"modal_button\"]")).click();
        Thread.sleep(2000);
    }

    @Then("^I can see new name \"([^\"]*)\" appeared$")
    public void iCanSeeNewNameAppeared(String name) throws Throwable {
        assertEquals(name, driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]")).getText());
    }

    @And("^I can see new job \"([^\"]*)\" appeared$")
    public void iCanSeeNewJobAppeared(String job) throws Throwable {
        assertEquals(job, driver.findElement(By.xpath("//*[@id=\"person0\"]/span[4]")).getText());
    }


    //Scenario: Remove a person


    @And("^I click on remove button$")
    public void iClickOnRemoveButton() {
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[1]")).click();
    }

    @Then("^I can see person is removed$")
    public void iCanSeePersonIsRemoved(String name) throws Throwable {
        assertEquals(name, driver.findElement(By.xpath("")).getText());
    }

    @Then("^I can see person name and job is removed$")
    public void iCanSeePersonNameAndJobRemoved() {
        assertNotEquals("Jill", driver.findElement(By.xpath("//*[@id=\"person2\"]/span[3]")).getText());
        assertNotEquals("Support", driver.findElement(By.xpath("//*[@id=\"person2\"]/span[4]")).getText());
    }


    //Scenario: reset original list after adding, editing, removing a person


    @And("^I click Reset the list$")
    public void iClickResetTheList() throws Throwable {
        driver.findElement(By.xpath("//*[contains(@onclick, 'resetListOfPeople()')]")).click();
    }

    @Then("^I can see the initial list$")
    public void iCanSeetheInitialList() {

        assertEquals("Mike", driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]")).getText());
        assertEquals("Web Designer", driver.findElement(By.xpath("//*[@id=\"person0\"]/span[4]")).getText());
        assertEquals("Jill", driver.findElement(By.xpath("//*[@id=\"person1\"]/span[3]")).getText());
        assertEquals("Support", driver.findElement(By.xpath("//*[@id=\"person1\"]/span[4]")).getText());
        assertEquals("Jane", driver.findElement(By.xpath("//*[@id=\"person2\"]/span[3]")).getText());
        assertEquals("Accountant", driver.findElement(By.xpath("//*[@id=\"person2\"]/span[4]")).getText());
    }


    //Scenario: Check if Clear button on adding works correctly


    @Then("^I can see name field is empty$")
    public void iCanSeeNameFieldIsEmpty() {
        assertNotEquals("name", driver.findElement(By.id("name")).getText());
    }

    @Then("^I can see job field is empty$")
    public void iCanSeeJobFieldIsEmpty() {
        assertNotEquals("job", driver.findElement(By.id("job")).getText());
        assertNotEquals("job", driver.findElement(By.id("job")).getText());
    }
    @And("^I click Clear button$")
    public void iClickClearButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
        Thread.sleep(2000);
    }
}






