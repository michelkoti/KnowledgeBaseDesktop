/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBKnowledgeConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import knowledgebase.ContentInfo;

/**
 *
 * @author Michel
 */
public class DBAccess {

    public ObservableList<ContentInfo> dataSelect() {

        ObservableList<ContentInfo> data;
        ResultSet rs = null;
        DBConnection sqlc = new DBConnection();

        data = FXCollections.observableArrayList();
        try {
            Connection conn = sqlc.getMySQLConnection();

            //Execute query and store result in a resultset
            rs = conn.createStatement().executeQuery("SELECT * FROM content");
            while (rs.next()) {
                data.add(new ContentInfo(rs.getString("id_ct"), rs.getString("link_ct"), rs.getString("content_ct"),rs.getString("typeSt_ct") ));

                
            }
        } catch (SQLException ex) {
            System.err.println("Error:" + ex);
        }

        return data;

    }

    public void dataManagement(int id, String sDesc, String dDesc, String tCt, DBAction action) {

        DBConnection sqlc = new DBConnection();

        try {
            Connection conn = sqlc.getMySQLConnection();
            Statement myStmt = conn.createStatement();

            if (null != action) switch (action) {
                case INSERT:{
                    //Add register
                    String query = " INSERT INTO content"
                            + " (link_ct, content_ct, typeSt_ct, id_fk) "
                            + " VALUES ('" + sDesc + "', '" + dDesc + "', '"+tCt+"', 0)";
                    System.out.println("******" + query + " ******");
                    myStmt.executeUpdate(query);
                    System.out.println("data added successfully...");
                        break;
                    }
                case UPDATE:{
                    //Update register
                    String query = " UPDATE content SET"
                            + " link_ct = '" + sDesc + "', "
                            + " content_ct = '" + dDesc + "', "
                            + " typeSt_ct = '" + tCt + "', "
                            + " id_fk = 1 "
                            + " WHERE id_ct = " + id;
                    System.out.println("******" + query + " ******");
                    myStmt.executeUpdate(query);
                    System.out.println("data updated successfully...");
                        break;
                    }
                case DELETE:{
                    String query = " DELETE FROM content"
                            + " WHERE id_ct = " + id;
                    System.out.println("******" + query + " ******");
                    myStmt.executeUpdate(query);
                    //default title and icon
   //                 JOptionPane.showMessageDialog(frame,
   //                 "data deleted successfully...");
                    System.out.println("data deleted successfully...");
                        break;
                    }
                default:
                    break;
            }
       
        } catch (SQLException ex) {
            System.err.println("Error:" + ex);
        }

    }

}
