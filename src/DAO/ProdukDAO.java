/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import InterfaceDAO.*;
import Model.Produk;
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
public class ProdukDAO implements  IDAO<Produk, String, String>,ISearchDAO<Produk, String, String> ,IGenerateID,IShowForDropdown<Produk> {
    protected DBConnection dbCon = new DBConnection();
    protected Connection con;

    @Override
    public void insert(Produk data) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO `Produk`(`Kode_produk`,`nama`,`jenis`,`jumlah`,`Harga_satuan`) VALUES('"+data.getKode()+"','"+data.getNama()+"','"+data.getJenis()+"','"+data.getJumlah()+"','"+data.getHarga_satuan()+"')";    
        System.out.println("Adding Produk...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Produk");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding Produk...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<Produk> showData(String data) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM Produk WHERE `Kode_produk` LIKE '%"+data+"'";
        System.out.println("Fetching Data...");
        List<Produk> c = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    c.add(new Produk(rs.getString("Kode_produk"), rs.getString("nama"), rs.getString("jenis"), rs.getInt("jumlah"), rs.getFloat("Harga_satuan")));
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
    public void update(Produk data, String data2, String data3) {
        con = dbCon.makeConnection();
        
        String sql ="UPDATE `Produk` SET `nama`='"+data.getNama()+"', `jenis`='"+data.getJenis()+"', `jumlah`='"+data.getJumlah()+"', `Harga_satuan`='"+data.getHarga_satuan()+"' WHERE `Kode_produk`='"+data2+"';";
        System.out.println("Updating Produk...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Produk " + data2);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Produk...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public void delete(String data, String data2) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `Produk` WHERE `Kode_produk` = '"+data+"'";
        System.out.println("Deleting Produk...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Produk " + data);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Produk...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public Produk search(String data, String data2) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `Produk` WHERE Kode_produk='"+data+"' OR nama='"+data+"'";
        System.out.println("Searching Produk...");
        Produk c = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    c = new Produk(rs.getString("Kode_produk"), rs.getString("nama"), rs.getString("jenis"), rs.getInt("jumlah"), rs.getFloat("Harga_satuan"));
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
    public int GenerateID() {
        con = dbCon.makeConnection();
        String sql = "SELECT MAX(CAST(SUBSTRING(Kode_produk, 3) AS SIGNED)) AS highest_number FROM Produk WHERE Kode_produk LIKE 'KP%';";
        
        System.out.println("Generating Id...");
        int id=0;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null && rs.next()){
                if(!rs.wasNull()){
                    id = rs.getInt("highest_number")+1;
                }
            }
                    
                
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return id;
    }

    @Override
    public List<Produk> IShowForDropdown() {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM `Produk`;";
        System.out.println("Fetching Data...");
        List<Produk> data = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    data.add(new Produk(rs.getString("Kode_produk"), rs.getString("nama"), rs.getString("jenis"), rs.getInt("jumlah"), rs.getFloat("Harga_satuan")));
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
        return data;
    }
    

    
}
