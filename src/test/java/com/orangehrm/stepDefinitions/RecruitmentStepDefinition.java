package com.orangehrm.stepDefinitions;

import com.orangehrm.exceptions.ValidateException;
import com.orangehrm.questions.IsCandidateSavedMessageVisible;
import com.orangehrm.tasks.AddCandidateTask;
import com.orangehrm.tasks.EnterRecruitmentModuleTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.orangehrm.constants.ErrorMessage.CANDIDATE_SAVE_ERROR_MESSAGE;

public class RecruitmentStepDefinition {

  @Given("the user is in the recruitment module")
  public void theUserIsInTheRecruitmentModule() {
    OnStage.theActorInTheSpotlight().attemptsTo(EnterRecruitmentModuleTask.enter());
  }

  @When("the user registers a new candidate with valid data")
  public void theUserRegistersANewCandidateWithValidData() {
    OnStage.theActorInTheSpotlight().attemptsTo(AddCandidateTask.withData(
            "Andres",
            "Camilo",
            "Perez",
            "rr@gmail.com",
            "123456789",
            "English",
            "2025-07-07",
            "Hola Mundo"));
  }

  @And("the system should display a success message confirming the candidate was saved")
  public void theSystemShouldDisplayASuccessMessageConfirmingTheCandidateWasSaved() {
    boolean messageVisble = IsCandidateSavedMessageVisible.candidateWasSavedSuccessfully().answeredBy(OnStage.theActorInTheSpotlight());

    if (!messageVisble) {
      throw new ValidateException(CANDIDATE_SAVE_ERROR_MESSAGE);
    }

  }

  @And("shortlists the candidate")
  public void shortlistsTheCandidate() {

  }

  @And("schedules an interview")
  public void schedulesAnInterview() {

  }

  @And("marks the candidate as approved")
  public void marksTheCandidateAsApproved() {

  }

  @Then("the candidate should appear in the found records section with status hired")
  public void theCandidateShouldAppearInTheFoundRecordsSectionWithStatusHired() {

  }
}
