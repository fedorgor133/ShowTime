Feature: 13 - Decision to become a member
  As a follower of an interest group
  I want to choose options to become a member
  To be able to opt for a specific option

    # Acceptance Criteria US13: Decision to become a member
  @LoadData
  Scenario: Decision to become a member
    Given the user "ajaleo@gmail.com" is a follower of the "Children’s TVs" interest group
    When the user goes to the option to become a member
    Then the system will display the options to become a member

  Scenario: Enter code to become a member
    Given the user "ajaleo@gmail.com" is a follower of the "Reality TV" interest group
    When the user selects the game type "AccessCode" and enters the code "4623"
    Then the system will display the message "Correct code"

  @LoadData
  Scenario: Member selects Roulette
    Given the user "ajaleo@gmail.com" is a follower of the "Children’s TVs" interest group
    When the user plays the "Roulette" game and the result is 1
    Then the system will display the message "You are now a member of the interest group"


