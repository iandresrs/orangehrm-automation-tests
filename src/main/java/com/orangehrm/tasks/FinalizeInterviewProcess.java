package com.orangehrm.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.orangehrm.userInterface.CandidateUI.*;
import static com.orangehrm.userInterface.ScheduleInterviewUI.TXT_NOTES;

public class FinalizeInterviewProcess implements Task {

  private String interviewNote;
  private String offerJobNote;
  private String hireNote;

  public FinalizeInterviewProcess(String interviewNote, String offerJobNote, String hireNote) {
    this.interviewNote = interviewNote;
    this.offerJobNote = offerJobNote;
    this.hireNote = hireNote;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
            Click.on(BTN_MARK_INTERVIEW_PASSED),
            Enter.theValue(interviewNote).into(TXT_NOTES),
            Click.on(BTN_SAVE),
            Click.on(BTN_OFFER_JOB),
            Enter.theValue(offerJobNote).into(TXT_NOTES),
            Click.on(BTN_SAVE),
            Click.on(BTN_HIRE),
            Enter.theValue(hireNote).into(TXT_NOTES),
            Click.on(BTN_SAVE)
    );
  }

  public static FinalizeInterviewProcess forCandidate(String interviewNote, String offerJobNote, String hireNote){
    return new FinalizeInterviewProcess(interviewNote, offerJobNote, hireNote);
  }
}
