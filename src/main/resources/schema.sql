DROP TABLE IF EXISTS list_kendaraan;

CREATE TABLE list_kendaraan(
    nomor_registrasi_kendaraan VARCHAR(50) PRIMARY KEY NOT NULL,
    nama_pemilik VARCHAR(50) NOT NULL,
    alamat VARCHAR(50) NULL,
    merk_kendaraan VARCHAR(50) NULL,
    tahun_pembuatan INT4 NULL,
    kapasitas_silinder INT4 NULL,
    warna_kendaraan VARCHAR(50) NULL,
    bahan_bakar VARCHAR(50) NULL
)
WITH(
    OIDS=FALSE
)

SELECT * FROM list_kendaraan