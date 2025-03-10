Feature: 02 - Person Login
  As a registered person in the ShowTVTime app
  I want to log into my account
  In order to access the application's features

  @LoadData
  Scenario: Incorrect password
    Given a user with email "ajaleo@gmail.com" and password "INVENTADA11"
    When I try to log in with the email "ajaleo@gmail.com" and the password "INVENTADA11"
    Then the system will display the message "Incorrect password"

  @LoadData
  Scenario: Nonexistent email
    Given a user with email "gatigos@gmail.com" and password "INVENTADA11"
    When I try to log in with the email "gatigos@gmail.com" and the password "INVENTADA11"
    Then the system will display the message "Nonexistent mail"

  @LoadData
  Scenario: Recover password
    Given a user with email "ajaleo@gmail.com"
    When requesting password recovery for the email "ajaleo@gmail.com"
    Then the system will display the message "ajaleoPassw7"

  @LoadData
  Scenario Outline: Validate login with multiple users
    Given a user with email "<user>" and password "<password>"
    When I try to log in with the email "<user>" and the password "<password>"
    Then the system will display the message "<expectedResult>"

    Examples:
      | user                 | password     | expectedResult    |
      | ajaleo@gmail.com     | ajaleoPassw7 | Correct login    |
      | dtomacal@yahoo.cat   | Qwertyft5    | Correct login    |
      | inventat@yahoo.cat   | INVENTADA11  | Nonexistent mail |
