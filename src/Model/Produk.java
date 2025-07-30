/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author iwyny
 */
public class Produk {
    private String Kode;
    private String nama;
    private String jenis;
    private int jumlah;
    private double harga_satuan;

    public Produk(String Kode, String nama, String jenis, int jumlah, double harga_satuan) {
        this.Kode = Kode;
        this.nama = nama;
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.harga_satuan = harga_satuan;
    }

    public Produk(String nama, String jenis, int jumlah, double harga_satuan) {
        this.nama = nama;
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.harga_satuan = harga_satuan;
    }

    public String getKode() {
        return Kode;
    }

    public void setKode(String Kode) {
        this.Kode = Kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga_satuan() {
        return harga_satuan;
    }

    public void setHarga_satuan(double harga_satuan) {
        this.harga_satuan = harga_satuan;
    }
    
    @Override
    public String toString() {
        return getNama();
    }
}
