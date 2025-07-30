/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.BBeli;
import DAO.BBeliDAO;
import java.util.List;
import table.detailBeliTable;
/**
 *
 * @author iwyny
 */
public class BBeliController {
    BBeliDAO pDao= new BBeliDAO();
    
    public void insertBBeli(BBeli p){
        pDao.insert(p);
        pDao.InputBeliBaru(p);
    }
    
    public detailBeliTable showTableBBeli(String target){
        List<BBeli> fetchData = pDao.showData(target);
        detailBeliTable tableData = new detailBeliTable(fetchData);        
        return tableData;
    }
    public List<BBeli> listBjual(String target){
        List<BBeli> fetchData = pDao.showData(target);
        return fetchData;
    }
    public void updateBBeli(BBeli data, String dataId,String dataId2){
        pDao.update(data, dataId,dataId2);
    }
    
    public void deleteBBeli(String dataId,String dataId2){
        pDao.delete(dataId,dataId2);
    }
    
    public BBeli searchBBeli(String data,String dataId2){
        return pDao.search(data,dataId2);
    }
}
