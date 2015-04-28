/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.stampidia.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author harold
 */
@Entity
@Table(name = "stmp_stamp")
@NamedQueries({
    @NamedQuery(name = "StmpStamp.findAll", query = "SELECT s FROM StmpStamp s")})
public class StmpStamp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "stamp_sequence", sequenceName = "stamp_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stamp_sequence")
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
    @Size(min = 1, max = 512)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "tags")
    private String tags;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sales_number")
    private int salesNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigInteger price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStamp")
    private List<StmpShirt> stmpShirtList;
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StmpCategory idCategory;
    @JoinColumn(name = "id_artist_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StmpUser idArtistUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStamp")
    private List<StmpStampRating> stmpStampRatingList;

    public StmpStamp() {
    }

    public StmpStamp(Integer id) {
        this.id = id;
    }

    public StmpStamp(Integer id, String name, String description, String image, String tags, int salesNumber, BigInteger price, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.tags = tags;
        this.salesNumber = salesNumber;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(int salesNumber) {
        this.salesNumber = salesNumber;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    @JsonIgnore
    public List<StmpShirt> getStmpShirtList() {
        return stmpShirtList;
    }

    public void setStmpShirtList(List<StmpShirt> stmpShirtList) {
        this.stmpShirtList = stmpShirtList;
    }

    public StmpCategory getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(StmpCategory idCategory) {
        this.idCategory = idCategory;
    }
    @JsonIgnore
    public StmpUser getIdArtistUser() {
        return idArtistUser;
    }

    public void setIdArtistUser(StmpUser idArtistUser) {
        this.idArtistUser = idArtistUser;
    }
    @JsonIgnore
    public List<StmpStampRating> getStmpStampRatingList() {
        return stmpStampRatingList;
    }

    public void setStmpStampRatingList(List<StmpStampRating> stmpStampRatingList) {
        this.stmpStampRatingList = stmpStampRatingList;
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
        if (!(object instanceof StmpStamp)) {
            return false;
        }
        StmpStamp other = (StmpStamp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniandes.stampidia.model.StmpStamp[ id=" + id + " ]";
    }
    
}
