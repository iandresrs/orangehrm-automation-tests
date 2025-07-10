package com.orangehrm.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.orangehrm.userInterface.CandidateUI.BTN_SAVE;
import static com.orangehrm.userInterface.CandidateUI.BTN_SHORT_LIST;

public class ShortlistCandidate implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
            Click.on(BTN_SHORT_LIST),
            Click.on(BTN_SAVE)
    );
  }

  public static ShortlistCandidate now() {
    return new ShortlistCandidate();
  }
}
