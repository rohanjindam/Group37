Feature: Payment Screen

  @PaymentScreen @DLUIApplication
  Scenario: Payment Screen
    Given User should login by launching DL-UI application
    Then Navigate to Payment Screen
    And Enter the details of Payment
    Then Navigate to Cool Off Screen
    And Enter the details of Cool Off
    Then Submit the details
