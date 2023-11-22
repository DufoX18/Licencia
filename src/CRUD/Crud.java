/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CRUD;

import java.util.List;

/**
 *
 * @author Usuario
 * @param <Class>
 */
public interface Crud<Class> {

    public boolean insertar(Class obj);

    public Class buscar(String id);

    public List<Class> buscarTodo();

    public boolean actulizar(Class obj);

    public boolean eliminar(Class obj);
}
