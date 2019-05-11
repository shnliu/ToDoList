package gui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import model.*;
import javafx.scene.control.*;
import javafx.collections.*;

public class Scene2Controller {

    private ListManager lm;

    @FXML
    private ListView<String> currentlv;
    @FXML
    private ListView<String> completelv;
    @FXML
    private TextField textfield;
    @FXML
    private Label display;

    private Scene scene1;
    private Main main;

    public Scene2Controller(){
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

        ToDoList tdList =  lm.getCurrentList();
        addToLV(text, tdList, currentlv);
    }

    private void addToLV(String text, ToDoList tdList, ListView<String> lv) {
        tdList.addItem(new Item(text));
        ObservableList<String> olist = FXCollections.observableArrayList();
        for (Item i: tdList.getLOI()){
            olist.add(i.getName());
        }
        lv.setItems(olist);
    }

    // deletes an item from any list view via select
    @FXML
    private void handleDeleteButtonAction() {
        try {
            String selectedCurr = currentlv.getSelectionModel().getSelectedItem();
            String selectedComp = completelv.getSelectionModel().getSelectedItem();

            // delete from currentlv
            removeFromLV(selectedCurr, lm.getCurrentList(), currentlv);

            // delete from completed lv
            removeFromLV(selectedComp, lm.getCompletedList(), completelv);
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Item unable to be deleted. Please delete another item instead.");
            alert.showAndWait();
        }
    }

    // marks an item as complete (by adding it to complete list view) via select
    @FXML
    private void handleCheckButtonAction() {

        try {
            String selected = currentlv.getSelectionModel().getSelectedItem();

            // removes item from current list
            removeFromLV(selected, lm.getCurrentList(), currentlv);

            // adds item to completed list
            addToLV(selected, lm.getCompletedList(), completelv);
//
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("No Current Item selected. Please add a new Current Item and " +
                    "deselect all Completed Items before trying again.");
            alert.showAndWait();
        }
    }

    private void removeFromLV(String selected, ToDoList tdList, ListView<String> lv) {
        tdList.removeItem(new Item(selected));
        ObservableList<String> olist = FXCollections.observableArrayList();
        for (Item i : tdList.getLOI()) {
            olist.add(i.getName());
        }
        lv.setItems(olist);
    }

    // issue: can't mark something complete as complete again!!
    // be able to edit an item
    // items are effectively just strings rn
    // be able to sort by priority
    // be able to see stats
    // clear, new day, see all functions
    // dates? as a field of item
    // check marks when marking complete?


}
