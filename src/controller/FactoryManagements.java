package controller;

import model.*;
import resources.service.AbstractFactoryData;
import resources.service.DataService;
import resources.service.FactoryMOCK;

import java.util.Map;
public class FactoryManagements {

    private DataService dataService;
    private AbstractFactoryData factory;

    public FactoryManagements() {
        this.factory = new FactoryMOCK();
        this.dataService = new DataService(factory);
    }

    public ManagementData createDataManagement(PortfolioPeople portfolioPeople) {
        return new ManagementData(dataService, portfolioPeople);
    }

    public ManagementContent createContentManagement(Map<String, Movie> moviesList, Map<String, Series> seriesList, Map<String, Theme> themesList, Map<String, InterestGroup> interestGroupList, Map<String, Question> questionsList) {
        return new ManagementContent(dataService, moviesList, seriesList, themesList, interestGroupList, questionsList);
    }

    public ManagementLists createListManagement(PortfolioPeople portfolioPeople, Map<String, Movie> moviesList, Map<String, Series> seriesList, Map<String, InterestGroup> interestGroupList) {
        return new ManagementLists(portfolioPeople, moviesList, seriesList, interestGroupList);
    }
}
