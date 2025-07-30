/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;
import Model.BJual;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//import model.Penitipan;

public class detailJualTable extends AbstractTableModel{
    private List<BJual> list;

    public detailJualTable(List<BJual> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 2;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getProduk().getNama(); //get nama
            case 1:
                return list.get(rowIndex).getJumlah(); //get jumlah
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Nama Produk";
            case 1:
                return "Jumlah Produk";
            default:
                return null;
        }
    }
}