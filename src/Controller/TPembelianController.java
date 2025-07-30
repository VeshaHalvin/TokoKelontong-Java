/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.TPembelian;
import DAO.TPembelianDAO;
import java.util.List;
import table.transaksiPembelianTable;
/**
 *
 * @author iwyny
 */
public class TPembelianController {
    TPembelianDAO pDao= new TPembelianDAO();
    
    public void insertTPembelian(TPembelian p){
        pDao.insert(p);
    }
    
    public transaksiPembelianTable showTableTPembelian(String target){
        List<TPembelian> fetchData = pDao.showData(target);
        transaksiPembelianTable tableData = new transaksiPembelianTable(fetchData);        
        return tableData;
    }
    
    public void updateTPembelian(TPembelian data, String dataId){
        pDao.update(data, dataId,"");
    }
    
    public void deleteTPembelian(String dataId){
        pDao.delete(dataId,"");
    }
    
    public TPembelian searchTPembelian(String data){
        return pDao.search(data,"");
    }
    
    public String generateId(){
            return "KP"+pDao.GenerateID();
    }
}
