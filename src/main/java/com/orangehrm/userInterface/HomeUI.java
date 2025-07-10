package com.orangehrm.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class HomeUI {

    public static final Target LBL_MESSAGE = Target
            .the("Text Welcome")
            .locatedBy("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

    public static final Target BTN_RECRUITMENT = Target
            .the("Button Recruitment")
            .locatedBy("//span[text()='Recruitment']");
}
