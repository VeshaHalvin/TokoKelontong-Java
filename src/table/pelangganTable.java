/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;
import Model.Pelanggan;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//import model.Penitipan;

public class pelangganTable extends AbstractTableModel{
    private List<Pelanggan> list;

    public pelangganTable(List<Pelanggan> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 6;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId(); //get id
            case 1:
                return list.get(rowIndex).getNama(); //get nama
            case 2:
                return list.get(rowIndex).getSex(); //get sex
            case 3:
                return list.get(rowIndex).getAlamat(); //get alamat
            case 4:
                return list.get(rowIndex).getNoTelp(); //get notelp
            case 5:
                return list.get(rowIndex).isMember(); //get member
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Produk";
            case 1:
                return "Nama Produk";
            case 2:
                return "Gender";
            case 3:
                return "Alamat";
            case 4:
                return "Nomor Telepon";
            case 5:
                return "Member";
            default:
                return null;
        }
    }
}