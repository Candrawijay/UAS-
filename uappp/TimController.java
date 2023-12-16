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

public class TimController implements Initializable{
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showAnggota();
    }

    @FXML
    private Button btnJadwal;

    @FXML
    private Button btnProyek;

    @FXML
    private Button btnProfil;

    @FXML
    private Button btnTugas;
            
    @FXML
    private Button btnTambah;
    
    @FXML
    private TableColumn<Anggota, String> colNama;

    @FXML
    private TableColumn<Anggota, String> colid;

    @FXML
    private TableView<Anggota> dataAnggota;
    
    @FXML
    void btnTambah(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tambahAnggota.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void btnJadwal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("jadwal.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)btnJadwal.getScene().getWindow();
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
    void btnTugas(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tugas.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)btnTugas.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    public ObservableList<Anggota> getData(){
        ObservableList<Anggota> agt = FXCollections.observableArrayList();
        Connection conn = dbHelper.getConnection();
        String query = "select * from anggota";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Anggota temp;
            while(rs.next()){
                temp = new Anggota(rs.getString("idAnggota"),rs.getString("nama"));
                agt.add(temp);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return agt;
    }
    
    public void showAnggota(){
        ObservableList<Anggota> list = getData();
        colid.setCellValueFactory(new PropertyValueFactory<>("idAnggota"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        dataAnggota.setItems(list);
    }

}
