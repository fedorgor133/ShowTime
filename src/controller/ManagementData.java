package controller;

import model.PortfolioPeople;
import model.Person;
import resources.service.DataService;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagementData {
    private PortfolioPeople portfolioPeople;
    private DataService dataService;

    public ManagementData(DataService dataService, PortfolioPeople portfolioPeople) {
        this.dataService = dataService;
        this.portfolioPeople = portfolioPeople;
    }

    public void loadData() {
        loadCarteraPersones();
    }

    public void resetData() {
        portfolioPeople = new PortfolioPeople();
    }

    private boolean loadCarteraPersones() {
        List<Person> people;
        try {
            people = dataService.getAllPersones();
        } catch (Exception e) {
            return false;
        }

        if (people != null) {
            portfolioPeople = new PortfolioPeople(people);
            return true;
        }
        return false;
    }

    // Validar els registres de les persones a la capa de persistència i no a memòria, per seguretat de les possibles sincronitzacions
    public String validatePersonRegistration(String username, String password) {
        if (!isMail(username) && !isPasswordSegur(password)) {
            return Messages.FormatIncorrecteException.getMessage() + " " + Messages.NotSecurePassword.getMessage();
        } else if (!isMail(username)) {
            return Messages.FormatIncorrecteException.getMessage();
        } else if (!isPasswordSegur(password)) {
            return Messages.NotSecurePassword.getMessage();
        }
        try {
            portfolioPeople.find(username);
            return Messages.DuplicatePersona.getMessage();
        } catch (Exception e) {
            return Messages.SuccessfulRegistreValid.getMessage();
        }
    }

    public String validatePassword(String b) {
        if (!isPasswordSegur(b)) {
            return Messages.NotSecurePassword.getMessage();
        }
        return Messages.SuccessfulSecurePassword.getMessage();
    }

    public String validateUsername(String b)  {
        if (!isMail(b)) {
            return Messages.FormatIncorrecteException.getMessage();
        }
        return Messages.SuccessfulFormatEmail.getMessage();
    }

    public boolean isPasswordSegur(String password) {
        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public boolean isMail(String correu) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(correu);
        return matcher.find();
    }

    public String loginPerson(String username, String password) {
        try {
            Person person = portfolioPeople.find(username);
            if (person.getPwd().equals(password)) {
                return Messages.SuccessfulLogin.getMessage();
            }
            return Messages.WrongPassword.getMessage();
        } catch (Exception e) {
            return Messages.translate(e);
        }
    }

    public String recoverPassword(String username) {
        try {
            Person person = portfolioPeople.find(username);
            return person.getPwd();
        } catch (Exception e) {
            return Messages.translate(e);
        }
    }

    public String findPersona(String username) {
        try {
            portfolioPeople.find(username);
            return Messages.SuccessfulFindPersona.getMessage();
        } catch (Exception e) {
            return Messages.translate(e);
        }
    }

    public PortfolioPeople getCarteraPersones() {
        return portfolioPeople;
    }
}
