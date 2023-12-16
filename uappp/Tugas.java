package uappp;

public class Tugas {
    private String idTugas;
    private String deskripsi;
    private String stts;
    private String idAnggota;

    public Tugas(String idTugas, String deskripsi, String stts, String idAnggota) {
        this.idTugas = idTugas;
        this.deskripsi = deskripsi;
        this.stts = stts;
        this.idAnggota = idAnggota;
    }

    public String getIdTugas() {
        return idTugas;
    }

    public void setIdTugas(String idTugas) {
        this.idTugas = idTugas;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getStts() {
        return stts;
    }

    public void setStts(String stts) {
        this.stts = stts;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(String idAnggota) {
        this.idAnggota = idAnggota;
    }
    
}
