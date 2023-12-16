package uappp;

public class Anggota {
    private String idAnggota;
    private String nama;

    public Anggota(String idAnggota, String nama) {
        this.idAnggota = idAnggota;
        this.nama = nama;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(String idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}