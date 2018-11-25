package ues.edu.sv.prn335.sessions;

import java.util.List;

/**
 *
 * @author debianyisus
 */
public interface AbstractFacadeInterface <T>{
    T create(T entity);

    T edit(T entity);

    T remove(T entity);

    boolean crear(T entity);

    boolean modificar(T entity);

    boolean eliminar(T entity);

    T find(Object id);

    List <T> findAll();

    List <T> findRange(int lower, int higher);
 

    int count();

    List <T> findWithNombre(String name);  

}
