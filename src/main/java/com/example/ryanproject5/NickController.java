package com.example.ryanproject5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.net.URL;
import java.util.ResourceBundle;

public class NickController {
    public class StarWarsDisplayController implements Initializable {
        @FXML
        private TextField NameField;
        @FXML
        private TextField height;
        @FXML
        private TextField year;
        @FXML
        private TextField planet;
        @FXML
        private TextField movie;
        @FXML
        private ListView<DataHandlerN.StarWarsAPI> ListControl;
        private DataHandlerN Model;

        public void loadData(){
            var site = "https://swapi.dev/api/";
            String param = getQueryParam();
            var wholeSite = site+param;
            Model = new DataHandlerN(wholeSite);
            var universities = Model.getData();
            ObservableList<DataHandlerN.StarWarsAPI> UnivList =
                    FXCollections.observableArrayList(DataHandlerN.StarWarsAPI);
            ListControl.setItems(CharList);
        }

        private String getQueryParam() {
            var inputDialog = new TextInputDialog("Anakin");
            inputDialog.setContentText("What Character should we Search For");
            inputDialog.setHeaderText("Gathering Information");
            var response = inputDialog.showAndWait();
            if(response.isEmpty()){
                return "";
            }
            else {
                return response.get();
            }
        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            loadData();
            ListControl.getSelectionModel().selectedItemProperty().addListener(
                    new ChangeListener<DataHandlerN.StarWarsAPI>() {
                        @Override
                        public void changed(ObservableValue<? extends DataHandlerN.StarWarsAPI> observableValue, DataHandlerN.StarWarsAPI universityDataType, DataHandlerN.WebDataType t1) {
                            NameField.setText(t1.name);
                            UniversityCountryField.setText(t1.country);
                            websiteDisplayField.setText(t1.web_pages.toString());
                        }
                    }
        }
    }
}
