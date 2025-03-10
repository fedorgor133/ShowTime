package controller;

import model.exceptions.NotAvailableMoviesException;
import model.exceptions.NotAvailableShowsException;
import model.exceptions.PersonaNotFoundException;

// TO DO moure a controller + crear classes per exceptions
public enum Messages {

    // Exception messages
    ClientNotFound("Nonexistent mail"),
    DuplicatePersona("Existing person in the system"),
    WrongPassword("Incorrect password"),
    FormatIncorrecteException("Incorrectly formatted mail"),
    NotAvailableMovies("No films available"),
    NotAvailableMovie("Film not available in the system"),
    NotSecurePassword("Password not secure"),
    NotAvailableShows("No series available"),
    NotAvailableShow("This series is not available in the system"),
    ShowWithoutSeason("This series does not have this season"),
    ShowWithoutSeasons("This series has no seasons"),
    DuplicateSeason("This season already exists"),
    DuplicateEpisode("This episode already exists"),
    NotAvailableGroups("No available groups"),
    GroupNotFound("Interest group does not exists."),
    NoContentInGroup("There is no content in this interest group."),
    NoContentWatchedHistory("No content viewed"),
    NoContentWatchNext("No content to view"),
    WrongCode("Incorrect code"),
    ContinueBeingFollower("You are still a follower"),
    LeavingGroup("You are no longer a follower of the interest group"),
    WrongTrivia("Incorrect answer"),

    // Success messages
    SuccessfulFindPersona("Existing person in the system"),
    SuccessfulRegistreValid("Valid registration"),
    SuccessfulLogin("Correct login"),
    SuccessfulSecurePassword("Secure password"),
    SuccessfulFormatEmail("Mail in correct format"),
    SuccessfulFollowGroup("You are now following the interest group: "),
    SuccessfulUnfollowGroup("You no longer follow the interest group: "),
    SuccesfulCode("Correct code"),
    SuccesfulRuleta("You are now a member of the interest group"),
    SuccesfulTrivia("Correct answer");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String translate(Exception e) {
        // Depending on the type of the Exception we will return the corresponding message
        if (e instanceof PersonaNotFoundException) {
            return ClientNotFound.getMessage();
        } else if (e instanceof NotAvailableMoviesException) {
            return NotAvailableMovies.getMessage();
        } else if (e instanceof NotAvailableShowsException) {
            return NotAvailableShows.getMessage();
        } else {
            return "An error occurred";
        }
    }
}
