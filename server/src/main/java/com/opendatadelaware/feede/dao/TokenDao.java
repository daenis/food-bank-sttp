package com.opendatadelaware.feede.dao;

import com.opendatadelaware.feede.config.jwt.JwtTokenFilter;
import com.opendatadelaware.feede.model.Tokens;
import com.opendatadelaware.feede.model.Users;
import com.opendatadelaware.feede.model.fields.TokenType;
import com.opendatadelaware.feede.service.EntityWrapper;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenDao.class);
    private static final long EXPIRATION_TIME = 900000;

    public TokenDao() {
        super(Tokens.class);
    }

    public Optional<Tokens> getTokenEntityFromJTI(String jti) {
       Tokens token  = (Tokens) getSession().createSQLQuery("FROM TOKENS where token = :jti AND expiration_date >= :now")
               .setParameter("jti", UUID.fromString(jti))
               .setParameter("now", new Date());
       LOGGER.debug(token.toString());
       return (token != null) ? Optional.of(token) : Optional.empty();
    }

    public Optional<Tokens> createTokenEntry(EntityWrapper<Users> user) {
        if (user.isPopulated()) {
            Date now = new Date();
            Tokens token = new Tokens().setUuid(UUID.randomUUID()).setTokenType(TokenType.USER)
                    .setCreationTime(now)
                    .setToken(UUID.randomUUID())
                    .setExpirationTime(new Date(now.getTime() + EXPIRATION_TIME))
                    .setUser(user.getEntityObject())
                    .setActive(true);
            UUID tokenPK = create(token);
            Tokens tokenModal = read(tokenPK);
            return (tokenModal != null) ? Optional.of(token) : Optional.empty();
        }
        LOGGER.debug("Valid user entry: " + user.isPopulated());
        return Optional.empty();
    }

}
