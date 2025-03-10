Feature: 06b - Save Watched History

  As a registered user
  I want to save digital content I have watched
  In order to organize the tracking of content I have already watched.

    # Acceptance Criteria US6c.1: Save content to WatchedHistory
  @LoadData
  Scenario: Save content to WatchedHistory
    Given the user "nancyarg10@yahoo.com" wants to save content to their WatchedHistory
    When the user selects "Game of Thrones" to save
    Then the system will display the updated WatchedHistory list
      | The Witcher     |
      | Interstellar    |
      | Game of Thrones |
      | Inception       |
      | The Matrix      |
