Feature: 06c - Delete Watched History

  As a registered user
  I want to delete digital content I have watched
  In order to organize the tracking of content I have already watched.

    # Acceptance Criteria US6c.1: Delete content from WatchedHistory
  @LoadData
  Scenario: Delete content from WatchedHistory
    Given the user "ajaleo@gmail.com" has content saved in their WatchedHistory
    When the user selects "Interstellar" to delete
    Then the system will display the updated list
      | The Witcher |
      | Inception   |
      | The Matrix  |
