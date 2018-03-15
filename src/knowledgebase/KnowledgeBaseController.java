/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knowledgebase;

import DBKnowledgeConn.DBAccess;
import DBKnowledgeConn.DBAction;
import DBKnowledgeConn.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Michel
 */
public class KnowledgeBaseController implements Initializable {

    @FXML
    private MenuItem mnuInsert;
    @FXML
    private MenuItem mnuClose;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TableView<ContentInfo> tblView;
    @FXML
    private TableColumn<ContentInfo, String> cellShortDesc;
    @FXML
    private TableColumn<ContentInfo, String> cellDetDesc;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnCancel;

    private ObservableList<ContentInfo> data;
    private DBAccess dba = null;

    @FXML
    private Label label1;
    @FXML
    private Label label2;

    @FXML
    private TextField text1;
    @FXML
    private ComboBox<String> combo1;
    @FXML
    private TextArea text2;

    
    int idCt = 0;
    String sDesc = "";
    String detDesc = "";
    String tCt = "";
 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Show data into TableView;
        dataPopulate();

    }

     /**
     * Loads the fields in the main screen tableview.
     * Loads fields for editing and deletion after mouse-click selection
     */
    public void dataPopulate() {

        data = new DBAccess().dataSelect();

        //Set cell value factory to tableview //NB PropertyValue Factory must be the same with the one set in model class.
        cellShortDesc.setCellValueFactory(new PropertyValueFactory<>("shortDesc"));
        cellDetDesc.setCellValueFactory(new PropertyValueFactory<>("detDesc"));

        tblView.setItems(null);
        tblView.setItems(data);

        clearFields();

        //Show data into 
        tblView.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Integer> c) {
                int selectedIndex = tblView.getSelectionModel().getSelectedIndex();
                if (selectedIndex >= 0) {
                    ContentInfo cti = tblView.getSelectionModel().getSelectedItem();
                    text1.setText(cti.getShortDesc());
                    text2.setText(cti.getDetDesc());
                    label1.setText(cti.getIdCt());
                    label2.setText(cti.getTypeCt());
//                    combo1.setItems(cti.getTypeCt());

                    btnInsert.setDisable(true);
                    btnEdit.setDisable(false);
                    btnDelete.setDisable(false);

                }

            }
        });
    }


     /**
     * Clear fields and prepare for new updates.
     */    
    public void clearFields() {
        text1.setText("");
        text2.setText("");
        label1.setText("");
        label2.setText("");
        btnInsert.setDisable(false);
        btnEdit.setDisable(true);
        btnDelete.setDisable(true);

        try {
            fillComboType();
        } catch (SQLException ex) {
            Logger.getLogger(KnowledgeBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     /**
     * Loads data for 'Select type'combobox.
     */    
    public void fillComboType() throws SQLException {
        ObservableList<String> comboString = FXCollections.observableArrayList();
        //       data = new DBAccess().dataSelect();
        DBConnection sqlc = new DBConnection();
        ResultSet rs = null;

        try {
            //Execute query and store result in a resultset
            Connection conn = sqlc.getMySQLConnection();
            rs = conn.createStatement().executeQuery("SELECT * FROM type_issue");

            while (rs.next()) {
                comboString.add(rs.getString("ti_description"));

            }
            combo1.setItems(comboString);
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Error:" + ex);
        }
    }

    @FXML
    private void insertScreen(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ui/formInsert.fxml"));
            Parent formInsert = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Insert Screen");
            stage.setScene(new Scene(formInsert));
            stage.setAlwaysOnTop(true);
            stage.show();

        } catch (IOException e) {
            System.out.println("Cant load new window");
        }
    }

     /**
     * Call method for data insert.
     */
     /**
     * @param idCt data ID that will be deleted
     * @param sDesc data collected for Short Description field in the main screen
     * @param detDesc data collected for Detailed Description field in the main screen
     * @param DBAction.INSERT action that will be executed in DBAction class 
     */

    @FXML
    private void insertButtonClicked(ActionEvent event) {

        idCt = 0;
        sDesc = text1.getText();
        detDesc = text2.getText();
        tCt = combo1.getSelectionModel().getSelectedItem();

        if ((!"".equals(sDesc)) && (!"".equals(detDesc))) {
            DBAccess dba = new DBAccess();
            dba.dataManagement(0, sDesc, detDesc, tCt, DBAction.INSERT);

            Messages.infoBox(sDesc + " inserted successfully", "Message", "Knowledge Base");
            //Reload Screen
            dataPopulate();
        } else {
            Messages.infoBox(" Fields cannot be empty", "Alert!", "Knowledge Base");
        }
    }
    
     /**
     * Call method for data update.
     */
    /**
     * @param idCt data ID that will be deleted
     * @param sDesc data collected for Short Description field in the main screen
     * @param detDesc data collected for Detailed Description field in the main screen
     * @param DBAction.UPDATE action that will be executed in DBAction class 
     */
    @FXML
    private void editButtonClicked(ActionEvent event) {

        idCt = Integer.parseInt(label1.getText());
        sDesc = text1.getText();
        detDesc = text2.getText();
        tCt = combo1.getSelectionModel().getSelectedItem();

        DBAccess dba = new DBAccess();
        dba.dataManagement(idCt, sDesc, detDesc, tCt, DBAction.UPDATE);

        Messages.infoBox(sDesc + " updated successfully", "Message", "Knowledge Base");
        //Reload Screen
        dataPopulate();
    }

     /**
     * Call method for data delete.
     */
    /**
     * @param idCt data ID that will be deleted
     * @param DBAction.DELETE action that will be executed in DBAction class
     */

    @FXML
    private void deleteButtonClicked(ActionEvent event) {

        idCt = Integer.parseInt(label1.getText());
        sDesc = "";
        detDesc = "";
        tCt = combo1.getSelectionModel().getSelectedItem();

        DBAccess dba = new DBAccess();
        dba.dataManagement(idCt, sDesc, detDesc, tCt, DBAction.DELETE);
        //Show user message that the content was changed
        Messages.infoBox(sDesc + " deleted successfully", "Message", "Knowledge Base");
        //Reload Screen
        dataPopulate();

    }

     /**
     * Cancel button.
     */

    @FXML
    private void cancelButtonClicked(ActionEvent event) {

        //Reload Screen
        dataPopulate();

    }

    @FXML
    private void closeApp(ActionEvent event) {

        Platform.exit();
        System.exit(0);

    }

}
