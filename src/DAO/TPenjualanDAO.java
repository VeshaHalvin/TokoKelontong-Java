/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import InterfaceDAO.*;
import Model.TPenjualan;
import Model.Pelanggan;
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
public class TPenjualanDAO implements IDAO<TPenjualan, String, String>,ISearchDAO<TPenjualan, String, String> ,IGenerateID{
    protected DBConnection dbCon = new DBConnection();
    protected Connection con;
    
    @Override
    public void insert(TPenjualan data) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO `transaksi_penjualan`(`Id_penjualan`,`tgl`,`total`,`Id_pelanggan`) VALUES('"+data.getPenjualan()+"','"+data.getTgl_Trans()+"','"+data.getTtlHarga()+"','"+data.getPel().getId()+"')";    
        System.out.println("Adding TPenjualan...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " TPenjualan");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding TPenjualan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<TPenjualan> showData(String data) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM transaksi_penjualan P JOIN Pelanggan S ON P.Id_pelanggan = S.Id_pelanggan WHERE Id_penjualan LIKE '%"+data+"'";
        System.out.println("Fetching Data...");
        List<TPenjualan> c = new ArrayList();
        Pelanggan s=null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    s=new Pelanggan(rs.getString("S.sex"), rs.getBoolean("S.member"), rs.getString("S.Id_pelanggan"), rs.getString("S.nama"), rs.getString("S.alamat"), rs.getString("S.noTelp"));
                    c.add(new TPenjualan(rs.getString("P.Id_penjualan"), s, rs.getString("P.tgl"), rs.getFloat("P.total")));
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
    public void update(TPenjualan data, String data2, String data3) {
        con = dbCon.makeConnection();
        
        String sql ="UPDATE `transaksi_penjualan` SET `tgl`='"+data.getTgl_Trans()+"', `total`='"+data.getTtlHarga()+"', `Id_pelanggan` ='"+data.getPel().getId()+"'WHERE `Id_Penjualan`='"+data2+"';";
        System.out.println("Updating TPenjualan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " TPenjualan " + data2);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating TPenjualan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public void delete(String data, String data2) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `transaksi_penjualan` WHERE `Id_penjualan` = '"+data+"'";
        System.out.println("Deleting TPenjualan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " TPenjualan " + data);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating TPenjualan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public TPenjualan search(String data, String data2) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM transaksi_penjualan P JOIN Pelanggan S ON P.Id_pelanggan = S.Id_pelanggan WHERE P.Id_penjualan='"+data+"'";
        System.out.println("Searching TPenjualan...");
        TPenjualan c = null;
        Pelanggan s=null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    s=new Pelanggan(rs.getString("S.sex"), rs.getBoolean("S.member"), rs.getString("S.Id_pelanggan"), rs.getString("S.nama"), rs.getString("S.alamat"), rs.getString("S.noTelp"));
                    c = new TPenjualan(rs.getString("P.Id_pembelian"), s, rs.getString("P.tgl"), rs.getFloat("P.harga"));
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
        String sql = "SELECT MAX(CAST(SUBSTRING(Id_penjualan, 3) AS SIGNED)) AS highest_number FROM transaksi_penjualan WHERE Id_penjualan LIKE 'KP%';";
        
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
