package resources.dao.MOCK.relationships;

import resources.dao.Duo;
import resources.dao.relationships.DAORelationInterestGroupTrivia;

public class DAORelationInterestGroupTriviaMOCK extends DAORelationMOCK<Duo<String,String>> implements DAORelationInterestGroupTrivia {

    public DAORelationInterestGroupTriviaMOCK() {
        addInterestGroupTrivia("Anime", "Qui és el director de 'The Dark Knight'?");
        addInterestGroupTrivia("Anime", "Qui és el protagonista de 'Breaking Bad'?");
        addInterestGroupTrivia("Anime", "Qui va dirigir 'Inception'?");
        addInterestGroupTrivia("Anime", "Quina pel·lícula va guanyar l'Oscar a millor pel·lícula el 2020?");

        addInterestGroupTrivia("Reality TV", "Quin actor interpreta Iron Man a Avengers: Endgame?");
        addInterestGroupTrivia("Reality TV", "Com es diu la filla de Tony Stark que apareix a la pel·lícula?");
        addInterestGroupTrivia("Reality TV", "Qui va dirigir 'The Avengers'?");
        addInterestGroupTrivia("Reality TV", "Quina pel·lícula va guanyar l'Oscar a millor pel·lícula el 2019?");

        addInterestGroupTrivia("Superheroes", "Qui és el protagonista de 'The Mandalorian'?");
        addInterestGroupTrivia("Superheroes", "Qui interpreta a Geralt de Rivia a 'The Witcher'?");
        addInterestGroupTrivia("Superheroes", "Qui sacrifica la seva vida per aconseguir la Gema de l'Ànima a 'Avengers: Endgame'?");
        addInterestGroupTrivia("Superheroes", "Qui va dirigir la pel·lícula 'Interstellar'?");

        addInterestGroupTrivia("Children's TV", "Qui interpreta a Michael Scott a 'The Office'?");
        addInterestGroupTrivia("Children's TV", "Com es diu el personatge principal de 'The Mandalorian'?");
        addInterestGroupTrivia("Children's TV", "Qui va dirigir la pel·lícula 'Avatar'?");
        addInterestGroupTrivia("Children's TV", "Quina pel·lícula va guanyar l'Oscar a millor pel·lícula el 2020?");


    }

    private boolean addInterestGroupTrivia(String groupName, String question) {
        return relations.add(new Duo<>(groupName, question));
    }
}
