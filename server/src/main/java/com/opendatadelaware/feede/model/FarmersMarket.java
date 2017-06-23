package com.opendatadelaware.feede.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by aaronlong on 6/23/17.
 */
@Entity
@Table(name = "FARMERS_MARKET")
public class FarmersMarket {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "uuid", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
  private UUID uuid;

  @OneToOne(fetch= FetchType.EAGER)
  @JoinColumn(name = "contact", referencedColumnName = "uuid")
  private Users contact;

  @Column(name = "email")
  private String email;

  @Column(name = "website")
  private String website;

  @Column(name = "phone")
  private String phone;

  @Column(name = "street_address")
  private String streetAddress;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String zip;

  public Users getContact() {
    return contact;
  }

  public void setContact(Users contact) {
    this.contact = contact;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
