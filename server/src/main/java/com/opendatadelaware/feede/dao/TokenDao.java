package com.opendatadelaware.feede.dao;

import com.opendatadelaware.feede.model.Token;
import com.opendatadelaware.feede.model.Users;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by aaronlong on 7/4/17.
 */
public class TokenDao extends AbstractDao<Token, UUID> {
  private EntityManager entityManager;

  public TokenDao() {
    super(Token.class);
  }

  @PersistenceContext
  public void setEntityManager(EntityManager em) {
    entityManager = em;
  }

  public Optional<Token> getTokenEntityFromJTI(String uuid) {
    try {
      FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
      final QueryBuilder queryBuilder = fullTextEntityManager
              .getSearchFactory()
              .buildQueryBuilder().forEntity(Token.class).get();
      Query query = queryBuilder
              .bool()
              .must(queryBuilder.keyword().onField("token").matching(uuid).createQuery())
              .must(queryBuilder.keyword().onField("active").matching(true).createQuery())
              .must(queryBuilder.range().onField("expiration_date").above(new Date()).createQuery())
              .createQuery();
      return Optional.of((Token) fullTextEntityManager.createFullTextQuery(query).getSingleResult());
    } catch (PersistenceException e) {
      return Optional.empty();
    }
  }
}
