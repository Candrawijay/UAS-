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

public class TugasController implements Initializable{

    @FXML
    private Button btnJadwal;

    @FXML
    private Button btnProyek;

    @FXML
    private Button btnTim;
    
    @FXML
    private Button btnTambah;
    
    @FXML
    private Button btnEdit;
    
     @FXML
    private TableColumn<Tugas, String> colTugas;

    @FXML
    private TableColumn<Tugas, String> colid;

    @FXML
    private TableColumn<Tugas, String> colpj;

    @FXML
    private TableColumn<Tugas, String> colstts;

    @FXML
    private TableView<Tugas> dataTugas;
    
    @FXML
    void btnEdit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editTugas.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)btnEdit.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    @FXML
    void btnTambah(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tambahTugas.fxml"));
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
    void btnTim(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tim.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)btnTim.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    public ObservableList<Tugas> getData(){
        ObservableList<Tugas> tg = FXCollections.observableArrayList();
        Connection conn = dbHelper.getConnection();
        String query = "select * from tugas";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Tugas temp;
            while(rs.next()){
                temp = new Tugas(rs.getString("idTugas"),rs.getString("deskripsi"),rs.getString("stts"), rs.getString("idAnggota"));
                tg.add(temp);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return tg;
    }
    
    public void showTugas(){
        ObservableList<Tugas> list = getData();
        colid.setCellValueFactory(new PropertyValueFactory<>("idTugas"));
        colTugas.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        colstts.setCellValueFactory(new PropertyValueFactory<>("stts"));
        colpj.setCellValueFactory(new PropertyValueFactory<>("idAnggota"));
        dataTugas.setItems(list);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showTugas();
    }
}
