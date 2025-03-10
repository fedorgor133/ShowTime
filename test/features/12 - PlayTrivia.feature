Feature: 12 - Play the trivia game
  As a follower of an interest group
  I want to play a trivia game
  To have a chance to become a member of the interest group

    # Acceptance Criteria US12: Play the trivia game
  @LoadData
  Scenario: Play the trivia game
    Given the user with email "nancyarg10@yahoo.com" is a follower of the "Reality TV" group
    When the user plays the "Trivia" game and the category "Personatges" appears
    Then the system will display the question "Com es diu la filla de Tony Stark que apareix a la pel·lícula?"

    # Acceptance Criteria US12: Play the trivia game correct answer
  @LoadData
  Scenario: Play the trivia game correct answer
    Given the system displays the question "Qui va dirigir 'The Avengers'?" from the "Reality TV" group
    When the user with email "nancyarg10@yahoo.com" enters the answer "Joss Whedon" in "Trivia"
    Then the system will display the message "Correct answer"

    # Acceptance Criteria US12: Play the trivia game to earn points
  @LoadData
  Scenario: Play the trivia game to earn points
    Given the system displays the question "Com es diu la filla de Tony Stark que apareix a la pel·lícula?" from the "Reality TV" group
    When the user with email "nancyarg10@yahoo.com" enters the answer "Morgan Stark" in "Trivia"
    Then the user will earn 200 points

    # Acceptance Criteria US12: Play the trivia game incorrect answer
  @LoadData
  Scenario: Play the trivia game incorrect answer
    Given the system displays the question "Quina pel·lícula va guanyar l'Oscar a millor pel·lícula el 2019?" from the "Reality TV" group
    When the user with email "nancyarg10@yahoo.com" enters the answer "Roma" in "Trivia"
    Then the system will display the message "Incorrect answer"



