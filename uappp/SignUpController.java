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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class SignUpController {
    Connection conn = dbHelper.getConnection();

    @FXML
    private Button btnSignUp;

    @FXML
    private TextField tfNama;

    @FXML
    private PasswordField tfPass;

    @FXML
    private TextField tfUserid;

    @FXML
    void btnSignUp(ActionEvent event) throws IOException {
        String nama = tfNama.getText();
        String id = tfUserid.getText();
        String pass = tfPass.getText();
        
        if(nama.equals("")||id.equals("")||pass.equals("")){
            JOptionPane.showMessageDialog(null,"Data Kosong");
        }else{
            insert();
            JOptionPane.showMessageDialog(null,"SignUp Berhasil");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage)btnSignUp.getScene().getWindow();
            stage.setScene(new Scene(root));
        }
    }

    private void insert(){
        String query = "INSERT INTO signup VALUES ('" + tfUserid.getText() + "', '" + tfNama.getText() +"', '"+tfPass.getText()+"')";
        update(query);
        tfUserid.clear();
        tfNama.clear();
        tfPass.clear();
    }
    
    private void update(String query){
        Connection connn = dbHelper.getConnection();
        Statement st;
        try{
            st = connn.createStatement();
            st.executeUpdate(query);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
