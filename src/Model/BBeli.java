/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author iwyny
 */
public class BBeli extends Barang{
    private String pembelian;

    public BBeli(String pembelian, Produk produk, int jumlah) {
        super(produk, jumlah);
        this.pembelian = pembelian;
    }

    public String getPembelian() {
        return pembelian;
    }

    public void setPembelian(String pembelian) {
        this.pembelian = pembelian;
    }
    
    @Override
    public String getSpecialId() {
        return pembelian;
    }
}
