package id.co.technicaltest.datakendaraan.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity //-define-a-class-as:an-entity
@Table(name = "list_kendaraan")//-connect-a:class to: table in-database
public class DataEntity{

    //-main

    @Id//-define-an-attribute-as PRIMARY KEY in-database
    @GeneratedValue(strategy = GenerationType.IDENTITY) // specify a generated: value

    @Column (name = "id") //-connect-an-attribute-to-id:column:in-database
    private Integer id;

    @Column (name = "nomor_registrasi_kendaraan") //-connect-an-attribute-to-id:column:in-database
    private String nomorRegistrasiKendaraan;

    @Column (name= "nama_pemilik")
    private String namaPemilik;

    @Column (name = "alamat")
    private String alamat;

    @Column (name = "merk_kendaraan")
    private String merkKendaraan;

    @Column (name = "tahun_pembuatan")
    private Integer tahunPembuatan;

    @Column(name = "kapasitas_silinder")
    private Integer kapasitasSilinder;

    @Column(name = "warna_kendaraan")
    private String warnaKendaraan;

    @Column (name ="bahan_bakar")
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