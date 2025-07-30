/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;
import Model.Produk;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//import model.Penitipan;

public class barangTable extends AbstractTableModel{
    private List<Produk> list;

    public barangTable(List<Produk> list) {
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
                return list.get(rowIndex).getKode(); //getid
            case 1:
                return list.get(rowIndex).getNama(); //get nama
            case 2:
                return list.get(rowIndex).getJenis(); //get jenis
            case 3:
                return list.get(rowIndex).getJumlah(); //get jumlah
            case 4:
                return list.get(rowIndex).getHarga_satuan(); //get harga satuan
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Kode Produk";
            case 1:
                return "Nama Produk";
            case 2:
                return "Jenis Produk";
            case 3:
                return "Jumlah Produk";
            case 4:
                return "Harga Satuan";
            default:
                return null;
        }
    }
}