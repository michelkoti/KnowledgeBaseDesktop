/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knowledgebase;

import DBKnowledgeConn.DBConnection;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Michel
 */
public class KnowledgeBase extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        launch(args);

    }
    
    /**
     * @param stage
     */

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ui/formMenu.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Knowledge Base - Admin Tool");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

    }

}
