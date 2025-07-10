package com.orangehrm.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class CandidateUI {

  public static final Target BTN_SHORT_LIST = Target
          .the("Button Short List")
          .locatedBy("//button[text()=' Shortlist ']");

  public static final Target BTN_SAVE = Target
          .the("Button Save Candidate")
          .locatedBy("//button[@type='submit' and normalize-space()='Save']");

  public static final Target BTN_MARK_INTERVIEW_PASSED = Target
          .the("Button Mark Interview Passed")
          .locatedBy("//button[text()=' Mark Interview Passed ']");

  public static final Target BTN_OFFER_JOB = Target
          .the("Button Mark Interview Passed")
          .locatedBy("//button[text()=' Offer Job ']");

  public static final Target BTN_HIRE = Target
          .the("Button Mark Interview Passed")
          .locatedBy("//button[text()=' Hire ']");

  public static final Target LBL_STATUS_CANDIDATE = Target
          .the("Label Status Candidate")
          .locatedBy("//p[normalize-space()='Status: Hired']");
}
