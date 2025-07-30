/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author iwyny
 */
public class TPenjualan extends Transaksi{
    private String penjualan;
    private Pelanggan pel;

    public TPenjualan(String penjualan, Pelanggan pel, String Tgl_Trans, double TtlHarga) {
        super(Tgl_Trans, TtlHarga);
        this.penjualan = penjualan;
        this.pel = pel;
    }
    
    public TPenjualan( Pelanggan pel, String Tgl_Trans, double TtlHarga) {
        super(Tgl_Trans, TtlHarga);
        this.pel = pel;
    }
    
    public String getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(String penjualan) {
        this.penjualan = penjualan;
    }

    public Pelanggan getPel() {
        return pel;
    }

    public void setPel(Pelanggan pel) {
        this.pel = pel;
    }
    
    
}
