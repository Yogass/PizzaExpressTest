Feature: Account Registration Test
  User can create an account on Pizza Express website and then check email for confirmation

  Scenario: Pizza Express Create an account page visibility
    Given User is on main page
    When User clicks Sign up button
    Then User should see page with CREATE AN ACCOUNT sign

  Scenario: User registers on the website
      Given Pizza Express registration page is open
      Then User chooses Title from dropdown list
      And User writes "Rob" in First name input field
      And User writes "Test" in Last name input field
      And User writes "autotesting74@yahoo.com" in Email address input field
      And User writes "07568345123" number in Mobile input field
      And User writes "10/1990" in Date of birth input field
      And User writes "KT152LS" in Postcode input field
      And User writes "Testing2321" in Create password inout field
      And User ticks Terms&Conditions information box
      And User ticks offers and news information box
      And User clicks Create my account button or log in
      Then User should see ROB'S PIZZAEXPRESS sign

  Scenario: User check email for confirmation email
    Given Yahoo website is open
    When User writes "autotesting74" into the email input field
    And User clicks Next button
    Then Password request page should be open
    Then User writes "Testing2321" into password input field and clicks Next button
    And User clicks Next button after typing password
    Then Main Inbox page should be open
    When User clicks on the email from Pizza Express
    Then User should see an open Email with "Welcome fellow pizza lover!" notification in the middle







