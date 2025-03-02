Feature: 09 - Validate game responses
  As a registered user,
  I want to answer a game question related to an interest group, based on a roll of a 4-sided die,
  To be able to validate whether I answered correctly or not.

  # Acceptance Test 1: Die Roll
  Scenario: Roll the die to decide the category
    Given the 4-sided die is rolled to decide the category
    When the die is rolled and the corresponding category is selected randomly
    Then the system selects and displays a question from the category resulting from the die roll

  # Acceptance Test 2: Validate user response
  Scenario: Validate response to a displayed question
    Given the system displays a question to the user
    When the user enters the answer "Answer"
    Then the system validates if the response to the question is correct or incorrect

  # Acceptance Test 3: Correct answer
  Scenario: Answer a question correctly
    Given the user answers a question
    When the user's answer is correct
    Then the system adds points to the user and displays the message "correct answer"

  # Acceptance Test 4: Incorrect answer
  Scenario: Answer a question incorrectly
    Given the user answers a question
    When the user's answer is incorrect
    Then the system subtracts 5 points from the user and displays the message "incorrect answer"

  # Acceptance Test 5: Show next question
  Scenario: Show next question if it is not the last
    Given the user answers a question and it is not the last
    When the system has displayed whether the answer is correct or incorrect
    Then the system shows the next question

  # Acceptance Test 6: End the game
  Scenario: End the game after the last question
    Given the user answers the last question
    Then the system ends the game and shows the final score

