/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author iwyny
 */
public class Supplier extends Human{
    private String Instansi;

    public Supplier(String Instansi, String id, String nama, String alamat, String noTelp) {
        super(id, nama, alamat, noTelp);
        this.Instansi = Instansi;
    }

    public Supplier(String Instansi, String nama, String alamat, String noTelp) {
        super(nama, alamat, noTelp);
        this.Instansi = Instansi;
    }

    public String getInstansi() {
        return Instansi;
    }

    public void setInstansi(String Instansi) {
        this.Instansi = Instansi;
    }
    
    @Override
    public String toString() {
        return getNama();
    }
    
}
