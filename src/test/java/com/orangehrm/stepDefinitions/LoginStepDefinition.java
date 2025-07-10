package com.orangehrm.stepDefinitions;

import com.orangehrm.exceptions.ValidateException;
import com.orangehrm.questions.DashboardIsVisible;
import com.orangehrm.tasks.LoginTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;


import static com.orangehrm.constants.ErrorMessage.BROWSER_LAUNCH_ERROR;
import static com.orangehrm.constants.ErrorMessage.DASHBOARD_NOT_VISIBLE;

public class LoginStepDefinition {

  @Given("the user is on the website")
  public void theUserIsOnTheWebsite() {
    try {
      OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    } catch (Exception e) {
      throw new ValidateException(BROWSER_LAUNCH_ERROR);
    }
  }

  @When("the user enter their credentials and click the submit button")
  public void theUserEnterTheirCredentialsAndClickTheSubmitButton() {
    OnStage.theActorInTheSpotlight().attemptsTo(LoginTask.withCredentials("Admin", "admin12"));
  }

  @Then("the user see the validation message")
  public void theUserSeeTheValidationMessage() {
    boolean dashboardVisible = DashboardIsVisible.onScreen().answeredBy(OnStage.theActorInTheSpotlight());

    if (!dashboardVisible) {
      throw new ValidateException(DASHBOARD_NOT_VISIBLE);
    }
  }
}
