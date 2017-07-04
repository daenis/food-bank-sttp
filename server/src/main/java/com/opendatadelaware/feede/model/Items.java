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
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by aaronlong on 6/23/17.
 */
@Entity
@Table(name = "ITEMS")
public class Items implements Serializable {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "uuid", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
  private UUID uuid;

  @Column(name = "category")
  private String category;

  @Column(name = "description")
  private String description;

  @Column(name = "quantity")
  private Double quantity;

  @ManyToOne(fetch= FetchType.EAGER)
  @JoinColumn(name = "order_number", referencedColumnName = "uuid")
  private Orders orderNumber;

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public Orders getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Orders orderNumber) {
    this.orderNumber = orderNumber;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }


}
