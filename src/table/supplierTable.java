/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;
import Model.Supplier;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//import model.Penitipan;

public class supplierTable extends AbstractTableModel{
    private List<Supplier> list;

    public supplierTable(List<Supplier> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId(); //get id
            case 1:
                return list.get(rowIndex).getNama(); //get nama
            case 2:
                return list.get(rowIndex).getInstansi(); //get instansi
            case 3:
                return list.get(rowIndex).getNoTelp(); //get notelp
            case 4:
                return list.get(rowIndex).getAlamat(); //get alamat
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
                return "Instansi";
            case 3:
                return "Nomor Telepon";
            case 4:
                return "Alamat";
            default:
                return null;
        }
    }
}