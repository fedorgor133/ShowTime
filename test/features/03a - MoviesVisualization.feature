Feature: 03a - List the movie catalog
  As a user/person,
  I want to list all available movies,
  In order to view the content of ShowTVTime.

  # Acceptance Criteria US3a.1: ORDER BY NAME
  @ResetData
  Scenario: List movies ordered by name
    Given the movies available in the system are
      | Movie         | Release Year | Duration |
      | Barbie        | 2023         | 116      |
      | El Padrino    | 1972         | 175      |
      | El Padrino 2  | 1974         | 202      |
      | El Padrino 3  | 1990         | 162      |
      | Oppenheimer   | 2023         | 180      |
    When the user requests the list of movies by name
    Then the system will list the movies ordered by name
      | Barbie       |
      | El Padrino   |
      | El Padrino 2 |
      | El Padrino 3 |
      | Oppenheimer  |

  # Acceptance Criteria US3a.2: ORDER BY RELEASE YEAR
  @ResetData
  Scenario: List movies ordered by release year
    Given the movies available in the system are
      | Movie         | Release Year | Duration |
      | Barbie        | 2023         | 116      |
      | El Padrino    | 1972         | 175      |
      | El Padrino 2  | 1974         | 202      |
      | El Padrino 3  | 1990         | 162      |
      | Oppenheimer   | 2023         | 180      |
    When the user requests the list of movies by release year
    Then the system will list the movies ordered by release year
      | Oppenheimer  |
      | Barbie       |
      | El Padrino 3 |
      | El Padrino 2 |
      | El Padrino   |

  # Acceptance Criteria US3a.3: ORDER BY NAME FROM THE DATABASE
  @ResetData
  Scenario: List movies from the database ordered by name
    Given the movies available in the database
    When the user requests the list of movies by name
    Then the system will list the movies ordered by name
      | Avatar                |
      | Avengers: Endgame     |
      | Inception             |
      | Interstellar          |
      | Parasite              |
      | Shawshank Redemption  |
      | The Dark Knight       |
      | The Godfather         |
      | The Matrix            |
