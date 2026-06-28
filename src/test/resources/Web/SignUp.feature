@web

@SignUp

  Feature: Sign Up
    @valid-SignUp
    Scenario: SignUp using valid email and password
      Given user is already on Dashboard
      And user click Sign up menu
      And user input valid email
      And user input sign up password "nmixx"
      When user click the signup button
      Then Sign up successful.

    @invalid-signup
    Scenario: SignUp with registered email
      Given user is already on Dashboard
      And user click Sign up menu
      And user input registered email "lalice@yopmail.com"
      And user input sign up password "blackpink"
      When user click the signup button
      Then user cannot SignUp
      And user see sign up message "This user already exist."
