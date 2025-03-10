Feature: 11 - Play the Roulette
  As a follower of an interest group
  I want to play the roulette
  To have a chance to become a member of the interest group

  # Acceptance Criteria US11: Play the roulette and get "continue as Follower"
  @LoadData
  Scenario: Become a member after playing the roulette
    Given the user email "ajaleo@gmail.com" is a follower of the interest group "Children’s TVs"
    When they select the game type "Roulette" and the result is 0
    Then the system will display the message "You are still a follower"

  # Acceptance Criteria US11: Play the roulette and get "become a member"
  @LoadData
  Scenario: Play the roulette
    Given the user email "ajaleo@gmail.com" is a follower of the interest group "Children’s TVs"
    When they select the game type "Roulette" and the result is 1
    Then the system will display the message "You are now a member of the interest group"

  # Acceptance Criteria US11: Play the roulette and get "no longer part of the group"
  @LoadData
  Scenario: Play the roulette
    Given the user email "ajaleo@gmail.com" is a follower of the interest group "Children’s TVs"
    When they select the game type "Roulette" and the result is 2
    Then the system will display the message "You are no longer a follower of the interest group"
