/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Pelanggan;
import DAO.PelangganDAO;
import java.util.List;
import table.pelangganTable;
/**
 *
 * @author iwyny
 */
public class PelangganController {
    PelangganDAO pDao= new PelangganDAO();
    
    public void insertPelanggan(Pelanggan p){
        pDao.insert(p);
    }
    public String generateId(){
            return "IP"+pDao.GenerateID();
        }
    public pelangganTable showTablePelanggan(String target){
        List<Pelanggan> fetchData = pDao.showData(target);
        pelangganTable tableData = new pelangganTable(fetchData);        
        return tableData;
    }
    
    public void updatePelanggan(Pelanggan data, String dataId){
        pDao.update(data, dataId,"");
    }
    
    public void deletePelanggan(String dataId){
        pDao.delete(dataId,"");
    }
    
    public Pelanggan searchPelanggan(String data){
        return pDao.search(data,"");
    }
    
    public List<Pelanggan> showListPelanggan(){
        List<Pelanggan> data = pDao.IShowForDropdown();
        return data;
    }
}
