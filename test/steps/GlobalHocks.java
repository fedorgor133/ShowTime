package steps;

import io.cucumber.java.Before;
import controller.Controller;

public class GlobalHocks {

    private static Controller controlador;

    @Before("@LoadData")
    public void setUpLoadData() {
        controlador = Controller.getInstance();
        controlador.loadData();
    }

    @Before("@ResetData")
    public void setUpResetData() {
        controlador = Controller.getInstance();
        controlador.resetData();
    }
}
