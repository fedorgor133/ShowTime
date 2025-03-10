package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AnswerQuizzQuestionSteps {

    private String category;
    private String answer;
    private String question;
    private int score;
    private final int totalQuestions = 5;
    private int answeredQuestions = 0;
    private final Random random = new Random();

    private final Map<String, String> questionsByCategory = new HashMap<String, String>() {{
        put("Science Fiction", "Question 1: What is the name of the fictional town where Stranger Things takes place?");
        put("Drama", "Question 2: What is Walter White’s alias in Breaking Bad?");
        put("Comedy", "Question 3: What is the name of the scientific theory that gives the name to The Big Bang Theory series?");
        put("Fantasy", "Question 4: What is the name of the magic school where Harry Potter studies?");
    }};

    private final Map<String, String> correctAnswers = new HashMap<String, String>() {{
        put("Question 1: What is the name of the fictional town where Stranger Things takes place?", "Hawkins");
        put("Question 2: What is Walter White’s alias in Breaking Bad?", "Heisenberg");
        put("Question 3: What is the name of the scientific theory that gives the name to The Big Bang Theory series?", "Big Bang");
        put("Question 4: What is the name of the magic school where Harry Potter studies?", "Hogwarts");
    }};

    @Before
    public void setUp() {
        score = 0;
        answeredQuestions = 0;
    }

    @Given("the 4-sided die is rolled to decide the category")
    public void theDieIsRolledToDecideTheCategory() {
        int categoryIndex = random.nextInt(4) + 1;
        switch (categoryIndex) {
            case 1: category = "Science Fiction"; break;
            case 2: category = "Drama"; break;
            case 3: category = "Comedy"; break;
            case 4: category = "Fantasy"; break;
        }
    }

    @When("the die is rolled and the corresponding category is selected randomly")
    public void theDieIsRolledAndCategoryIsSelected() {
        question = questionsByCategory.get(category);
    }

    @Then("the system selects and displays a question from the category resulting from the die roll")
    public void theSystemDisplaysQuestionFromCategory() {
        System.out.println("Displayed question: " + question);
    }

    @Given("the system displays a question to the user")
    public void theSystemDisplaysQuestionToUser() {
        if (question == null) {
            theDieIsRolledToDecideTheCategory();
            question = questionsByCategory.get(category);
        }
        System.out.println("Displayed question: " + question);
    }

    @When("the user enters the answer {string}")
    public void theUserEntersTheAnswer(String userAnswer) {
        this.answer = userAnswer;
    }

    @Then("the system validates if the response to the question is correct or incorrect")
    public void theSystemValidatesAnswer() {
        if (question == null) {
            throw new RuntimeException("No question available");
        }
        String correctAnswer = correctAnswers.get(question);
        if (correctAnswer == null) {
            throw new RuntimeException("Correct answer for question not found: " + question);
        }
        if (correctAnswer.equalsIgnoreCase(answer)) {
            System.out.println("Correct answer!");
        } else {
            System.out.println("Incorrect answer!");
        }
    }

    @Given("the user answers a question")
    public void theUserAnswersAQuestion() {
        answeredQuestions++;
    }

    @When("the user's answer is correct")
    public void theUsersAnswerIsCorrect() {
        score += 10;
        System.out.println("Correct answer!");
    }

    @Then("the system adds points to the user and displays the message \"correct answer\"")
    public void theSystemAddsPoints() {
        System.out.println("Correct answer! Current score: " + score);
    }

    @When("the user's answer is incorrect")
    public void theUsersAnswerIsIncorrect() {
        score -= 5;
        System.out.println("Incorrect answer!");
    }

    @Then("the system subtracts 5 points from the user and displays the message \"incorrect answer\"")
    public void theSystemSubtractsPoints() {
        System.out.println("Incorrect answer! Current score: " + score);
    }

    @Given("the user answers a question and it is not the last")
    public void theUserAnswersAQuestionAndItIsNotTheLast() {
        if (answeredQuestions < totalQuestions) {
            System.out.println("More questions remaining.");
        }
    }

    @When("the system has displayed whether the answer is correct or incorrect")
    public void theSystemDisplaysAnswerValidation() {}

    @Then("the system shows the next question")
    public void theSystemShowsNextQuestion() {
        if (answeredQuestions < totalQuestions) {
            int categoryIndex = random.nextInt(4) + 1;
            category = "Category " + categoryIndex;
            question = questionsByCategory.get(category);
            System.out.println("Next question: " + question);
        }
    }

    @Given("the user answers the last question")
    public void theUserAnswersLastQuestion() {
        answeredQuestions = totalQuestions;
    }

    @Then("the system ends the game and shows the final score")
    public void theSystemEndsGameAndShowsFinalScore() {
        System.out.println("The game is over. Final score: " + score);
    }
}
