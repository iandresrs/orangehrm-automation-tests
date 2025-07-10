package com.orangehrm.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.orangehrm.userInterface.HomeUI.LBL_MESSAGE;

public class DashboardIsVisible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        return LBL_MESSAGE.resolveFor(actor).isVisible();
    }

    public static DashboardIsVisible onScreen(){
        return new DashboardIsVisible();
    }
}
