/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package READ;

import java.util.List;

/**
 *
 * @author Usuario
 * @param <Class>
 */
public interface Read <Class>{

    public Class buscar(String id);

    public List<Class> buscarTodo();
}
