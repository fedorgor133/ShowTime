Feature: 07a - View WatchNext
  As a registered user
  When I view the content of WatchNext
  To easily access the movies or series I want to watch.

  # Acceptance Criteria US7.1: The user has content in WatchNext
  @LoadData
  Scenario: List content to watch in WatchNext
    Given the user with email "ajaleo@gmail.com" has content saved in their WatchNext
    When they try to access their WatchNext
    Then the system will display a list of content to watch
      | Chernobyl           |
      | The Mandalorian     |
      | Stranger Things     |
      | The Crown           |
      | Peaky Blinders      |
      | Game of Thrones     |
      | Breaking Bad        |
      | The Big Bang Theory |
      | Friends             |

  # Acceptance Criteria US6a.2: The user has no content in WatchNext
  @ResetData
  Scenario: List empty WatchNext
    Given the user with email "ajaleo@gmail.com" has no content in their WatchNext yet
    When they try to access their WatchNext
    Then the system should show the message "No content to view"





