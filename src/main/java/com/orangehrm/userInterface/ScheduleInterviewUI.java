package com.orangehrm.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class ScheduleInterviewUI {

  public static final Target BTN_SCHEDULE_INTERVIEW = Target
          .the("Button Save Candidate")
          .locatedBy("//div[contains(@class, 'orangehrm-recruitment-actions')]//button[normalize-space()='Schedule Interview']");

  public static final Target TXT_INTERVIEWER_TITLE = Target
          .the("Input Interviewer")
          .locatedBy("(//input[@class='oxd-input oxd-input--active'])[6]");

  public static final Target TXT_INTERVIEWER = Target
          .the("Input Interviewer")
          .locatedBy("//input[@placeholder='Type for hints...']");

  public static final Target LST_ENTREVISTADOR = Target
          .the("")
          .locatedBy("//div[@role='listbox']/div/span[contains(text(),'{0}')]");

  public static final Target TXT_DATE = Target
          .the("Input Date")
          .locatedBy("//input[@placeholder='yyyy-dd-mm']");

  public static final Target TXT_TIME = Target
          .the("Input Time")
          .locatedBy("//input[@placeholder='hh:mm']");

  public static final Target TXT_NOTES = Target
          .the("Input Notes")
          .locatedBy("//textarea[@placeholder='Type here']");


  public static final Target BTN_SAVE = Target
          .the("Input Notes")
          .locatedBy("//button[@type='submit' and normalize-space()='Save']");


}
