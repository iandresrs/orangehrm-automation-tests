package com.orangehrm.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class RecruitmentUI {

  public static final Target BTN_ADD = Target
          .the("Add button")
          .locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");

  public static final Target TXT_FIRSTNAME = Target
          .the("First name input field")
          .locatedBy("//input[@name='firstName']");

  public static final Target TXT_MIDDLENAME = Target
          .the("Middle name input field")
          .locatedBy("//input[@name='middleName']");

  public static final Target TXT_LASTNAME = Target
          .the("Last name input field")
          .locatedBy("//input[@name='lastName']");

  public static final Target LST_VACANCY = Target
          .the("Vacancy dropdown list")
          .locatedBy("//div[@class='oxd-select-text-input']");

  public static final Target ITEM_VACANCY = Target
          .the("")
          .locatedBy("//div[@role='listbox']/div/span[contains(text(),'{0}')]");

  public static final Target TXT_EMAIL = Target
          .the("Email input field")
          .locatedBy("(//input[@class='oxd-input oxd-input--active'])[2]");

  public static final Target TXT_CONTACTNUMBER = Target
          .the("Contact number input field")
          .locatedBy("(//div[@data-v-957b4417='']//input[@placeholder='Type here'])[2]");

  public static final Target TXT_UPLOADFILE = Target
          .the("Uploat file")
          .locatedBy("//input[@type='file' and contains(@class, 'oxd-file-input')]");

  public static final Target FILE_NAME_LABEL = Target
          .the("nombre del archivo subido")
          .locatedBy("//div[contains(@class, 'oxd-file-input-div')]");

  public static final Target TXT_KEYWORD = Target
          .the("Keyword input field")
          .locatedBy("//input[@class='oxd-input oxd-input--active' and @placeholder='Enter comma seperated words...']");

  public static final Target TXT_DATA_APPLICATION = Target
          .the("Date of application input field")
          .locatedBy("//div[contains(@class, 'oxd-date-input')]//input[@placeholder='yyyy-dd-mm']");

  public static final Target TXT_NOTES = Target
          .the("Notes text area")
          .locatedBy("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");

  public static final Target CHK_CONSENT_KEEP_DATA = Target
          .the("Consent to keep data checkbox")
          .locatedBy("//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']");

  public static final Target BTN_SAVE = Target
          .the("Save button")
          .locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

  public static final Target ALERT_SAVE_SUCCESSFUL = Target
          .the("")
          .locatedBy("//div[contains(@class, 'oxd-toast--success')]//p[text()='Successfully Saved']");

}
