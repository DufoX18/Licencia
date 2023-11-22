/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CRUD;

/**
 *
 * @author Usuario
 * @param <Class>
 */
public interface Crud<Class> {

    public int insertar(Class obj);

    public Class actulizar(Class obj);

    public Class eliminar(Class obj);
}
