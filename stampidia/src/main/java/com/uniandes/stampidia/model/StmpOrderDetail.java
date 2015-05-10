/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.stampidia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author harold
 */
@Entity
@Table(name = "stmp_order_detail")
@NamedQueries({
    @NamedQuery(name = "StmpOrderDetail.findAll", query = "SELECT s FROM StmpOrderDetail s")})
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class StmpOrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_value")
    private BigInteger unitValue;
    @JoinColumn(name = "id_order", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StmpOrder idOrder;
    @JoinColumn(name = "id_shirt", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StmpShirt idShirt;

    public StmpOrderDetail() {
    }

    public StmpOrderDetail(Integer id) {
        this.id = id;
    }

    public StmpOrderDetail(Integer id, int quantity, BigInteger unitValue) {
        this.id = id;
        this.quantity = quantity;
        this.unitValue = unitValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigInteger getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(BigInteger unitValue) {
        this.unitValue = unitValue;
    }


    public StmpOrder getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(StmpOrder idOrder) {
        this.idOrder = idOrder;
    }

    public StmpShirt getIdShirt() {
        return idShirt;
    }

    public void setIdShirt(StmpShirt idShirt) {
        this.idShirt = idShirt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StmpOrderDetail)) {
            return false;
        }
        StmpOrderDetail other = (StmpOrderDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniandes.stampidia.model.StmpOrderDetail[ id=" + id + " ]";
    }
    
}
