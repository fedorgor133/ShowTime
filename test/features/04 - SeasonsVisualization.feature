Feature: 04 - List seasons of a series
  As a user,
  I want to list all the seasons of a series,
  In order to see if I have time to watch the entire series.

  # Acceptance Criteria US4.1: The series does not exist
  @ResetData
  Scenario: The series does not exist in the system
    Given the series "Stranger Things" does not exist in the system
    When the user requests the list of seasons of the series
    Then the system will display the message "This series is not available in the system"

  # Acceptance Criteria US4.2: The series has no seasons
  @ResetData
  Scenario Outline: The series has no seasons added
    Given the series "<name>" exists in the system without seasons
    When the user requests the list of seasons of the series
    Then the system will display the message "This series has no seasons"

    Examples:
      | name             |
      | Stranger Things  |
      | The Crown        |
      | Breaking Bad     |

  # Acceptance Criteria US4.3: The series has seasons and they can be displayed correctly
  @ResetData
  Scenario: The series has seasons added
    Given the series "Stranger Things" with its corresponding seasons exists
    When the user requests the list of seasons of the series
    Then the system will display the list of seasons ordered by season number
      | 1  |
      | 2  |
      | 3  |
      | 4  |
      | 5  |
