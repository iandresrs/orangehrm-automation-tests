package com.orangehrm.tasks;

import com.orangehrm.exceptions.FunctionalValidationException;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.orangehrm.constants.ErrorMessage.LOGIN_FAILED;
import static com.orangehrm.userInterface.LoginUI.*;

public class LoginTask implements Task {

    private String username;
    private String password;

    public LoginTask(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       try{
           actor.attemptsTo(
                   Enter.theValue(username).into(TXT_USERNAME),
                   Enter.theValue(password).into(TXT_PASSWORD),
                   Click.on(BTN_ENTER)
           );
       } catch (Exception e) {
           throw new FunctionalValidationException(LOGIN_FAILED, e);
       }
    }

    public static LoginTask withCredentials(String username, String password){
        return Instrumented.instanceOf(LoginTask.class).withProperties(username, password);
    }
}
