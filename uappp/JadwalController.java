package uappp;

import db.dbHelper;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class JadwalController implements Initializable{

    @FXML
    private Button btnProfil;

    @FXML
    private Button btnProyek;

    @FXML
    private Button btnTim;

    @FXML
    private Button btnTugas;
    
    @FXML
    private Button btnTambah;
    
    @FXML
    private Button btnEdit;

    @FXML
    private TableColumn<Jadwal, String> colID;

    @FXML
    private TableColumn<Jadwal, String> coljdwl;

    @FXML
    private TableColumn<Jadwal, String> coltgs;

    @FXML
    private TableView<Jadwal> dataJadwal;
    
    @FXML
    void btnEdit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editJadwal.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)btnEdit.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    public ObservableList<Jadwal> getData(){
        ObservableList<Jadwal> jd = FXCollections.observableArrayList();
        Connection conn = dbHelper.getConnection();
        String query = "select * from jadwal";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Jadwal temp;
            while(rs.next()){
                temp = new Jadwal(rs.getString("idJadwal"),rs.getString("jdwl"),rs.getString("idTugas"));
                jd.add(temp);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return jd;
    }
    
    public void showJadwal(){
        ObservableList<Jadwal> list = getData();
        colID.setCellValueFactory(new PropertyValueFactory<>("idJadwal"));
        coljdwl.setCellValueFactory(new PropertyValueFactory<>("jdwl"));
        coltgs.setCellValueFactory(new PropertyValueFactory<>("idTugas"));
        dataJadwal.setItems(list);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showJadwal();
    }
    
    @FXML
    void btnTambah(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tambahJadwal.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void btnProyek(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("proyek.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)btnProyek.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void btnTim(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tim.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)btnTim.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void btnTugas(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tugas.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)btnTugas.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
