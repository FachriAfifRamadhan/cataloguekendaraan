package id.co.technicaltest.datakendaraan.models;
import org.springframework.stereotype.Component;;

@Component
public class DataModel {
    //main
    private Integer id;
    private String nomorRegistrasiKendaraan;
    private String namaPemilik;
    private String alamat;
    private String merkKendaraan;
    private Integer tahunPembuatan;
    private Integer kapasitasSilinder;
    private String warnaKendaraan;
    private String bahanBakar;



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomorRegistrasiKendaraan() {
        return nomorRegistrasiKendaraan;
    }
    public void setNomorRegistrasiKendaraan(String nomorRegistrasiKendaraan) {
        this.nomorRegistrasiKendaraan = nomorRegistrasiKendaraan;
    }
    public String getNamaPemilik() {
        return namaPemilik;
    }
    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getMerkKendaraan() {
        return merkKendaraan;
    }
    public void setMerkKendaraan(String merkKendaraan) {
        this.merkKendaraan = merkKendaraan;
    }
    public Integer getTahunPembuatan() {
        return tahunPembuatan;
    }
    public void setTahunPembuatan(Integer tahunPembuatan) {
        this.tahunPembuatan = tahunPembuatan;
    }
    public Integer getKapasitasSilinder() {
        return kapasitasSilinder;
    }
    public void setKapasitasSilinder(Integer kapasitasSilinder) {
        this.kapasitasSilinder = kapasitasSilinder;
    }
    public String getWarnaKendaraan() {
        return warnaKendaraan;
    }
    public void setWarnaKendaraan(String warnaKendaraan) {
        this.warnaKendaraan = warnaKendaraan;
    }
    public String getBahanBakar() {
        return bahanBakar;
    }
    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }
    
}
