package ub.edu.resources.dao.MOCK.relationships;

import ub.edu.resources.dao.Duo;
import ub.edu.resources.dao.relationships.DAORelationInterestGroupTrivia;

public class DAORelationInterestGroupTriviaMOCK extends DAORelationMOCK<Duo<String,String>> implements DAORelationInterestGroupTrivia {

    public DAORelationInterestGroupTriviaMOCK() {
        addGrupInteresTrivia("Anime", "Qui és el director de 'The Dark Knight'?");
        addGrupInteresTrivia("Anime", "Qui és el protagonista de 'Breaking Bad'?");
        addGrupInteresTrivia("Anime", "Qui va dirigir 'Inception'?");
        addGrupInteresTrivia("Anime", "Quina pel·lícula va guanyar l'Oscar a millor pel·lícula el 2020?");

        addGrupInteresTrivia("Reality TV", "Quin actor interpreta Iron Man a Avengers: Endgame?");
        addGrupInteresTrivia("Reality TV", "Com es diu la filla de Tony Stark que apareix a la pel·lícula?");
        addGrupInteresTrivia("Reality TV", "Qui va dirigir 'The Avengers'?");
        addGrupInteresTrivia("Reality TV", "Quina pel·lícula va guanyar l'Oscar a millor pel·lícula el 2019?");

        addGrupInteresTrivia("Superheroes", "Qui és el protagonista de 'The Mandalorian'?");
        addGrupInteresTrivia("Superheroes", "Qui interpreta a Geralt de Rivia a 'The Witcher'?");
        addGrupInteresTrivia("Superheroes", "Qui sacrifica la seva vida per aconseguir la Gema de l'Ànima a 'Avengers: Endgame'?");
        addGrupInteresTrivia("Superheroes", "Qui va dirigir la pel·lícula 'Interstellar'?");

        addGrupInteresTrivia("Children's TV", "Qui interpreta a Michael Scott a 'The Office'?");
        addGrupInteresTrivia("Children's TV", "Com es diu el personatge principal de 'The Mandalorian'?");
        addGrupInteresTrivia("Children's TV", "Qui va dirigir la pel·lícula 'Avatar'?");
        addGrupInteresTrivia("Children's TV", "Quina pel·lícula va guanyar l'Oscar a millor pel·lícula el 2020?");


    }

    private boolean addGrupInteresTrivia(String nomGrup, String pregunta) {
        return relacions.add(new Duo<>(nomGrup, pregunta));
    }
}
