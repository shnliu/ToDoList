package gui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import model.*;
import javafx.scene.control.*;
import javafx.collections.*;

public class ListPageController {

    private ListManager lm;

    @FXML
    private ListView<String> currentlv;
    @FXML
    private ListView<String> completelv;


    @FXML
    private Button addbutton;
    @FXML
    private TextField textfield;
    @FXML
    private Label display;

    private Scene scene1;
    private Main main;

    public ListPageController(){
        lm = new ListManager();
    }

    public void setMain(Main main){this.main = main;}
    public void setScene1(Scene scene1){this.scene1 = scene1;}

    // this method is called by clicking the button
    @FXML
    public void goBack(){main.setScene(scene1);}

    // adds an item to current list view
    @FXML
    private void handleAddButtonAction() {
        String text = textfield.getText();
        // display.setText(text);

        lm.getCurrentList().getLOI().add(new Item(text));
        ObservableList<String> olist =FXCollections.observableArrayList();
        for (Item i: lm.getCurrentList().getLOI()){
            olist.add(i.getName());
        }
        currentlv.setItems(olist);
    }

    // deletes an item from current list view via select
    @FXML
    private void handleDeleteButtonAction() {
        String text = textfield.getText();
        // display.setText(text);

        lm.getCurrentList().getLOI().remove(text);
//        ObservableList<String> olist =FXCollections.observableArrayList();
//        for (Item i: lm.getCurrentList().getLOI()){
//            olist.add(i.getName());
//        }
//        currentlv.setItems(olist);
    }

    // marks an item as complete (by adding it to complete list view) via select
    @FXML
    private void handleCheckButtonAction() {
        String selected = currentlv.getSelectionModel().getSelectedItem();

        lm.getCompletedList().getLOI().add(new Item(selected));
        ObservableList<String> olist =FXCollections.observableArrayList();
        for (Item i: lm.getCompletedList().getLOI()){
            olist.add(i.getName());
        }
        completelv.setItems(olist);
    }

}