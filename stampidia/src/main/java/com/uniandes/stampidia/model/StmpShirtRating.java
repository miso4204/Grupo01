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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author harold
 */
@Entity
@Table(name = "stmp_shirt_rating")
@NamedQueries({
    @NamedQuery(name = "StmpShirtRating.findAll", query = "SELECT s FROM StmpShirtRating s")})
public class StmpShirtRating implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valoration")
    private int valoration;
    @Size(max = 512)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "id_shirt", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StmpShirt idShirt;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StmpUser idUser;

    public StmpShirtRating() {
    }

    public StmpShirtRating(Integer id) {
        this.id = id;
    }

    public StmpShirtRating(Integer id, int valoration) {
        this.id = id;
        this.valoration = valoration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getValoration() {
        return valoration;
    }

    public void setValoration(int valoration) {
        this.valoration = valoration;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public StmpShirt getIdShirt() {
        return idShirt;
    }

    public void setIdShirt(StmpShirt idShirt) {
        this.idShirt = idShirt;
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
        if (!(object instanceof StmpShirtRating)) {
            return false;
        }
        StmpShirtRating other = (StmpShirtRating) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniandes.stampidia.model.StmpShirtRating[ id=" + id + " ]";
    }
    
}
