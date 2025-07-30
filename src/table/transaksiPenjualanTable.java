/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;
import Model.TPenjualan;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//import model.Penitipan;

public class transaksiPenjualanTable extends AbstractTableModel{
    private List<TPenjualan> list;

    public transaksiPenjualanTable(List<TPenjualan> list) {
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
                return list.get(rowIndex).getPenjualan(); //getid penjualan
            case 1:
                return list.get(rowIndex).getPel().getNama(); //get id pelanggan
            case 2:
                return list.get(rowIndex).getTgl_Trans(); //get tanggal
            case 3:
                return list.get(rowIndex).getTtlHarga(); //get kode produk
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Penjualan";
            case 1:
                return "Nama pelanggan";
            case 2:
                return "Tanggal Transaksi";
            case 3:
                return "Total Harga";
            default:
                return null;
        }
    }
}