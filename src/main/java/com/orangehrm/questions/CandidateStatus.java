package com.orangehrm.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.orangehrm.userInterface.CandidateUI.LBL_STATUS_CANDIDATE;

public class CandidateStatus implements Question<Boolean> {
  @Override
  public Boolean answeredBy(Actor actor) {
    String statusText =  LBL_STATUS_CANDIDATE.resolveFor(actor).getText().trim();
    return statusText.equals("Status: Hired");
  }

  public static CandidateStatus isHired(){
    return new CandidateStatus();
  }
}
