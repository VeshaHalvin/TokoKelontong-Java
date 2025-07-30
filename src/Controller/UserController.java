/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.User;
import DAO.UserDAO;
import java.util.List;

/**
 *
 * @author iwyny
 */
public class UserController {
    UserDAO pDao= new UserDAO();
    
    public void insertUser(User p){
        pDao.insert(p);
    }
    
    public String showAllStringUser(){
        List<User> listP = pDao.showData("");
        String penitipString = "";
        int i=0;
        
        for(User p : listP){
            i++;
            penitipString+= p.getUsername()+". "+p.getPassword()+" | "+p.getLevel()+"\n";
        }
        return penitipString;
    }
    
    public void updateUser(User data, String dataId){
        pDao.update(data, dataId,"");
    }
    
    public void deleteUser(String dataId){
        pDao.delete(dataId,"");
    }
    
    public User searchUser(String data,String dataId2){
        return pDao.search(data,dataId2);
    }
    
    public User GetLogin(String data, String dataPas2){
        return pDao.GetUser(data, dataPas2);
    }
}
