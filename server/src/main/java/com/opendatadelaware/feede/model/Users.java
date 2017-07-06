package com.opendatadelaware.feede.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by aaronlong on 6/22/17.
 */

@Entity
@Table(name = "USERS")
public class Users implements Serializable {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "uuid", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
  private UUID uuid;

  @Column(name = "email")
  @NotEmpty
  private String email;

  @Column(name = "password")
  @NotEmpty
  private String password;

  @Column(name = "phone")
  private String phone;

  @Column(name = "preferred_location")
  private String location;

  @Column(name = "type")
  private String type;

  public UUID getUuid() {
    return uuid;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
