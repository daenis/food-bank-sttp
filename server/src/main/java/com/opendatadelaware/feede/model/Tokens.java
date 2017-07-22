package com.opendatadelaware.feede.model;

import com.opendatadelaware.feede.model.converters.TokenConverter;
import com.opendatadelaware.feede.model.fields.TokenType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by aaronlong on 7/4/17.
 */
@Entity
@Table(name = "TOKENS")
public class Tokens implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "uuid", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID uuid;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "token", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false, updatable = false)
    private Date creationTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expiration_date", nullable = false, updatable = false)
    private Date expirationTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user", referencedColumnName = "uuid", nullable = false, updatable = false)
    private Users user;


    @Column(name = "active", nullable = false)
    private boolean active;

    @Convert(converter = TokenConverter.class)
    @Column(name = "token_type", nullable = false, updatable = false)
    private TokenType tokenType;

    public UUID getUuid() {
        return uuid;
    }

    public Tokens setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public UUID getToken() {
        return token;
    }

    public Tokens setToken(UUID token) {
        this.token = token;
        return this;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public Tokens setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
        return this;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public Tokens setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
        return this;
    }

    public Users getUser() {
        return user;
    }

    public Tokens setUser(Users user) {
        this.user = user;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Tokens setActive(boolean active) {
        this.active = active;
        return this;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public Tokens setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
        return this;
    }
}
