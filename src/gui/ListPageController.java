package gui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import model.*;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.application.*;

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

        lm.getCurrentList().addItem(new Item(text));
        ObservableList<String> olist =FXCollections.observableArrayList();
        for (Item i: lm.getCurrentList().getLOI()){
            olist.add(i.getName());
        }
        currentlv.setItems(olist);
    }

    // deletes an item from any list view via select
    @FXML
    private void handleDeleteButtonAction() {
        String selectedCurr = currentlv.getSelectionModel().getSelectedItem();
        String selectedComp = completelv.getSelectionModel().getSelectedItem();

        // delete from currentlv
        lm.getCurrentList().removeItem(new Item(selectedCurr));
        ObservableList<String> olist =FXCollections.observableArrayList();
        for (Item i: lm.getCurrentList().getLOI()){
            olist.add(i.getName());
        }
        currentlv.setItems(olist);

        // delete from completed lv
        lm.getCompletedList().removeItem(new Item(selectedComp));
        ObservableList<String> clist =FXCollections.observableArrayList();
        for (Item i: lm.getCompletedList().getLOI()){
            clist.add(i.getName());
        }
        completelv.setItems(clist);
    }

    // marks an item as complete (by adding it to complete list view) via select
    @FXML
    private void handleCheckButtonAction() {

        try {
            String selected = currentlv.getSelectionModel().getSelectedItem();

            // removes item from current list
            lm.getCurrentList().removeItem(new Item(selected));
            ObservableList<String> olist = FXCollections.observableArrayList();
            for (Item i : lm.getCurrentList().getLOI()) {
                olist.add(i.getName());
            }
            currentlv.setItems(olist);

            // adds item to completed list
            lm.getCompletedList().addItem(new Item(selected));
            ObservableList<String> clist = FXCollections.observableArrayList();
            for (Item i : lm.getCompletedList().getLOI()) {
                if (i!=null){
                    clist.add(i.getName());
                }
            }
            completelv.setItems(clist);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("No Current Item selected. Please add a new Current Item and " +
                    "deselect all Completed Items before trying again.");
            alert.showAndWait();
        }
    }


}