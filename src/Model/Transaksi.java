/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author iwyny
 */
public abstract class Transaksi {
    protected String Tgl_Trans;
    protected double TtlHarga;
    protected ArrayList<Barang> barang= new ArrayList<>();

    public Transaksi(String Tgl_Trans, double TtlHarga) {
        this.Tgl_Trans = Tgl_Trans;
        this.TtlHarga = TtlHarga;
    }
    
    public void addBarang(Barang b){
        barang.add(b);
    }

    public String getTgl_Trans() {
        return Tgl_Trans;
    }

    public void setTgl_Trans(String Tgl_Trans) {
        this.Tgl_Trans = Tgl_Trans;
    }

    public double getTtlHarga() {
        return TtlHarga;
    }

    public void setTtlHarga(double TtlHarga) {
        this.TtlHarga = TtlHarga;
    }

    public ArrayList<Barang> getBarang() {
        return barang;
    }
    
}
