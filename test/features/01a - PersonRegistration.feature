Feature: 01 - Person Registration
  As a non-recorded user
  I want to register in the application with the corresponding data
  To become a ShowTVTime customer and access the application's content

  @LoadData
  Scenario: Existing person identifier (email)
    Given the existing person with email "ajaleo@gmail.com"
    When I try to register with the email "ajaleo@gmail.com"
    Then the system will display the message "Existing person in the system"

  @LoadData
  Scenario: Unsecure password
    Given there is no registered user with the email "nouusuari@domini.com"
    When I try to register with the email "nouusuari@domini.com" and a password "werty"
    Then the system will display the message "Password not secure"

  @LoadData
  Scenario: Secure password
    Given there is no registered user with the email "nouusuari@domini.com"
    When I want to set a password "Qwertyuiop9"
    Then the system will display the message "Secure password"

  @LoadData
  Scenario: Invalid email format
    Given there is no registered user with the email "ajaleonougmail.com"
    When I try to register with the email "ajaleonougmail.com" and a password "ValidPass123"
    Then the system will display the message "Incorrectly formatted mail"

    Given there is no registered user with the email "ajaleonou@gmailcom"
    When I try to register with the email "ajaleonou@gmailcom" and a password "ValidPass123"
    Then the system will display the message "Incorrectly formatted mail"

  @LoadData
  Scenario Outline: Multiple registrations as test examples, assuming users already exist in the system
    Given there is no registered user with the email "<person>"
    And the user "ajaleo@gmail.com" already exists in the system
    When I try to register with the email "<person>" and a password "<password>"
    Then the system will display the message "<result>"

    Examples:
      | person                 | password       | result                           |
      | ajaleonew@gmail.com    | 12wreTry       | Valid registration               |
      | pepito@domini.cat      | qwerfrdsE1     | Valid registration               |
      | ajaleo@gmail.com       | qwerfrdsE1     | Existing person in the system    |
      | pepitonew@domini.cat   | qwert          | Password not secure              |