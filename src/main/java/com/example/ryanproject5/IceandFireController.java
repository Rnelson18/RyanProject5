package com.example.harrisonproject5;

import com.sun.javafx.charts.Legend;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

public class IceandFireController {
    @FXML
    private TextField povcharacters;

    @FXML
    private TextField IceandFire;

    @FXML
    private ListView<DataHandlerHZ.IceandFire> Listcontrol;
    private DataHandlerHZ Model;
    private Legend ListControl;
    private String queryParam;

    public void loadData(){
        var site = "https://www.anapioficeandfire.com/api";
        String param = getQueryParam();
        var wholeSite = site+param;
        Model = new DataHandlerHZ(wholeSite);
        var universities = Model.getData();
        ObservableList<DataHandlerHZ.IceandFire> APIList =
                FXCollections.observableArrayList(universities);
        ListControl.setItems(APIList);
    }



}

    


    public String getQueryParam() {
        return queryParam;
    }
}