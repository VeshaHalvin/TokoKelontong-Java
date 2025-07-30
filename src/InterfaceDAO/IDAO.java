/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfaceDAO;

import java.util.List;

/**
 *
 * @author iwyny
 */
public interface IDAO<T,I,X> {
    public void insert(T data);
    public List<T> showData(I data);
    public void update(T data, I data2,X data3);
    public void delete(I data,X data2);
}
