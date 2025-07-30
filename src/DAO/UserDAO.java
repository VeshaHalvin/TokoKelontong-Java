/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import InterfaceDAO.*;
import Model.User;
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
public class UserDAO implements  IDAO<User, String, String>,ISearchDAO<User, String, String>{
    protected DBConnection dbCon = new DBConnection();
    protected Connection con;
    
    @Override
    public void insert(User data) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO `User`(`username`,`password`,`leveluser`) VALUES('"+data.getUsername()+"','"+data.getPassword()+"','"+data.getLevel()+"')";    
        System.out.println("Adding User...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " User");
            statement.close();
        }catch (Exception e){
            System.out.println("Error adding User...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<User> showData(String data) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM User";
        System.out.println("Fetching Data...");
        List<User> c = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    c.add(new User(rs.getInt("id_user"), rs.getString("username"), rs.getString("password"), rs.getInt("leveluser")));
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
    public void update(User data, String data2, String data3) {
        con = dbCon.makeConnection();
        
        String sql ="UPDATE `User` SET `username`='"+data.getUsername()+"', `password`='"+data.getPassword()+"', `leveluser`='"+data.getLevel()+"' WHERE `id_user`='"+data2+"';";
        System.out.println("Updating User...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " User " + data2);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating User...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public void delete(String data, String data2) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `User` WHERE `id_user` = '"+data+"'";
        System.out.println("Deleting User...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " User " + data);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating User...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public User search(String data, String data2) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `User` WHERE username='"+data+"' OR id_user='"+data+"'";
        System.out.println("Searching User...");
        User c = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    c = new User(rs.getInt("id_user"), rs.getString("username"), rs.getString("password"), rs.getInt("leveluser"));
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
    
    public User GetUser(String data, String data2) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM `User` WHERE username='"+data+"' AND password='"+data2+"'";
        System.out.println("Searching User...");
        User c = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    c = new User(rs.getInt("id_user"), rs.getString("username"), rs.getString("password"), rs.getInt("leveluser"));
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
