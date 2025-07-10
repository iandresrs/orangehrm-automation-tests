package com.orangehrm.stepDefinitions;

import com.orangehrm.exceptions.ValidateException;
import com.orangehrm.questions.CandidateStatus;
import com.orangehrm.questions.IsCandidateSavedMessageVisible;
import com.orangehrm.tasks.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.orangehrm.constants.ErrorMessage.CANDIDATE_SUCCESS_MESSAGE_NOT_DISPLAYED;
import static com.orangehrm.constants.ErrorMessage.ERROR_STATUS_CANDIDATE;

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
            "2025-10-07",
            "Hola Mundo"));
  }

  @And("the system should display a success message confirming the candidate was saved")
  public void theSystemShouldDisplayASuccessMessageConfirmingTheCandidateWasSaved() {
    boolean messageVisible = IsCandidateSavedMessageVisible.candidateWasSavedSuccessfully().answeredBy(OnStage.theActorInTheSpotlight());

    if (!messageVisible) {
      throw new ValidateException(CANDIDATE_SUCCESS_MESSAGE_NOT_DISPLAYED);
    }

  }

  @And("shortlists the candidate")
  public void shortlistsTheCandidate() {
    OnStage.theActorInTheSpotlight().attemptsTo(
            ShortlistCandidate.now()
    );
  }

  @And("schedules an interview")
  public void schedulesAnInterview() {
      OnStage.theActorInTheSpotlight().attemptsTo(
              ScheduleInterviewTask.Schedule(
                      "Interviewer",
                      "Peter Mac Anderson",
                      "2025-07-11",
                      "11:00 AM",
                      "Interview candidate"
              )
      );
  }

  @And("marks the candidate as approved")
  public void marksTheCandidateAsApproved() {
    OnStage.theActorInTheSpotlight().attemptsTo(
            FinalizeInterviewProcess.forCandidate(
                    "Good performance during the interview, especially in problem-solving and teamwork",
                    "Candidate meets the role requirements and aligns with company values. Proceeding with offer.",
                    "Hiring confirmed. Start date to be coordinated with HR."
            )
    );
  }

  @Then("the candidate should appear in the found records section with status hired")
  public void theCandidateShouldAppearInTheFoundRecordsSectionWithStatusHired() {
    boolean status = CandidateStatus.isHired().answeredBy(OnStage.theActorInTheSpotlight());

    if (!status){
      throw new ValidateException(ERROR_STATUS_CANDIDATE);
    }
  }
}
