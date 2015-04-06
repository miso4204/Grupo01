/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.stampidia.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author harold
 */
@Entity
@Table(name = "stmp_order")
@NamedQueries({
    @NamedQuery(name = "StmpOrder.findAll", query = "SELECT s FROM StmpOrder s")})
public class StmpOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipping_status")
    private boolean shippingStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_status")
    private boolean paymentStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_status")
    private boolean orderStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_amount")
    private BigInteger totalAmount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrder")
    private List<StmpOrderDetail> stmpOrderDetailList;
    @JoinColumn(name = "id_payment_type", referencedColumnName = "id")
    @OneToOne(optional = false)
    private StmpPaymentType idPaymentType;
    @JoinColumn(name = "id_shipping_type", referencedColumnName = "id")
    @OneToOne(optional = false)
    private StmpShippingType idShippingType;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @OneToOne(optional = false)
    private StmpUser idUser;

    public StmpOrder() {
    }

    public StmpOrder(Integer id) {
        this.id = id;
    }

    public StmpOrder(Integer id, Date date, boolean shippingStatus, boolean paymentStatus, boolean orderStatus, BigInteger totalAmount) {
        this.id = id;
        this.date = date;
        this.shippingStatus = shippingStatus;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(boolean shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public boolean getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigInteger getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigInteger totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<StmpOrderDetail> getStmpOrderDetailList() {
        if(this.stmpOrderDetailList == null){
            this.stmpOrderDetailList = new ArrayList<StmpOrderDetail>();
        }
        return stmpOrderDetailList;
    }

    public void setStmpOrderDetailList(List<StmpOrderDetail> stmpOrderDetailList) {
        this.stmpOrderDetailList = stmpOrderDetailList;
    }

    public StmpPaymentType getIdPaymentType() {
        return idPaymentType;
    }

    public void setIdPaymentType(StmpPaymentType idPaymentType) {
        this.idPaymentType = idPaymentType;
    }

    public StmpShippingType getIdShippingType() {
        return idShippingType;
    }

    public void setIdShippingType(StmpShippingType idShippingType) {
        this.idShippingType = idShippingType;
    }

    public StmpUser getIdUser() {
        return idUser;
    }

    public void setIdUser(StmpUser idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof StmpOrder)) {
            return false;
        }
        StmpOrder other = (StmpOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniandes.stampidia.model.StmpOrder[ id=" + id + " ]";
    }
    
}
