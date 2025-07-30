/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.TPenjualan;
import DAO.TPenjualanDAO;
import java.util.List;
import table.transaksiPenjualanTable;
/**
 *
 * @author iwyny
 */
public class TPenjualanController {
    TPenjualanDAO pDao= new TPenjualanDAO();
    
    public void insertTPenjualan(TPenjualan p){
        pDao.insert(p);
    }
    
    public transaksiPenjualanTable showTableTPenjualan(String target){
        List<TPenjualan> fetchData = pDao.showData(target);
        transaksiPenjualanTable tableData = new transaksiPenjualanTable(fetchData);        
        return tableData;
    }
    
    public void updateTPenjualan(TPenjualan data, String dataId){
        pDao.update(data, dataId,"");
    }
    
    public void deleteTPenjualan(String dataId){
        pDao.delete(dataId,"");
    }
    
    public TPenjualan searchTPenjualan(String data){
        return pDao.search(data,"");
    }
    public String generateId(){
            return "KP"+pDao.GenerateID();
    }
}
