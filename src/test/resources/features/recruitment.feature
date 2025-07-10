Feature: Recruitment
  Background:Successful login
    Given the user is on the website
    When the user enter their credentials and click the submit button
    Then the user see the validation message

    @Recruitment
    Scenario: Successful recruitment
      Given the user is in the recruitment module

      When the user registers a new candidate with valid data
      And the system should display a success message confirming the candidate was saved

      And shortlists the candidate
      And schedules an interview
      And marks the candidate as approved

      Then the candidate should appear in the found records section with status hired