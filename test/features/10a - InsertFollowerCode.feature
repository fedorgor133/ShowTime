Feature: 10a - Insert Access Code
  As a follower of an interest group
  I want to enter a code
  To be able to join the interest group

  # Acceptance Criteria US10a.1: Insert correct code to become a member
  @LoadData
  Scenario: Insert correct code to become a member
    Given the user with email "ajaleo@gmail.com" is a follower of the interest group "Reality TV"
    When they select the game type "AccessCode" and the user enters the code "4623"
    Then the system will display the message "Correct code"

  # Acceptance Criteria US10a.2: Earn points for correct code
  @LoadData
  Scenario: Earn points for correct code
    Given the user with email "ajaleo@gmail.com" is a follower of the interest group "Reality TV"
    When the user has played the "AccessCode" game and entered the correct code
    Then the system will grant 150 points to the user

  # Acceptance Criteria US10a.3: Insert incorrect code to become a member
  @LoadData
  Scenario: Insert incorrect code to become a member
    Given the user with email "ajaleo@gmail.com" is a follower of the interest group "Reality TV"
    When they select the game type "AccessCode" and the user enters the code "1234"
    Then the system will display the message "Incorrect code"
