/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;
import Model.TPembelian;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//import model.Penitipan;

public class transaksiPembelianTable extends AbstractTableModel{
    private List<TPembelian> list;

    public transaksiPembelianTable(List<TPembelian> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getPembelian(); //getid pembelian
            case 1:
                return list.get(rowIndex).getSup().getNama(); //get id supplier
            case 2:
                return list.get(rowIndex).getTgl_Trans(); //get tanggal
            case 3:
                return list.get(rowIndex).getTtlHarga(); //get harga total
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Pembelian";
            case 1:
                return "Nama Supplier";
            case 2:
                return "Tanggal Transaksi";
            case 3:
                return "Harga Total";
            default:
                return null;
        }
    }
}