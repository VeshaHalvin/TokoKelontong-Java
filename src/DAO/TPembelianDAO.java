/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import InterfaceDAO.*;
import Model.TPembelian;
import Model.Supplier;
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
public class TPembelianDAO implements IDAO<TPembelian, String, String>,ISearchDAO<TPembelian, String, String> ,IGenerateID {
    protected DBConnection dbCon = new DBConnection();
    protected Connection con;
    
    @Override
    public void insert(TPembelian data) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO `Transaksi_Pembelian`(`Id_pembelian`,`tgl`,`harga`,`Id_supplier`) VALUES('"+data.getPembelian()+"','"+data.getTgl_Trans()+"','"+data.getTtlHarga()+"','"+data.getSup().getId()+"')";    
        System.out.println("Adding TPembelian...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " TPembelian");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding TPembelian...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<TPembelian> showData(String data) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM Transaksi_Pembelian P JOIN Supplier S ON P.Id_supplier = S.Id_supplier WHERE Id_pembelian LIKE '%"+data+"'";
        System.out.println("Fetching Data...");
        List<TPembelian> c = new ArrayList();
        Supplier s=null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    s=new Supplier(rs.getString("S.Instansi"), rs.getString("S.Id_supplier"), rs.getString("S.nama"), rs.getString("S.alamat"), rs.getString("S.noTelp"));
                    c.add(new TPembelian(rs.getString("P.Id_pembelian"), s, rs.getString("P.tgl"), rs.getFloat("P.harga")));
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
    public void update(TPembelian data, String data2, String data3) {
        con = dbCon.makeConnection();
        
        String sql ="UPDATE `Transaksi_Pembelian` SET `tgl`='"+data.getTgl_Trans()+"'WHERE `Id_pembelian`='"+data2+"';";
        System.out.println("Updating TPembelian...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " TPembelian " + data2);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating TPembelian...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public void delete(String data, String data2) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `Transaksi_Pembelian` WHERE `Id_pembelian` = '"+data+"'";
        System.out.println("Deleting TPembelian...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " TPembelian " + data);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating TPembelian...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public TPembelian search(String data, String data2) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM Transaksi_Pembelian P JOIN Supplier S ON P.Id_supplier = S.Id_supplier WHERE P.Id_pembelian='"+data+"'";
        System.out.println("Searching TPembelian...");
        TPembelian c = null;
        Supplier s=null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    s=new Supplier(rs.getString("S.Instansi"), rs.getString("S.Id_supplier"), rs.getString("S.nama"), rs.getString("S.alamat"), rs.getString("S.noTelp"));
                    c = new TPembelian(rs.getString("P.Id_pembelian"), s, rs.getString("P.tgl"), rs.getFloat("P.harga"));
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
        String sql = "SELECT MAX(CAST(SUBSTRING(Id_pembelian, 3) AS SIGNED)) AS highest_number FROM Transaksi_Pembelian WHERE Id_pembelian LIKE 'KP%';";
        
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
    
}
