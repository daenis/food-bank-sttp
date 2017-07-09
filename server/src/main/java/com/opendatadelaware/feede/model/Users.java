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

  @Column(name = "password", length = 60)
  @NotEmpty
  private String password;

  @Column(name = "phone")
  private String phone;

  @Column(name = "address")
  private String address;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "zip")
  private String zip;

  public UUID getUuid() {
    return uuid;
  }

  public Users setUuid(UUID uuid) {
    this.uuid = uuid;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Users setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public Users setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public Users setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public Users setAddress(String address) {
    this.address = address;
    return this;
  }

  public String getCity() {
    return city;
  }

  public Users setCity(String city) {
    this.city = city;
    return this;
  }

  public String getState() {
    return state;
  }

  public Users setState(String state) {
    this.state = state;
    return this;
  }

  public String getZip() {
    return zip;
  }

  public Users setZip(String zip) {
    this.zip = zip;
    return this;
  }
  
}
