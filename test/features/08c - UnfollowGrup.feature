Feature: 08c - Manage Groups
    As a registered user,
    I want to unfollow a group
    So that it no longer shows me content related to that group.

  # Acceptance Criteria US8c.1: Unfollow an interest group
    @LoadData
    Scenario: Unfollow an interest group
        Given the user "ajaleo@gmail.com" wants to unfollow the interest group "Anime"
        When the user unfollows the interest group
        Then the system will display the message "You no longer follow the interest group: Anime"

