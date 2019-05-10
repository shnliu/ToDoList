package gui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Window;
import model.*;
import javafx.scene.control.*;
import javafx.collections.*;
import java.awt.event.*;

import javax.xml.soap.Text;

public class ListPageController {

    private ListManager lm;

    @FXML
    private ListView<String> currentlv;

    @FXML
    private Button addbutton;
    @FXML
    private TextField tf;
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

    @FXML
    public void setUpCurrentLV(){
        // ListView<String> list = new ListView<String>();
        ObservableList<String> olist =FXCollections.observableArrayList ();
        for (Item i: lm.getCurrentList().getLOI()){
            olist.add(i.getName());
        }
        currentlv.setItems(olist);
    }

    @FXML
    private void handleAddButtonAction() {
        String text = tf.getText();
        display.setText(text);

        lm.getCurrentList().getLOI().add(new Item(text));
        ObservableList<String> olist =FXCollections.observableArrayList();
        for (Item i: lm.getCurrentList().getLOI()){
            olist.add(i.getName());
        }
        currentlv.setItems(olist);

    }

    @FXML
    public void addButtonFunc(){
//        lm.getCurrentList().getLOI().add(new Item("hi"));
//        addbutton.setOnAction(click -> {
//            String selectedItem = listView.getSelectionModel().getSelectedItem();
//
//        });
    }


}