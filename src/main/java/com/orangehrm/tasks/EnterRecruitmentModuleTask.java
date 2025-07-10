package com.orangehrm.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.orangehrm.userInterface.HomeUI.BTN_RECRUITMENT;

public class EnterRecruitmentModuleTask implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_RECRUITMENT)
        );
    }

    public static EnterRecruitmentModuleTask enter(){
        return new EnterRecruitmentModuleTask();
    }
}
