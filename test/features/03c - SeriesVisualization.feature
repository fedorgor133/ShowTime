Feature: 03c - List the series catalog
  As a user,
  I want to list all available series,
  In order to view the content of ShowTVTime regarding series.

  # Acceptance Criteria US3b.1: ORDER SERIES BY NAME
  @ResetData
  Scenario: List series ordered by name
    Given the series available in the system are
      | Series              | Description                                                  | URL                | Release Year | Language | Duration |
      | Breaking Bad        | A high school teacher turned methamphetamine manufacturer     | URL_breakingbad    | 2008         | English  | 10       |
      | Chernobyl           | A series about the Chernobyl nuclear disaster                 | URL_chernobyl      | 2019         | English  | 9        |
      | Friends             | Follows the lives of six friends living in Manhattan          | URL_friends        | 1994         | English  | 9        |
      | Game of Thrones     | A series about the fight for the Iron Throne                  | URL_got            | 2011         | English  | 9        |
      | Peaky Blinders      | A gangster family in Birmingham, England, in 1919             | URL_peaky          | 2013         | English  | 9        |
      | Stranger Things     | Children in a town experience supernatural events             | URL_strangerthings | 2016         | English  | 9        |
      | The Big Bang Theory | A group of nerds and their interactions with a waitress         | URL_bigbang        | 2007         | English  | 8        |
      | The Crown           | The reign of Queen Elizabeth II                               | URL_crown          | 2016         | English  | 9        |
      | The Mandalorian     | A lone gunfighter makes his way through the galaxy             | URL_mandalorian    | 2019         | English  | 9        |
      | The Office          | A mockumentary on a group of office workers                    | URL_office         | 2005         | English  | 9        |
      | The Witcher         | The tale of Geralt of Rivia, a solitary monster hunter          | URL_witcher        | 2019         | English  | 9        |
    When the user requests the list of series by name
    Then the system will list the series ordered by name
      | Breaking Bad        |
      | Chernobyl           |
      | Friends             |
      | Game of Thrones     |
      | Peaky Blinders      |
      | Stranger Things     |
      | The Big Bang Theory |
      | The Crown           |
      | The Mandalorian     |
      | The Office          |
      | The Witcher         |
