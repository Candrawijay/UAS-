/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uappp;

/**
 *
 * @author Lenovo Yoga
 */
public class Jadwal {
    private String idJadwal;
    private String jdwl;
    private String idTugas;

    public Jadwal(String idJadwal, String jdwl, String idTugas) {
        this.idJadwal = idJadwal;
        this.jdwl = jdwl;
        this.idTugas = idTugas;
    }

    public String getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(String idJadwal) {
        this.idJadwal = idJadwal;
    }

    public String getJdwl() {
        return jdwl;
    }

    public void setJdwl(String jdwl) {
        this.jdwl = jdwl;
    }

    public String getIdTugas() {
        return idTugas;
    }

    public void setIdTugas(String idTugas) {
        this.idTugas = idTugas;
    }
    
}
