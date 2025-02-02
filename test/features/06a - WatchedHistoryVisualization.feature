Feature: 06a - View Watched History

  As a registered user,
  I want to see a list of the digital content I have watched
  In order to better track the content I have already watched.

    # Acceptance Criteria US6a.1: The user has watched content
  @LoadData
  Scenario: List watched content in WatchedHistory
    Given the user with email "ajaleo@gmail.com" has content saved in WatchedHistory
    When they try to access their WatchedHistory
    Then the system will display a list of the watched content, ordered by most recent first
      | The Witcher  |
      | Interstellar |
      | Inception    |
      | The Matrix   |

    # Acceptance Criteria US6a.2: The user has no watched content
  @ResetData
  Scenario: List empty WatchedHistory
    Given the user with email "ajaleo@gmail.com" has no content saved in WatchedHistory
    When they try to access their WatchedHistory
    Then the system display the message "No content viewed"

