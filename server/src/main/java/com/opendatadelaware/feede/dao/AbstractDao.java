package com.opendatadelaware.feede.dao;

import com.opendatadelaware.feede.model.Items;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by aaronlong on 6/27/17.
 */
public abstract class AbstractDao<E extends Serializable, PK extends Serializable> {

    protected SessionFactory session;

    private Class<E> type;

    public AbstractDao(Class<E> daoType) {
        type = daoType;
    }

    protected Class<E> getType() {
        return type;
    }

    protected Session getSession() {
        return session.getCurrentSession();
    }

    @Autowired
    protected void setSession(SessionFactory sessionFactory) {
        session = sessionFactory;
    }

    public E read(PK id) {
        return session.getCurrentSession().get(type, id);
    }

    public PK create(E o) {
        return (PK) getSession().save(o);
    }

    public void update(E o) {
        getSession().update(o);
    }

  public void delete(E o) {
    getSession().delete(o);
  }

  public void deleteByUUID(UUID uuid) {
    getSession().load(getType(), uuid);
    getSession().delete(uuid);
    getSession().flush();
  }
}
