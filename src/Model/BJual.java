/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author iwyny
 */
public class BJual extends Barang{
    private String penjualan;

    public BJual(String penjualan, Produk produk, int jumlah) {
        super(produk, jumlah);
        this.penjualan = penjualan;
    }

    public String getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(String penjualan) {
        this.penjualan = penjualan;
    }

    @Override
    public String getSpecialId() {
        return penjualan;
    }
    
}
