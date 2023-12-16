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

public class TambahProyekController {

    @FXML
    private Button btnBack;
    
     @FXML
    private Button btnTambah;
    
    @FXML
    private TextField tfAnggaran;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfTenggat;

    @FXML
    void btnBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("proyek.fxml"));
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
    void btnTambah(ActionEvent event) throws IOException {
        String id = tfID.getText();
        String nm = tfNama.getText();
        String tg = tfTenggat.getText();
        String ag = tfAnggaran.getText();
        if(id.equals("")||nm.equals("")||tg.equals("")||ag.equals("")){
            JOptionPane.showMessageDialog(null,"Data Kosong");
        }else{
            JOptionPane.showMessageDialog(null,"Data Berhasil Ditambahkan");
            ProyekController pr = new ProyekController();
            String query = "INSERT INTO proyek VALUES ('" + id + "', '" + nm + "', '" + tg + "', '" + ag + "')";
            update(query);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("proyek.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage)btnTambah.getScene().getWindow();
            stage.setScene(new Scene(root));
            pr.showProyek();
        }
    }
}
