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

public class ProyekController implements Initializable {

    @FXML
    private Button btnJadwal;

    @FXML
    private Button btnProfil;

    @FXML
    private Button btnTim;

    @FXML
    private Button btnTugas;
    
    @FXML
    private Button btnTambah;
    
    @FXML
    private TableColumn<Proyek, String> colanggaran;

    @FXML
    private TableColumn<Proyek, String> colid;

    @FXML
    private TableColumn<Proyek, String> colnama;

    @FXML
    private TableColumn<Proyek, String> coltenggat;

    @FXML
    private TableView<Proyek> dataProyek;

    
    @FXML
    void btnTambah(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tambahProyek.fxml"));
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
    
    public ObservableList<Proyek> getData(){
        ObservableList<Proyek> pr = FXCollections.observableArrayList();
        Connection conn = dbHelper.getConnection();
        String query = "select * from proyek";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Proyek temp;
            while(rs.next()){
                temp = new Proyek(rs.getString("idProyek"),rs.getString("namaProyek"),rs.getString("tenggat"), rs.getString("anggaran"));
                pr.add(temp);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return pr;
    }
    
    public void showProyek(){
        ObservableList<Proyek> list = getData();
        colid.setCellValueFactory(new PropertyValueFactory<>("idProyek"));
        colnama.setCellValueFactory(new PropertyValueFactory<>("namaProyek"));
        coltenggat.setCellValueFactory(new PropertyValueFactory<>("tenggat"));
        colanggaran.setCellValueFactory(new PropertyValueFactory<>("anggaran"));
        dataProyek.setItems(list);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showProyek();
    }

}
