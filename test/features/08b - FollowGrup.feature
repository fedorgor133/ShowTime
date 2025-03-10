Feature: 08b - Manage Groups
    As a registered user,
    I want to follow a group
    So that I can see the list of content related to that group.

  # Acceptance Criteria US8b.1: Follow an interest group
    @LoadData
    Scenario: Follow an interest group
        Given the user with email "ajaleo@gmail.com" wants to follow the interest group "Anime"
        When the user starts following the interest group
        Then the system will display the message "You are now following the interest group: Anime"

  # Acceptance Criteria US8b.2: List series of the interest group
    @LoadData
    Scenario: List series of the interest group
        Given the user with email "ajaleo@gmail.com" follows the interest group "Anime"
        When the user wants to see the list of series of the interest group
        Then the system will display the list of the interest group
            | Breaking Bad    |
            | Game of Thrones |
            | Peaky Blinders  |
            | Stranger Things |
            | The Witcher     |

  # Acceptance Criteria US8b.3: List movies of the interest group
    @LoadData
    Scenario: List movies of the interest group
        Given the user with email "ajaleo@gmail.com" follows the interest group "Anime"
        When the user wants to see the list of movies of the interest group
        Then the system will display the list of the interest group
            | Avatar               |
            | Shawshank Redemption |
            | The Dark Knight      |

  # Acceptance Criteria US8b.4: List all content of the interest group
    @LoadData
    Scenario: List all content of the interest group
        Given the user with email "ajaleo@gmail.com" follows the interest group "Anime"
        When the user wants to see the list of content of the interest group
        Then the system will display the list of the interest group
            | Avatar               |
            | Breaking Bad         |
            | Game of Thrones      |
            | Peaky Blinders       |
            | Shawshank Redemption |
            | Stranger Things      |
            | The Dark Knight      |
            | The Witcher          |
