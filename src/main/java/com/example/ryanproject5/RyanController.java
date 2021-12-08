package com.example.ryanproject5;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.scene.control.TextInputDialog;
import java.net.URL;
import java.util.ResourceBundle;

public class RyanController implements Initializable {
    @FXML
    private TextField Category;
    @FXML
    private TextField Id;
    @FXML
    private TextField Value;
    @FXML
    private TextField url;

    private ListView<DateHandlerRyan.ChuckNorrisJoke> ListControl;
    private DateHandlerRyan Model;
    @FXML
    public void loadData(ActionEvent jokes) {
        var site = "https://api.chucknorris.io/jokes/random";
        var ButtonPressed =(Button) jokes.getSource();
        var param = ButtonPressed.getText();
        var wholeSite = site + param;
        Model = new DateHandlerRyan(wholeSite);
        var joke = Model.getData ();
        ObservableList<DateHandlerRyan.ChuckNorrisJoke> JokeList =
                FXCollections.observableArrayList((DateHandlerRyan.ChuckNorrisJoke) joke);
        ListControl.setItems(JokeList);

    }

    private String getQueryParam() {
        var inputDialog = new TextInputDialog("Joke");
        inputDialog.setContentText("What Category Of Jokes Do You Want?");
        inputDialog.setHeaderText("Gathering Information");
        var response = inputDialog.showAndWait();
        if (response.isEmpty()) {
            return "";
        } else {
            return response.get();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
