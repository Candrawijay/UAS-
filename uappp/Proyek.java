package uappp;

public class Proyek {
    private String idProyek;
    private String namaProyek;
    private String tenggat;
    private String anggaran;

    public Proyek(String idProyek, String namaProyek, String tenggat, String anggaran) {
        this.idProyek = idProyek;
        this.namaProyek = namaProyek;
        this.tenggat = tenggat;
        this.anggaran = anggaran;
    }

    public String getIdProyek() {
        return idProyek;
    }

    public void setIdProyek(String idProyek) {
        this.idProyek = idProyek;
    }

    public String getNamaProyek() {
        return namaProyek;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public String getTenggat() {
        return tenggat;
    }

    public void setTenggat(String tenggat) {
        this.tenggat = tenggat;
    }

    public String getAnggaran() {
        return anggaran;
    }

    public void setAnggaran(String anggaran) {
        this.anggaran = anggaran;
    }
    
}
