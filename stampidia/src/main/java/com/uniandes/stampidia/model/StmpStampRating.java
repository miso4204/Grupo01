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
@Table(name = "stmp_stamp_rating")
@NamedQueries({
    @NamedQuery(name = "StmpStampRating.findAll", query = "SELECT s FROM StmpStampRating s")})
public class StmpStampRating implements Serializable {
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
    @JoinColumn(name = "id_stamp", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StmpStamp idStamp;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StmpUser idUser;

    public StmpStampRating() {
    }

    public StmpStampRating(Integer id) {
        this.id = id;
    }

    public StmpStampRating(Integer id, int valoration) {
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

    public StmpStamp getIdStamp() {
        return idStamp;
    }

    public void setIdStamp(StmpStamp idStamp) {
        this.idStamp = idStamp;
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
        if (!(object instanceof StmpStampRating)) {
            return false;
        }
        StmpStampRating other = (StmpStampRating) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniandes.stampidia.model.StmpStampRating[ id=" + id + " ]";
    }

    public boolean isNull(){
        return this.id == null &&
                this.comment == null &&
                this.idStamp == null &&
                this.idUser == null &&
                this.valoration < 1;
    }
    
}
