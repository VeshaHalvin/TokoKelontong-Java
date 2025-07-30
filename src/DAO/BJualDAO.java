/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import InterfaceDAO.*;
import Model.BJual;
import Model.Produk;
import Model.TPenjualan;
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
public class BJualDAO implements IDAO<BJual, String, String>,ISearchDAO<BJual, String, String>{
    protected DBConnection dbCon = new DBConnection();
    protected Connection con;
    
    @Override
    public void insert(BJual data) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO `barang_jual`(`Kode_produk`,`jumlah`,`Id_penjualan`) VALUES('"+data.getProduk().getKode()+"','"+data.getJumlah()+"','"+data.getPenjualan()+"');";    
        System.out.println("Adding barang_jual...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " barang_jual");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding barang_jual...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    public void InputJualBaru(BJual data){
        con = dbCon.makeConnection();
        String sql = "UPDATE `Produk` SET `jumlah`='"+data.getProduk().getJumlah()+"'-'"+data.getJumlah()+"' WHERE Kode_Produk ='"+data.getProduk().getKode()+"'";
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
    public List<BJual> showData(String data) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM barang_jual P JOIN Produk S ON P.Kode_produk  = S.Kode_produk JOIN transaksi_penjualan E On P.Id_penjualan=E.Id_penjualan WHERE P.Id_penjualan LIKE '%"+data+"'";
        System.out.println("Fetching Data...");
        List<BJual> c = new ArrayList();
        Produk s=null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    s=new Produk(rs.getString("S.Kode_produk"), rs.getString("S.nama"), rs.getString("S.jenis"), rs.getInt("S.jumlah"), rs.getFloat("S.Harga_satuan"));
                    c.add(new BJual(rs.getString("P.Id_penjualan"), s,  rs.getInt("P.jumlah")));
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
    public void update(BJual data, String data2, String data3) {
        con = dbCon.makeConnection();
        
        String sql ="UPDATE `barang_jual` SET `jumlah`='"+data.getJumlah()+"' WHERE `Id_penjualan` = '"+data2+"' AND `Kode_produk`='"+data3+"'";
        System.out.println("Updating barang_jual...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " barang_jual ");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating barang_jual...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public void delete(String data, String data2) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `barang_jual` WHERE `Id_penjualan` = '"+data+"' AND `Kode_produk`='"+data2+"'";
        System.out.println("Deleting barang_jual...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " barang_jual " + data);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating barang_jual...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public BJual search(String data, String data2) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM barang_jual P JOIN Produk S ON P.Kode_produk  = S.Kode_produk JOIN transaksi_penjualan E On P.Id_penjualan=E.Id_penjualan WHERE P.Id_pembelian='"+data+"' AND P.Kode_produk='"+data2+"'";
        System.out.println("Searching barang_jual...");
        BJual c = null;
        Produk s=null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    s=new Produk(rs.getString("S.Kode_produk"), rs.getString("S.nama"), rs.getString("S.jenis"), rs.getInt("S.jumlah"), rs.getFloat("S.harga"));
                    c= new BJual(rs.getString("P.Id_penjualan"), s,  rs.getInt("P.jumlah"));
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
    
}
