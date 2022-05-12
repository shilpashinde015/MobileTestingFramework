Feature: Check User Credentials

  Scenario: Login to the Eribank application
    Given Go to Eribank Application
    When  User enters "<username>" and "<password>"
    Then Homepage will display

