/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.stampidia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author harold
 */
@Entity
@Table(name = "stmp_shirt")
@NamedQueries({
    @NamedQuery(name = "StmpShirt.findAll", query = "SELECT s FROM StmpShirt s")})
public class StmpShirt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 512)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sales_number")
    private int salesNumber;
    @JoinColumn(name = "id_color", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StmpColor idColor;
    @JoinColumn(name = "id_style", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StmpShirtStyle idStyle;
    @JoinColumn(name = "id_size", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StmpSize idSize;
    @JoinColumn(name = "id_stamp", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StmpStamp idStamp;
    @JoinColumn(name = "id_artist_user", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StmpUser idArtistUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idShirt", fetch = FetchType.LAZY)
    private List<StmpOrderDetail> stmpOrderDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idShirt", fetch = FetchType.LAZY)
    private List<StmpShirtRating> stmpShirtRatingList;

    public StmpShirt() {
    }

    public StmpShirt(Integer id) {
        this.id = id;
    }

    public StmpShirt(Integer id, int salesNumber) {
        this.id = id;
        this.salesNumber = salesNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(int salesNumber) {
        this.salesNumber = salesNumber;
    }

    public StmpColor getIdColor() {
        return idColor;
    }

    public void setIdColor(StmpColor idColor) {
        this.idColor = idColor;
    }

    public StmpShirtStyle getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(StmpShirtStyle idStyle) {
        this.idStyle = idStyle;
    }

    public StmpSize getIdSize() {
        return idSize;
    }

    public void setIdSize(StmpSize idSize) {
        this.idSize = idSize;
    }

    public StmpStamp getIdStamp() {
        return idStamp;
    }

    public void setIdStamp(StmpStamp idStamp) {
        this.idStamp = idStamp;
    }
    @JsonIgnore
    public StmpUser getIdArtistUser() {
        return idArtistUser;
    }

    public void setIdArtistUser(StmpUser idArtistUser) {
        this.idArtistUser = idArtistUser;
    }

    @JsonIgnore
    public List<StmpOrderDetail> getStmpOrderDetailList() {
        return stmpOrderDetailList;
    }

    public void setStmpOrderDetailList(List<StmpOrderDetail> stmpOrderDetailList) {
        this.stmpOrderDetailList = stmpOrderDetailList;
    }
    @JsonIgnore
    public List<StmpShirtRating> getStmpShirtRatingList() {
        return stmpShirtRatingList;
    }

    public void setStmpShirtRatingList(List<StmpShirtRating> stmpShirtRatingList) {
        this.stmpShirtRatingList = stmpShirtRatingList;
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
        if (!(object instanceof StmpShirt)) {
            return false;
        }
        StmpShirt other = (StmpShirt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniandes.stampidia.model.StmpShirt[ id=" + id + " ]";
    }
    
}
