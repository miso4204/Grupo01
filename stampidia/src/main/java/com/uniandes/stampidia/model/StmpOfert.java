/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.stampidia.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
*
* @author harold
*/
@Entity
@Table(name = "stmp_ofert")
@NamedQueries({
    @NamedQuery(name = "StmpOfert.findAll", query = "SELECT s FROM StmpOfert s")})
public class StmpOfert implements Serializable {
   private static final long serialVersionUID = 1L;
   @Id
   @SequenceGenerator(name = "ofert_sequence", sequenceName = "ofert_id_seq")
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ofert_sequence")
   @Basic(optional = false)
   @Column(name = "id")
   private Integer id;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 256)
   @Column(name = "name")
   private String name;
   @Basic(optional = false)
   @NotNull
   @Column(name = "discount")
   private Integer discount;
   @Basic(optional = false)
   @NotNull
   @Column(name = "status")
   private boolean status;

   public StmpOfert() {
   }

   public StmpOfert(Integer id) {
       this.id = id;
   }

   public StmpOfert(Integer id, String name, Integer discount, boolean status) {
       this.id = id;
       this.name = name;
       this.discount = discount;
       this.status = status;
   }

   public Integer getId() {
       return id;
   }

   public void setId(Integer id) {
       this.id = id;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public Integer getDiscount() {
       return discount;
   }

   public void setDiscount(Integer discount) {
       this.discount = discount;
   }

   public boolean getStatus() {
       return status;
   }

   public void setStatus(boolean status) {
       this.status = status;
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
       if (!(object instanceof StmpOfert)) {
           return false;
       }
       StmpOfert other = (StmpOfert) object;
       if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
           return false;
       }
       return true;
   }

   @Override
   public String toString() {
       return "com.uniandes.stampidia.model.StmpOfert[ id=" + id + " ]";
   }
   
}
