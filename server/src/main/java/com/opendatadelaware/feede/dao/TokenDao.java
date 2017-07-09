package com.opendatadelaware.feede.dao;

import com.opendatadelaware.feede.model.Tokens;
import com.opendatadelaware.feede.service.TokenService;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by aaronlong on 7/4/17.
 */
@Repository
@Transactional
public class TokenDao extends AbstractDao<Tokens, UUID> {
  private EntityManager entityManager;

  public TokenDao() {
    super(Tokens.class);
  }

  @PersistenceContext
  public void setEntityManager(EntityManager em) {
    entityManager = em;
  }

  public Optional<Tokens> getTokenEntityFromJTI(String uuid) {
    try {
      FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
      final QueryBuilder queryBuilder = fullTextEntityManager
              .getSearchFactory()
              .buildQueryBuilder().forEntity(Tokens.class).get();
      Query query = queryBuilder
              .bool()
              .must(queryBuilder.keyword().onField("token").matching(uuid).createQuery())
              .must(queryBuilder.keyword().onField("active").matching(true).createQuery())
              .must(queryBuilder.range().onField("expiration_date").above(new Date()).createQuery())
              .createQuery();
      return Optional.of((Tokens) fullTextEntityManager.createFullTextQuery(query).getSingleResult());
    } catch (PersistenceException e) {
      return Optional.empty();
    }
  }

  public void addToken(String jtiToken) {
    TokenService service = new TokenService();
    Tokens token = service.getTokenEntityFromJtiToken(jtiToken).getEntityObject();
    create(token);
  }

}
