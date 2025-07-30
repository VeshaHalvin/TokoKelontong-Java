/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.BJual;
import DAO.BJualDAO;
import java.util.List;
import table.detailJualTable;
/**
 *
 * @author iwyny
 */
public class BJualController {
    BJualDAO pDao= new BJualDAO();
    
    public void insertBJual(BJual p){
        pDao.insert(p);
        pDao.InputJualBaru(p);
    }
    
    public detailJualTable showTableBJual(String target){
        List<BJual> fetchData = pDao.showData(target);
        detailJualTable tableData = new detailJualTable(fetchData);        
        return tableData;
    }
    public List<BJual> listBjual(String target){
        List<BJual> fetchData = pDao.showData(target);
        return fetchData;
    }
    public void updateBJual(BJual data, String dataId,String dataId2){
        pDao.update(data, dataId,dataId2);
    }
    
    public void deleteBJual(String dataId,String dataId2){
        pDao.delete(dataId,dataId2);
    }
    
    public BJual searchBJual(String data,String dataId2){
        return pDao.search(data,dataId2);
    }
}
