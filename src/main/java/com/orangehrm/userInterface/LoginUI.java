package com.orangehrm.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class LoginUI {

    public static final Target TXT_USERNAME = Target
            .the("Input user name")
            .locatedBy("//input[@name='username']");

    public static final Target TXT_PASSWORD = Target
            .the("Input password")
            .locatedBy("//input[@name='password']");

    public static final Target BTN_ENTER = Target
            .the("Button enter")
            .locatedBy("//button[@type='submit']");
}
