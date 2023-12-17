package uappp;

import db.dbHelper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class EditTugasController{  
    
    @FXML
    private Button btnEdit;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfstts;
    
    @FXML
    private Button btnBack;
    
    @FXML
    void btnBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tugas.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    private void update(String query){
        Connection conn = dbHelper.getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    @FXML
    void btnEdit(ActionEvent event) throws IOException{
        String id = tfID.getText();
        String stts = tfstts.getText();
        if(id.equals("")||stts.equals("")){
            JOptionPane.showMessageDialog(null,"Data Kosong");
        }else{
            JOptionPane.showMessageDialog(null,"Status Diubah");
            TugasController tgs = new TugasController();
            String query = "update tugas set stts = '" + stts + "' where idTugas = '" + id + "'";
            update(query);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("tugas.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage)btnEdit.getScene().getWindow();
            stage.setScene(new Scene(root));
            tgs.showTugas();
        }
    }
}
