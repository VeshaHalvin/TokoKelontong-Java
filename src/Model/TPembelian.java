/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author iwyny
 */
public class TPembelian extends Transaksi{
    private String pembelian;
    private Supplier sup;

    public TPembelian(String pembelian, Supplier sup, String Tgl_Trans, double TtlHarga) {
        super(Tgl_Trans, TtlHarga);
        this.pembelian = pembelian;
        this.sup = sup;
    }
    
    public TPembelian( Supplier sup, String Tgl_Trans, double TtlHarga) {
        super(Tgl_Trans, TtlHarga);
        this.sup = sup;
    }
    public String getPembelian() {
        return pembelian;
    }

    public void setPembelian(String pembelian) {
        this.pembelian = pembelian;
    }

    public Supplier getSup() {
        return sup;
    }

    public void setSup(Supplier sup) {
        this.sup = sup;
    }
    
}
