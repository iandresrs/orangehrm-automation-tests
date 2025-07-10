package com.orangehrm.tasks;

import com.orangehrm.exceptions.FunctionalValidationException;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static com.orangehrm.constants.ErrorMessage.ERROR_SCHEDULING_INTERVIEW_MESSAGE;
import static com.orangehrm.userInterface.ScheduleInterviewUI.*;

public class ScheduleInterviewTask implements Task {

  private String interviewerTitle;
  private String interviewer;
  private String date;
  private String time;
  private String notes;

  public ScheduleInterviewTask(String interviewerTitle, String interviewer, String date, String time, String notes) {
    this.interviewerTitle = interviewerTitle;
    this.interviewer = interviewer;
    this.date = date;
    this.time = time;
    this.notes = notes;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    try {
      actor.attemptsTo(Click.on(
              BTN_SCHEDULE_INTERVIEW),
              Enter.theValue(interviewerTitle).into(TXT_INTERVIEWER_TITLE),
              Enter.theValue(interviewer).into(TXT_INTERVIEWER),
              Click.on(LST_ENTREVISTADOR.of(interviewer)),
              Enter.theValue(date).into(TXT_DATE),
              Enter.theValue(time).into(TXT_TIME),
              Enter.theValue(notes).into(TXT_NOTES),
              Click.on(BTN_SAVE)
      );
    } catch (Exception e) {
      throw new FunctionalValidationException(ERROR_SCHEDULING_INTERVIEW_MESSAGE, e);
    }
  }

  public static ScheduleInterviewTask Schedule(String interviewerTile, String interviewer, String date, String time,String notes) {
    return Instrumented.instanceOf(ScheduleInterviewTask.class).withProperties(interviewerTile,interviewer,date,time,notes);
  }
}
