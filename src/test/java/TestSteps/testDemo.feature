Feature: Check User Credentials

  Scenario: Login to the TestProjectDemo application
    Given Go to TestProjectDemo Application
    And  Enter Credentials "<fullname>" and "<password>"
    Then Customer details page will display
#
#  Scenario: Login to the TestProjectDemo application with wrong Credentials
#    Given Go to TestProjectDemo Application
#    When  Enter wrong Credentials "<fullname>" and "<password>"
#    Then Customer details page should display
#
#    Scenario: Check the Profile page
#      Given Go to TestProjectDemo Application
#      And  Enter Credentials "<fullname>" and "<password>"
#      Then Customer details page will display with customer name
#
#      Scenario: Test the profile page details are saved
#        Given Go to TestProjectDemo Application
#        And  Enter Credentials "<fullname>" and "<password>"
#        Then Customer details page should display
#        And Enter customer details "<Country>" and "<Address>","<Email>" and "<Phone Number>"
#        Then  Click Save and Check details