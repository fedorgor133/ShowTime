package ub.edu.resources.dao.MOCK.entities;

import ub.edu.resources.dao.entities.DAOInterestGroup;

import ub.edu.model.*;

import java.util.*;

public class DAOInterestGroupMOCK implements DAOInterestGroup {

    private Map<String, GrupInterest> llistaGrupInteres = new HashMap<>();

    public DAOInterestGroupMOCK(){
        addGrupInteres("Anime", "Un espai per als apassionats de l'anime! Comparteix teories, recomanacions i moments èpics dels teus animes favorits, amb bon humor i una dosi de passió.", "1234");
        addGrupInteres("Reality TV", "Aquí parlem de tot el que passa en el món del reality! Des de drames hilarants fins a moments ridículs, comparteix les teves opinions i riu amb nosaltres!", "4623");
        addGrupInteres("Superheroes", "Un grup per als que no poden resistir-se a debatre sobre qui és el millor superheroi. Comparteix històries, còmics i teories sobre l'univers dels superherois!", "4301");
        addGrupInteres("Children’s TVs", "Un lloc per recordar els nostres dibuixos animats preferits! Compartim riures i records sobre sèries que ens van fer créixer i que encara ens fan somriure.", "8643");
    }

    private void addGrupInteres(String nomGrup, String descripcio, String codi){
        llistaGrupInteres.put(nomGrup, new GrupInterest(nomGrup, descripcio, codi ));
    }

    @Override
    public Optional<GrupInterest> getById(String[] id) throws Exception {
        return Optional.ofNullable(llistaGrupInteres.get(Objects.requireNonNull(id[0], "Group name cannot be null")));
    }

    @Override
    public List<GrupInterest> getAll() throws Exception {
        return new ArrayList<>(llistaGrupInteres.values());
    }

    @Override
    public boolean add(GrupInterest grupInterest) throws Exception {
        if (getById(new String[]{grupInterest.getGroupName()}).isPresent()) {
            return false;
        }
        llistaGrupInteres.put(grupInterest.getGroupName(), grupInterest);
        return true;
    }

    @Override
    public boolean update(GrupInterest grupInterest, String[] params) throws Exception {
        grupInterest.setGroupName(
                Objects.requireNonNull(params[0], "Group name cannot be null"));
        grupInterest.setDescription(
                Objects.requireNonNull(params[1], "Group description cannot be null"));
        return llistaGrupInteres.replace(grupInterest.getGroupName(), grupInterest) != null;
    }

    @Override
    public boolean delete(GrupInterest grupInterest) throws Exception {
        return llistaGrupInteres.remove(grupInterest.getGroupName()) != null;
    }
}
