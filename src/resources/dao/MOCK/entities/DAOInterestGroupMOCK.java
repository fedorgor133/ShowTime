package resources.dao.MOCK.entities;

import model.InterestGroup;
import resources.dao.entities.DAOInterestGroup;

import java.util.*;

public class DAOInterestGroupMOCK implements DAOInterestGroup {

    private Map<String, InterestGroup> llistaGrupInteres = new HashMap<>();

    public DAOInterestGroupMOCK(){
        addInterestGroup("Anime", "Un espai per als apassionats de l'anime! Comparteix teories, recomanacions i moments èpics dels teus animes favorits, amb bon humor i una dosi de passió.", "1234");
        addInterestGroup("Reality TV", "Aquí parlem de tot el que passa en el món del reality! Des de drames hilarants fins a moments ridículs, comparteix les teves opinions i riu amb nosaltres!", "4623");
        addInterestGroup("Superheroes", "Un grup per als que no poden resistir-se a debatre sobre qui és el millor superheroi. Comparteix històries, còmics i teories sobre l'univers dels superherois!", "4301");
        addInterestGroup("Children’s TVs", "Un lloc per recordar els nostres dibuixos animats preferits! Compartim riures i records sobre sèries que ens van fer créixer i que encara ens fan somriure.", "8643");
    }

    private void addInterestGroup(String groupName, String description, String code) {
        llistaGrupInteres.put(groupName, new InterestGroup(groupName, description, code));
    }

    @Override
    public Optional<InterestGroup> getById(String[] id) throws Exception {
        return Optional.ofNullable(llistaGrupInteres.get(Objects.requireNonNull(id[0], "Group name cannot be null")));
    }

    @Override
    public List<InterestGroup> getAll() throws Exception {
        return new ArrayList<>(llistaGrupInteres.values());
    }

    @Override
    public boolean add(InterestGroup interestGroup) throws Exception {
        if (getById(new String[]{interestGroup.getGroupName()}).isPresent()) {
            return false;
        }
        llistaGrupInteres.put(interestGroup.getGroupName(), interestGroup);
        return true;
    }

    @Override
    public boolean update(InterestGroup interestGroup, String[] params) throws Exception {
        interestGroup.setGroupName(
                Objects.requireNonNull(params[0], "Group name cannot be null"));
        interestGroup.setDescription(
                Objects.requireNonNull(params[1], "Group description cannot be null"));
        return llistaGrupInteres.replace(interestGroup.getGroupName(), interestGroup) != null;
    }

    @Override
    public boolean delete(InterestGroup interestGroup) throws Exception {
        return llistaGrupInteres.remove(interestGroup.getGroupName()) != null;
    }

}
