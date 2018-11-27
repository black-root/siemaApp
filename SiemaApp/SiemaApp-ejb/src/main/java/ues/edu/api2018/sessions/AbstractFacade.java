/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.api2018.sessions;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author debianyisus
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public T create(T entity) {
        if (entity != null && getEntityManager() != null) {
            getEntityManager().persist(entity);
            return entity;
        } else {
            return null;
        }
    }

    public T edit(T entity) {
        if (entity != null && getEntityManager() != null) {
            getEntityManager().merge(entity);
            return entity;
        } else {
            return null;
        }
    }

    public T remove(T entity) {
        if (entity != null && getEntityManager() != null) {
            getEntityManager().remove(getEntityManager().merge(entity));
            return entity;
        } else {
            return null;
        }
    }
    @PreDestroy  
    public T find(Object id) {
        try {
            if (id != null) {
                return getEntityManager().find(entityClass, id);
            }
        } catch (Exception e) {
            System.out.println("ex: " + e);
        }
        return null;
    }

    public boolean crear(T entity) {

        if (entity != null && getEntityManager() != null) {
            return create(entity) == entity;
        }
        return false;
    }

    public boolean modificar(T entity) {
        if (entity != null && getEntityManager() != null) {
            return edit(entity) == entity;
        }
        return false;
    }

    public boolean eliminar(T entity) {
        if (entity != null && getEntityManager() != null) {
            return remove(entity) == entity;
        }
        return false;
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<T> findWithNombre(String name) {
        String filter = "%" + name.toLowerCase() + "%";
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(entityClass);
        Root<T> en = query.from(entityClass);
        Predicate condicion = builder.or(builder.like(builder.lower(en.<String>get("nombre")), filter));
        query.select(en).where(condicion);
        TypedQuery<T> q = getEntityManager().createQuery(query);
        return q.getResultList();
    }
 public List<T> findWithUsuario(String usuario) {
        String filter = "%" + usuario.toLowerCase() + "%";
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(entityClass);
        Root<T> en = query.from(entityClass);
        Predicate condicion = builder.or(builder.like(builder.lower(en.<String>get("usuario")), filter));
        query.select(en).where(condicion);
        TypedQuery<T> q = getEntityManager().createQuery(query);
        return q.getResultList();
    }
    public List<T> findRange(int min, int pagesize) {

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setFirstResult(min);
        q.setMaxResults(pagesize);
        return q.getResultList();

    }

}
