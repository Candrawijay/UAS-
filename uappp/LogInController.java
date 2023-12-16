package uappp;

import db.dbHelper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LogInController {
    
    @FXML
    private Button btnBack;

    @FXML
    private Button btnLogIn;

    @FXML
    private PasswordField tfPass;

    @FXML
    private TextField tfUserid;
    
     @FXML
    void btnBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    @FXML
    void btnLogIn(ActionEvent event)throws Exception{
        Connection conn = dbHelper.getConnection();
        PreparedStatement pstp = null;
        
        String sqlp="SELECT * from signup WHERE userId = ? and pass = ? ";
        try{
            pstp = conn.prepareStatement(sqlp);
            pstp.setString(1, tfUserid.getText());
            pstp.setString(2, tfPass.getText());
            ResultSet rsp = pstp.executeQuery();            
            if(rsp.next()){
                JOptionPane.showMessageDialog(null,"LogIn Berhasil");
                Parent root = FXMLLoader.load(getClass().getResource("jadwal.fxml"));
                Scene scene = new Scene(root);  
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();  
            }else{
              JOptionPane.showMessageDialog(null,"Username atau Password Salah");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

}
