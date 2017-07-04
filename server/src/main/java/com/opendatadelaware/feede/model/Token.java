package com.opendatadelaware.feede.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
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
public class Token implements Serializable {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "uuid", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
  private UUID uuid;

  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "uuid", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
  private UUID token;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "date_time", nullable = false, updatable=false)
  private Date dateTime;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user", referencedColumnName = "uuid", nullable=false, updatable=false)
  private Users user;

  @Column(name = "active", columnDefinition="tinyint(1) default 1", nullable = false)
  private boolean active;
}
