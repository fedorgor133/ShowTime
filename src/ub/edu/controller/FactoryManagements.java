package ub.edu.controller;

import ub.edu.model.*;
import ub.edu.resources.service.AbstractFactoryData;
import ub.edu.resources.service.DataService;
import ub.edu.resources.service.FactoryMOCK;

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

    public ManagementContent createContentManagement(Map<String, Movie> moviesList, Map<String, Series> seriesList, Map<String, Theme> themesList, Map<String, GrupInterest> interestGroupList, Map<String, Question> questionsList) {
        return new ManagementContent(dataService, moviesList, seriesList, themesList, interestGroupList, questionsList);
    }

    public ManagementLists createListManagement(PortfolioPeople portfolioPeople, Map<String, Movie> moviesList, Map<String, Series> seriesList, Map<String, GrupInterest> interestGroupList) {
        return new ManagementLists(portfolioPeople, moviesList, seriesList, interestGroupList);
    }
}
