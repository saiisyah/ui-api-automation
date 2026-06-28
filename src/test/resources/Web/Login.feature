@web

@Login

  Feature: Login
    @valid-login
    Scenario: user using registered email and password
      Given user is already on login page
      And user input login email "lalice@yopmail.com"
      And user input valid password "blackpink"
      When user click login button
      Then login is successful

    @invalid-login
    Scenario: user using wrong password
      Given user is already on login page
      And user input registered username "lalice@yopmail.com"
      And user input invalid password "123456"
      When user click login button
      Then login is failed
      And user see message "Wrong password."
