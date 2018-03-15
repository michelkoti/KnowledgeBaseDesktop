/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knowledgebase;

import DBKnowledgeConn.DBAccess;
import DBKnowledgeConn.DBAction;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Michel
 */
public class FormInsertController implements Initializable {

    @FXML
    private AnchorPane formInsert;
    @FXML
    private TextField txtShortDesc;
    @FXML
    private ComboBox<?> cbbSelectType;
    @FXML
    private TextArea txtDetDesc;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addButtonClicked(ActionEvent event) {

        DBAccess dba = new DBAccess();
        dba.dataManagement(0, txtShortDesc.getText(), txtDetDesc.getText(), txtShortDesc.getText(), DBAction.INSERT);

//        KnowledgeBaseController cont = new KnowledgeBaseController();
//        cont.dataPopulate();
    }

}
