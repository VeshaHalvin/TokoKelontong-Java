/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Supplier;
import DAO.SupplierDAO;
import java.util.List;
import table.supplierTable;
/**
 *
 * @author iwyny
 */
public class SupplierController {
    SupplierDAO pDao= new SupplierDAO();
    
    public void insertSupplier(Supplier p){
        pDao.insert(p);
    }
    
    public supplierTable showTableSupplier(String target){
        List<Supplier> fetchData = pDao.showData(target);
        supplierTable tableData = new supplierTable(fetchData);        
        return tableData;
    }
    
    public void updateSupplier(Supplier data, String dataId){
        pDao.update(data, dataId,"");
    }
    public String generateId(){
            return "SP"+pDao.GenerateID();
    }
    public void deleteSupplier(String dataId){
        pDao.delete(dataId,"");
    }
    
    public Supplier searchSupplier(String data){
        return pDao.search(data,"");
    }
    
    public List<Supplier> showListSupplier(){
        List<Supplier> data = pDao.IShowForDropdown();
        return data;
    }
    
}
