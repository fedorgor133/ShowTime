package controller;

import model.*;
import model.exceptions.PersonaNotFoundException;
import java.util.*;

public class ManagementLists {
    private PortfolioPeople portfolioPeople;
    private Map<String, Movie> llistaPelicules;
    private Map<String, Series> llistaSeries;
    private Map<String, InterestGroup> llistaGrupInters;

    public ManagementLists(PortfolioPeople portfolioPeople, Map<String, Movie> llistaPelicules, Map<String, Series> llistaSeries, Map<String, InterestGroup> llistaGrupInters) {
        this.portfolioPeople = portfolioPeople;
        this.llistaPelicules = llistaPelicules;
        this.llistaSeries = llistaSeries;
        this.llistaGrupInters = llistaGrupInters;
    }

    public void addContentWatchedHistory(String nomUsuari, String titol) {
        try {
            Person person = portfolioPeople.find(nomUsuari);
            AudiovisualContent contingut = llistaPelicules.get(titol);
            if (contingut == null) {
                contingut = llistaSeries.get(titol);
            }
            if (contingut == null) {
                Messages.NotAvailableShow.getMessage();
            }

            person.addWatchedHistory(contingut);
        } catch (PersonaNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteContentWatchedHistory(String nomUsuari, String titol) {
        try {
            Person person = portfolioPeople.find(nomUsuari);
            AudiovisualContent contingut = llistaPelicules.get(titol);
            if (contingut == null) {
                contingut = llistaSeries.get(titol);
            }
            if (contingut == null) {
                Messages.NotAvailableShow.getMessage();
            }

            person.removeWatchedHistory(contingut);
        } catch (PersonaNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> viewWatchedHistory(String nomUsuari) {
        try {
            Person person = portfolioPeople.find(nomUsuari);
            List<AudiovisualContent> watchedHistory = person.getWatchedHistory();
            if (watchedHistory.isEmpty()) {
                return List.of(Messages.NoContentWatchedHistory.getMessage());
            }
            Collections.sort(watchedHistory, new Comparator<AudiovisualContent>() {
                @Override
                public int compare(AudiovisualContent o1, AudiovisualContent o2) {
                    return Integer.compare(o2.getYearFirstRelease(), o1.getYearFirstRelease());
                }
            });

            List<String> titles = new ArrayList<>();
            for (AudiovisualContent contingut : watchedHistory) {
                titles.add(contingut.getTitle());
            }
            return titles;
        } catch (PersonaNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void emptyWatchedHistory(String nomUsuari) {
        try {
            Person person = portfolioPeople.find(nomUsuari);
            person.emptyWatchedHistory();
        } catch (PersonaNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void emptyWatchNext(String nomUsuari) {
        try {
            Person person = portfolioPeople.find(nomUsuari);
            person.emptyWatchNext();
        } catch (PersonaNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addContentWatchNext(String nomUsuari, String titol) {
        try {
            Person person = portfolioPeople.find(nomUsuari);
            AudiovisualContent contingut = llistaPelicules.get(titol);
            if (contingut == null) {
                contingut = llistaSeries.get(titol);
            }
            if (contingut == null) {
                Messages.NotAvailableShow.getMessage();
            }
            person.addWatchNext(contingut);
        } catch (PersonaNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> viewWatchNext(String nomUsuari) {
        try {
            Person person = portfolioPeople.find(nomUsuari);
            List<AudiovisualContent> watchNext = person.getWatchNext();
            if (watchNext.isEmpty()) {
                return List.of(Messages.NoContentWatchNext.getMessage());
            }
            Collections.sort(watchNext, new Comparator<AudiovisualContent>() {
                @Override
                public int compare(AudiovisualContent o1, AudiovisualContent o2) {
                    return Integer.compare(o2.getYearFirstRelease(), o1.getYearFirstRelease());
                }
            });

            List<String> titles = new ArrayList<>();
            for (AudiovisualContent contingut : watchNext) {
                titles.add(contingut.getTitle());
            }
            return titles;
        } catch (PersonaNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteContentWatchNext(String nomUsuari, String titol) {
        try {
            Person person = portfolioPeople.find(nomUsuari);
            AudiovisualContent contingut = llistaPelicules.get(titol);
            if (contingut == null) {
                contingut = llistaSeries.get(titol);
            }
            if (contingut == null) {
                Messages.NotAvailableShow.getMessage();
            }
            person.removeWatchNext(contingut);
        } catch (PersonaNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String followGroup(String nomGrup, String usuari) {
        try {
            Person person = portfolioPeople.find(usuari);
            InterestGroup grup = llistaGrupInters.get(nomGrup);
            if (grup != null) {
                grup.addFollower(person);
                return Messages.SuccessfulFollowGroup.getMessage() + nomGrup;
            } else {
                return Messages.GroupNotFound.getMessage();
            }
        } catch (PersonaNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String unfollowGroup(String nomGrup, String usuari) {
        try {
            Person person = portfolioPeople.find(usuari);
            InterestGroup grup = llistaGrupInters.get(nomGrup);
            if (grup != null) {
                grup.removeFollower(person);
                return Messages.SuccessfulUnfollowGroup.getMessage() + nomGrup;
            } else {
                return Messages.GroupNotFound.getMessage();
            }
        } catch (PersonaNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String becomeMember(String nomGrup, String usuari, String joc, Params params) {
        InterestGroup grup = llistaGrupInters.get(nomGrup);
        if (grup != null) {
            Person person = grup.getFollower(usuari);
            MemberStrategy strategy = StrategyFactory.createGameStrategy(joc, params);
            GameContext context = new GameContext();
            context.setStrategy(strategy);
            return context.executeStrategy(grup, person);
        } else {
            return Messages.GroupNotFound.getMessage();
        }
    }

    public String getAccessCode(String grup) {
        InterestGroup interestGroup = llistaGrupInters.get(grup);
        if (interestGroup != null) {
            return interestGroup.getAccessCode();
        } else {
            return Messages.GroupNotFound.getMessage();
        }
    }


    public int getUserPoints(String nomGrup, String usuari) {
        try {
            InterestGroup grup = llistaGrupInters.get(nomGrup);
            Person person = portfolioPeople.find(usuari);
            if (grup != null && person != null) {
                return grup.getMemberPoints(person);
            } else {
                return 0;
            }
        } catch (PersonaNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
