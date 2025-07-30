/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author iwyny
 */
public class Pelanggan extends Human{
    private String Sex;
    private boolean member;

    public Pelanggan(String Sex, boolean member, String id, String nama, String alamat, String noTelp) {
        super(id, nama, alamat, noTelp);
        this.Sex = Sex;
        this.member = member;
    }

    public Pelanggan(String Sex, boolean member, String nama, String alamat, String noTelp) {
        super(nama, alamat, noTelp);
        this.Sex = Sex;
        this.member = member;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }
    
    @Override
    public String toString() {
        return getNama();
    }

}
