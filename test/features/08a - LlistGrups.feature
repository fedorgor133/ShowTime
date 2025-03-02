Feature: 08a - List Groups
  As a user/person,
  I want to list all the interest groups,
  To see if I find any that interest me.

  # Acceptance Criteria US8a.1: ORDER BY NAME
  @ResetData
  Scenario: List interest groups by name
    Given the following interest groups in the system
      | Interest Group      | Description  |
      | Anime               | A space for anime enthusiasts! Share theories, recommendations, and epic moments from your favorite animes, with humor and a dose of passion. |
      | Reality TV          | Here we talk about everything that happens in the reality world! From hilarious dramas to ridiculous moments, share your opinions and laugh with us! |
      | Superheroes         | A group for those who can’t resist debating about who the best superhero is. Share stories, comics, and theories about the superhero universe! |
      | Children’s TVs      | A place to remember our favorite cartoons! Share laughs and memories about the shows that made us grow and still make us smile. |

    When the user requests the list of interest groups by name
    Then the system will list the groups ordered by name
      | Anime           |
      | Children’s TVs  |
      | Reality TV      |
      | Superheroes     |

  # Acceptance Criteria US3a.2: Series associated with an interest group
  @ResetData
  Scenario: List series of an interest group by name
    Given the group "AccioExtrema" exists in the system
    And the group "AccioExtrema" is interested in the series
      | Series          |
      | Mandalorian     |
      | The Witcher     |
      | The Boys        |
    When the user requests the series of the group "AccioExtrema"
    Then the system will list the series of the group ordered by name
      | Mandalorian     |
      | The Boys        |
      | The Witcher     |
