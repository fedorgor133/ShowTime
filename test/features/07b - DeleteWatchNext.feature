Feature: 07b - Delete WatchNext
  As a registered user
  When I want to remove a content from my WatchNext
  To see only the content that interests me.

  # Acceptance Criteria US6b.1: The user has no viewed content
  @LoadData
  Scenario: Remove unwanted content from WatchNext
    Given the user "ajaleo@gmail.com" has content saved in their WatchNext
    When they want to remove "Stranger Things" because they are not interested
    Then the system display the updated list
      | Chernobyl           |
      | The Mandalorian     |
      | The Crown           |
      | Peaky Blinders      |
      | Game of Thrones     |
      | Breaking Bad        |
      | The Big Bang Theory |
      | Friends             |

