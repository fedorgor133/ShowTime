package resources.dao.MOCK.entities;

import model.Question;
import resources.dao.entities.DAOQuestion;
import java.util.*;

public class DAOQuestionMOCK implements DAOQuestion {
    private List<Question> preguntes = new ArrayList<>();

    public DAOQuestionMOCK(){
        // Preguntes Anime
        addQuestion("Actor", "Qui és el director de 'The Dark Knight'?", "Christopher Nolan",
                List.of("Steven Spielberg", "Martin Scorsese", "Quentin Tarantino"));

        addQuestion("Personatges", "Qui és el protagonista de 'Breaking Bad'?", "Walter White",
                List.of("Jesse Pinkman", "Saul Goodman", "Hank Schrader"));

        addQuestion("Director", "Qui va dirigir 'Inception'?", "Christopher Nolan",
                List.of("Martin Scorsese", "Ridley Scott", "James Cameron"));

        addQuestion("Pel·lícules", "Quina pel·lícula va guanyar l'Oscar a millor pel·lícula el 2020?", "Parasite",
                List.of("1917", "Once Upon a Time in Hollywood", "Joker"));

        // Preguntes Reality TV
        addQuestion("Actor", "Quin actor interpreta Iron Man a Avengers: Endgame?", "Robert Downey Jr.",
                List.of("Chris Hemsworth", "Chris Evans", "Mark Ruffalo"));

        addQuestion("Personatges", "Com es diu la filla de Tony Stark que apareix a la pel·lícula?", "Morgan Stark",
                List.of("Pepper Potts", "Natasha Romanoff", "Carol Danvers"));

        addQuestion("Director", "Qui va dirigir 'The Avengers'?", "Joss Whedon",
                List.of("Zack Snyder", "James Gunn", "Russo Brothers"));

        addQuestion("Pel·lícules", "Quina pel·lícula va guanyar l'Oscar a millor pel·lícula el 2019?", "Green Book",
                List.of("Bohemian Rhapsody", "Black Panther", "Roma"));

        // Preguntes Superheroes
        addQuestion("Personatges", "Qui és el protagonista de 'The Mandalorian'?", "Pedro Pascal",
                List.of("John Boyega", "Mark Hamill", "Oscar Isaac"));

        addQuestion("Actor", "Qui interpreta a Geralt de Rivia a 'The Witcher'?", "Henry Cavill",
                List.of("Tom Hiddleston", "Chris Hemsworth", "Benedict Cumberbatch"));

        addQuestion("Pel·lícules", "Qui sacrifica la seva vida per aconseguir la Gema de l'Ànima a 'Avengers: Endgame'?", "Black Widow",
                List.of("Iron Man", "Captain America", "Hulk"));

        addQuestion("Director", "Qui va dirigir la pel·lícula 'Interstellar'?", "Christopher Nolan",
                List.of("Steven Spielberg", "Ridley Scott", "Martin Scorsese"));

        // Preguntes Children's TV
        addQuestion("Actor", "Qui interpreta a Michael Scott a 'The Office'?", "Steve Carell",
                List.of("Rainn Wilson", "John Krasinski", "Mindy Kaling"));

        addQuestion("Personatges", "Com es diu el personatge principal de 'The Mandalorian'?", "Din Djarin",
                List.of("Grogu", "Boba Fett", "Mace Windu"));

        addQuestion("Director", "Qui va dirigir la pel·lícula 'Avatar'?", "James Cameron",
                List.of("Steven Spielberg", "George Lucas", "Ridley Scott"));

        addQuestion("Pel·lícules", "Quina pel·lícula surcoreana va guanyar l'Oscar a millor pel·lícula el 2020?", "Parasite",
                List.of("1917", "Once Upon a Time in Hollywood", "Joker"));
    }

    public void addQuestion(String category, String statement, String correctAnswer, List<String> incorrectAnswers) {
        preguntes.add(new Question(category, statement, correctAnswer, incorrectAnswers));
    }

    @Override
    public Optional<Question> getById(String[] id) throws Exception {
        return Optional.empty();
    }

    @Override
    public boolean update(Question question, String[] params) throws Exception {
        return false;
    }

    @Override
    public List<Question> getAll() throws Exception {
        return preguntes;
    }

    @Override
    public boolean add(Question question) throws Exception {
        preguntes.add(question);
        return true;
    }

    @Override
    public boolean delete(Question question) throws Exception {
        return preguntes.remove(question);
    }

}
