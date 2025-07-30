/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Produk;
import DAO.ProdukDAO;
import java.util.List;
import table.barangTable;
/**
 *
 * @author iwyny
 */
public class ProdukController {
    ProdukDAO pDao= new ProdukDAO();
    
    public void insertProduk(Produk p){
        pDao.insert(p);
    }
    public String generateId(){
            return "KP"+pDao.GenerateID();
        }
    public barangTable showTableProduk(String target){
        List<Produk> fetchData = pDao.showData(target);
        barangTable tableData = new barangTable(fetchData);        
        return tableData;
    }
    
    public void updateProduk(Produk data, String dataId){
        pDao.update(data, dataId,"");
    }
    
    public void deleteProduk(String dataId){
        pDao.delete(dataId,"");
    }
    
    public Produk searchProduk(String data){
        return pDao.search(data,"");
    }
    
    public List<Produk> showListProduk(){
        List<Produk> data = pDao.IShowForDropdown();
        return data;
    }
}
