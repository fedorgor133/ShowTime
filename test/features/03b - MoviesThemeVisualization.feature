Feature: 03b - List movies by genre
  As a user/person,
  I want to list the available movies by genre,
  In order to view the content of ShowTVTime.

  # Acceptance Criteria US3b.1: List movies for a genre
  @ResetData
  Scenario: List movies for a genre
    Given the genres available in the system
      | Genre    |
      | Sci-Fi   |
      | Action   |
      | Drama    |
      | Thriller |
      | Fantasy  |
      | Comedy   |
    And the movies with genres in the system
      | Movie       | Description                                           | URL              | Release Year | Language | Duration | Rating | Genre  |
      | Inception   | A thief who enters the subconscious of his targets    | URL_inception    | 2010         | English  | 148      | 10     | Sci-Fi |
      | Interstellar| A journey through a wormhole near Saturn              | URL_interstellar | 2014         | English  | 169      | 9.5f   | Sci-Fi |
      | The Matrix  | A computer hacker learns about the nature of reality  | URL_matrix       | 1999         | English  | 136      | 9      | Sci-Fi |
      | Avatar      | An epic science fiction film                          | URL_avatar       | 2009         | English  | 162      | 8      | Sci-Fi |
      | El Padrino  | The most known movie about the Mafia                  | URL_elPadrino    | 1972         | English  | 215      | 10     | Drama  |
    When the user requests the list of movies for the genre "Sci-Fi"
    Then the system will list the movies for the genre "Sci-Fi"
      | Avatar       |
      | Inception    |
      | Interstellar |
      | The Matrix   |
