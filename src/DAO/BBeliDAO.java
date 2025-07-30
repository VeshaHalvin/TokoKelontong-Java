/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import InterfaceDAO.*;
import Model.BBeli;
import Model.Produk;
import Model.TPembelian;
import Connection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author iwyny
 */
public class BBeliDAO implements IDAO<BBeli, String, String>,ISearchDAO<BBeli, String, String>{
    protected DBConnection dbCon = new DBConnection();
    protected Connection con;
    @Override
    public void insert(BBeli data) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO `barang_beli`(`Kode_produk`,`jumlah`,`Id_pembelian`) VALUES('"+data.getProduk().getKode()+"','"+data.getJumlah()+"','"+data.getPembelian()+"'); ";
        System.out.println("Adding barang_beli...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " barang_beli");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding barang_beli...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    public void InputBeliBaru(BBeli data){
        con = dbCon.makeConnection();
        String sql = "UPDATE `Produk` SET `jumlah`='"+data.getProduk().getJumlah()+"'+'"+data.getJumlah()+"' WHERE Kode_Produk ='"+data.getProduk().getKode()+"'";
        System.out.println("Adding barang_beli...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " barang_beli");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding barang_beli...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    @Override
    public List<BBeli> showData(String data) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM barang_beli P JOIN Produk S ON P.Kode_produk  = S.Kode_produk JOIN transaksi_pembelian E On P.Id_pembelian=E.Id_pembelian WHERE P.Id_pembelian LIKE '%"+data+"'";
        System.out.println("Fetching Data...");
        List<BBeli> c = new ArrayList();
        Produk s=null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    s=new Produk(rs.getString("S.Kode_produk"), rs.getString("S.nama"), rs.getString("S.jenis"), rs.getInt("S.jumlah"), rs.getFloat("S.Harga_satuan"));
                    c.add(new BBeli(rs.getString("P.Id_pembelian"), s,  rs.getInt("P.jumlah")));
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return c;
    }

    @Override
    public void update(BBeli data, String data2,String data3) {
        con = dbCon.makeConnection();
        
        String sql ="UPDATE `barang_beli` SET `jumlah`='"+data.getJumlah()+"' WHERE `Id_pembelian` = '"+data2+"' AND `Kode_produk`='"+data3+"'";
        System.out.println("Updating barang_beli...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " barang_beli ");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating barang_beli...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public void delete(String data,String data2) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `barang_beli` WHERE `Id_pembelian` = '"+data+"' AND `Kode_produk`='"+data2+"'";
        System.out.println("Deleting barang_beli...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " barang_beli " + data);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating barang_beli...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public BBeli search(String data,String data2) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM barang_beli P JOIN Produk S ON P.Kode_produk  = S.Kode_produk JOIN transaksi_pembelian E On P.Id_pembelian=E.Id_pembelian WHERE (P.Id_pembelian='"+data+"' AND P.Kode_produk='"+data2+"') OR (P.Id_pembelian='"+data+"')";
        System.out.println("Searching barang_beli...");
        BBeli c = null;
        Produk s=null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next()){
                    s=new Produk(rs.getString("S.Kode_produk"), rs.getString("S.nama"), rs.getString("S.jenis"), rs.getInt("S.jumlah"), rs.getFloat("S.harga"));
                    c= new BBeli(rs.getString("P.Id_pembelian"), s,  rs.getInt("P.jumlah"));
                }   
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return c;
    }
}
