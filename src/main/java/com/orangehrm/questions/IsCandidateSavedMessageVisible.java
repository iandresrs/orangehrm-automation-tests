package com.orangehrm.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.orangehrm.userInterface.RecruitmentUI.ALERT_SAVE_SUCCESSFUL;

public class IsCandidateSavedMessageVisible implements Question<Boolean> {

  @Override
  public Boolean answeredBy(Actor actor) {
    return ALERT_SAVE_SUCCESSFUL.resolveFor(actor).isVisible();
  }

  public static IsCandidateSavedMessageVisible candidateWasSavedSuccessfully(){
    return new IsCandidateSavedMessageVisible();
  }
}
