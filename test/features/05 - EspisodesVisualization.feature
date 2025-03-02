Feature: 05 - List episodes of a season of a series
  As a user,
  I want to list all the episodes of a season of a series,
  In order to see if I have time to watch the entire season.

  # Acceptance Criteria US5.1: The series does not exist
  @ResetData
  Scenario Outline: The series does not exist in the system
    Given the series "<name>" is not present in the system
    And the season "<season>" is not found because the series does not exist
    When the user requests the list of episodes of the series for season "<season>"
    Then the system will display the message "This series is not available in the system"

    Examples:
      | name             | season |
      | Stranger Things  | 7      |
      | The Witcher      | 2      |
      | Game of Thrones  | 5      |

  # Acceptance Criteria US5.2: The season does not exist
  @ResetData
  Scenario Outline: The series exists but the season is not present
    Given that the series "<name>" has its seasons added but not season "<season>"
    When the user requests the list of episodes of the series for season "<season>"
    Then the system will display the message "This series does not have this season"

    Examples:
      | name             | season |
      | Stranger Things  | 9      |
      | The Crown        | 6      |
      | Breaking Bad     | 8      |

  # Acceptance Criteria US5.3: The series has the season with episodes
  @ResetData
  Scenario: The series has the season with episodes
    Given we add the series "Stranger Things" with its corresponding seasons and episodes
    When the user requests the list of episodes of the series for season "1"
    Then the system will display the list of episodes of season "1" ordered by episode number
      | Chapter One: The Vanishing of Will Byers |
      | Chapter Two: The Weirdo on Maple Street  |
      | Chapter Three: Holly, Jolly             |
      | Chapter Four: The Body                  |
      | Chapter Five: The Flea and the Acrobat  |
      | Chapter Six: The Monster                |
      | Chapter Seven: The Bathtub              |
      | Chapter Eight: The Upside Down          |
