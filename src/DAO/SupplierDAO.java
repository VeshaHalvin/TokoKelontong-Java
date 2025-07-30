/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import InterfaceDAO.*;
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
public class SupplierDAO implements IDAO<Supplier, String, String>,ISearchDAO<Supplier, String, String> ,IGenerateID,IShowForDropdown<Supplier>{
    protected DBConnection dbCon = new DBConnection();
    protected Connection con;
    
    @Override
    public void insert(Supplier data) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO `Supplier`(`Id_supplier`,`nama`,`alamat`,`noTelp`,`Instansi`) VALUES('"+data.getId()+"','"+data.getNama()+"','"+data.getAlamat()+"','"+data.getNoTelp()+"','"+data.getInstansi()+"')";    
        System.out.println("Adding Supplier...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Supplier");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding Supplier...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<Supplier> showData(String data) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM Supplier WHERE `Id_supplier` LIKE '%"+data+"'";
        System.out.println("Fetching Data...");
        List<Supplier> c = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    c.add(new Supplier(rs.getString("Instansi"), rs.getString("Id_supplier"), rs.getString("nama"), rs.getString("alamat"), rs.getString("noTelp")));
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
    public void update(Supplier data, String data2, String data3) {
        con = dbCon.makeConnection();
        
        String sql ="UPDATE `Supplier` SET `nama`='"+data.getNama()+"', `alamat`='"+data.getAlamat()+"', `noTelp`='"+data.getNoTelp()+"', `Instansi`='"+data.getInstansi()+"' WHERE `Id_supplier`='"+data2+"';";
        System.out.println("Updating Supplier...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Supplier " + data2);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Supplier...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public void delete(String data, String data2) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `Supplier` WHERE `Id_supplier` = '"+data+"'";
        System.out.println("Deleting Supplier...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Supplier " + data);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Supplier...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public Supplier search(String data, String data2) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `Supplier` WHERE Id_supplier='"+data+"' OR nama='"+data+"'";
        System.out.println("Searching Supplier...");
        Supplier c = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    c = new Supplier(rs.getString("Instansi"), rs.getString("Id_supplier"), rs.getString("nama"), rs.getString("alamat"), rs.getString("noTelp"));
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
        String sql = "SELECT MAX(CAST(SUBSTRING(Id_supplier, 3) AS SIGNED)) AS highest_number FROM Supplier WHERE Id_supplier LIKE 'SP%';";
        
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
    public List<Supplier> IShowForDropdown() {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM `Supplier`;";
        System.out.println("Fetching Data...");
        List<Supplier> data = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    data.add(new Supplier(rs.getString("Instansi"), rs.getString("Id_supplier"), rs.getString("nama"), rs.getString("alamat"), rs.getString("noTelp")));
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
