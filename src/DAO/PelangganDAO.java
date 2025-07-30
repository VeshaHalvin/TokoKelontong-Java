/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import InterfaceDAO.*;
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
public class PelangganDAO implements IDAO<Pelanggan,String,String>,ISearchDAO<Pelanggan, String ,String>,IGenerateID,IShowForDropdown<Pelanggan>{
    protected DBConnection dbCon = new DBConnection();
    protected Connection con;
    
    @Override
    public void insert(Pelanggan data) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO `pelanggan` (`Id_pelanggan`, `nama`, `sex`, `alamat`, `noTelp`,`member`) VALUES ('"+data.getId()+"','"+data.getNama()+"','"+data.getSex()+"','"+data.getAlamat()+"','"+data.getNoTelp()+"',"+data.isMember()+");";    
        System.out.println("Adding Pelanggan...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Pelanggan");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding Pelanggan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<Pelanggan> showData(String data) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM Pelanggan WHERE `Id_pelanggan` LIKE '%"+data+"'";
        System.out.println("Fetching Data...");
        List<Pelanggan> c = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    c.add(new Pelanggan(rs.getString("Sex"), rs.getBoolean("Member"), rs.getString("Id_pelanggan"), rs.getString("nama"), rs.getString("alamat"), rs.getString("noTelp")));
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
    public void update(Pelanggan data, String data2, String data3) {
        con = dbCon.makeConnection();
        
        String sql ="UPDATE `pelanggan` SET `nama`='"+data.getNama()+"', `Sex`='"+data.getSex()+"', `alamat`='"+data.getAlamat()+"',`noTelp`='"+data.getNoTelp()+"', `member`="+data.isMember()+" WHERE `Id_pelanggan`='"+data2+"';";
        System.out.println("Updating Pelanggan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Pelanggan " + data2);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Pelanggan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public void delete(String data, String data2) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `pelanggan` WHERE `Id_pelanggan` = '"+data+"'";
        System.out.println("Deleting Pelanggan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Pelanggan " + data);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Pelanggan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public Pelanggan search(String data, String data2) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `Pelanggan` WHERE Id_pelanggan='"+data+"' OR `nama` LIKE '%"+data+"'";
        System.out.println("Searching Pelanggan...");
        Pelanggan c = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    c = new Pelanggan(rs.getString("Sex"), rs.getBoolean("Member"), rs.getString("Id_pelanggan"), rs.getString("nama"), rs.getString("alamat"), rs.getString("noTelp"));
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
        String sql = "SELECT MAX(CAST(SUBSTRING(Id_pelanggan, 3) AS SIGNED)) AS highest_number FROM Pelanggan WHERE Id_pelanggan LIKE 'IP%';";
        
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
    public List<Pelanggan> IShowForDropdown() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `Pelanggan`;";
        System.out.println("Fetching Data...");
        List<Pelanggan> data = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next()){
                    data.add(new Pelanggan(rs.getString("Sex"), rs.getBoolean("Member"), rs.getString("Id_pelanggan"), rs.getString("nama"), rs.getString("alamat"), rs.getString("noTelp")));
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
