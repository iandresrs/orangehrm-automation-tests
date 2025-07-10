package com.orangehrm.tasks;

import com.orangehrm.exceptions.FunctionalValidationException;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.nio.file.Paths;

import static com.orangehrm.constants.ErrorMessage.CANDIDATE_FORM_INTERACTION_ERROR;
import static com.orangehrm.userInterface.RecruitmentUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.not;

public class AddCandidateTask implements Task {
    private String firstname;
    private String middlename;
    private String lastname;
    private String email;
    private String contactNumber;
    private String keyword;
    private String dataApplication;
    private String notes;

    public AddCandidateTask(String firstname, String middlename, String lastname, String email, String contactNumber,
                            String keyword, String dataApplication, String notes) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.email = email;
        this.contactNumber = contactNumber;
        this.keyword = keyword;
        this.dataApplication = dataApplication;
        this.notes = notes;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Click.on(BTN_ADD),
                    // Personal data
                    Enter.theValue(firstname).into(TXT_FIRSTNAME),
                    Enter.theValue(middlename).into(TXT_MIDDLENAME),
                    Enter.theValue(lastname).into(TXT_LASTNAME),

                    // Vacancy
                    Click.on(LST_VACANCY),
                    Click.on(ITEM_VACANCY.of("Payroll Administrator")),

                    // Contact
                    Enter.theValue(email).into(TXT_EMAIL),
                    Enter.theValue(contactNumber).into(TXT_CONTACTNUMBER),

                    // Archive
                    Upload.theFile(Paths.get("src/test/resources/data.txt")).to(TXT_UPLOADFILE),
                    WaitUntil.the(FILE_NAME_LABEL, not(containsText("No file selected"))).forNoMoreThan(5).seconds(),
                    Enter.theValue(keyword).into(TXT_KEYWORD),

                    // Date application
                    Enter.keyValues(Keys.CONTROL, "a", Keys.BACK_SPACE).into(TXT_DATA_APPLICATION),
                    Enter.theValue(dataApplication).into(TXT_DATA_APPLICATION),

                    // Consent and save
                    Enter.theValue(notes).into(TXT_NOTES),
                    Click.on(CHK_CONSENT_KEEP_DATA), Click.on(BTN_SAVE));

        } catch (Exception e) {
            throw new FunctionalValidationException(CANDIDATE_FORM_INTERACTION_ERROR, e);
        }
    }

    public static AddCandidateTask withData(String firstname, String middlename, String lastname, String email, String contacnumber,
                                            String keyword, String dataApplication, String notes) {

        return Instrumented.instanceOf(AddCandidateTask.class).withProperties(firstname, middlename, lastname, email, contacnumber,
                keyword, dataApplication, notes);
    }
}