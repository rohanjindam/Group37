Feature: FI Info screen for creating the user

  @FI-Info @DLUIApplication
  Scenario: FI Info Positive flow
    Given User should login by launching DL-UI application
    When User navigates to FI-Info screen
    And User has entered Client Company Name
    Then Submit the details
