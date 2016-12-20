package application;

import java.net.URL;
import java.util.ResourceBundle;

import bean.Fermata;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class SampleController {
	
	private Model model = new Model();
	
	public void setModel(Model model){
		this.model=model;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Fermata> comboPartenza;

    @FXML
    private ComboBox<Fermata> comboArrivo;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCalcola(ActionEvent event) {
    	txtResult.clear();
    	Fermata f1 = comboPartenza.getValue();
    	Fermata f2 = comboArrivo.getValue();
    	if(f1 == null || f2 ==null){
    		txtResult.appendText("Selezionare due fermate \n");
    		return;
    	}
    	if(f1.equals(f2)){
    		txtResult.appendText("Selezionare due fermate diverse \n");
    		return;
    	}
    	

    }

    @FXML
    void initialize() {
        assert comboPartenza != null : "fx:id=\"comboPartenza\" was not injected: check your FXML file 'Sample.fxml'.";
        assert comboArrivo != null : "fx:id=\"comboArrivo\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Sample.fxml'.";

        comboPartenza.getItems().addAll(model.getFer());
        comboArrivo.getItems().addAll(model.getFer());
    }
}
