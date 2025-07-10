package com.orangehrm.stepDefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class Hook {

    @Before
    public void configuration() {
        setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
    }
}
