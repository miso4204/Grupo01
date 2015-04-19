/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.stampidia.model;

import java.io.Serializable;
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
@Table(name = "stmp_user")
@NamedQueries({ @NamedQuery(name = "StmpUser.findAll", query = "SELECT s FROM StmpUser s") })
public class StmpUser implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "username")
	private String username;
	@Basic(optional = false)
	@NotNull
	@Column(name = "password")
	private String password;
	@Basic(optional = false)
	@NotNull
	@Column(name = "email")
	private String email;
	@Size(max = 256)
	@Column(name = "facebook_email")
	private String facebookEmail;
	@Size(max = 256)
	@Column(name = "twitter_email")
	private String twitterEmail;
	@Basic(optional = false)
	@NotNull
	@Column(name = "is_seller")
	private boolean isSeller;
	@Basic(optional = false)
	@NotNull
	@Column(name = "status")
	private boolean status;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idArtistUser")
	private List<StmpShirt> stmpShirtList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idArtistUser")
	private List<StmpStamp> stmpStampList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
	private List<StmpShirtRating> stmpShirtRatingList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
	private List<StmpOrder> stmpOrderList;
	@JoinColumn(name = "id_plan", referencedColumnName = "id")
	@ManyToOne
	private SmtpPlan idPlan;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
	private List<StmpStampRating> stmpStampRatingList;

	public StmpUser() {
	}

	public StmpUser(Integer id) {
		this.id = id;
	}

	public StmpUser(Integer id, String username, String password, String email, boolean isSeller, boolean status) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isSeller = isSeller;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebookEmail() {
		return facebookEmail;
	}

	public void setFacebookEmail(String facebookEmail) {
		this.facebookEmail = facebookEmail;
	}

	public String getTwitterEmail() {
		return twitterEmail;
	}

	public void setTwitterEmail(String twitterEmail) {
		this.twitterEmail = twitterEmail;
	}

	public boolean getIsSeller() {
		return isSeller;
	}

	public void setIsSeller(boolean isSeller) {
		this.isSeller = isSeller;
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

	@JsonIgnore
	public List<StmpStamp> getStmpStampList() {
		return stmpStampList;
	}

	public void setStmpStampList(List<StmpStamp> stmpStampList) {
		this.stmpStampList = stmpStampList;
	}

	@JsonIgnore
	public List<StmpShirtRating> getStmpShirtRatingList() {
		return stmpShirtRatingList;
	}

	public void setStmpShirtRatingList(List<StmpShirtRating> stmpShirtRatingList) {
		this.stmpShirtRatingList = stmpShirtRatingList;
	}

	@JsonIgnore
	public List<StmpOrder> getStmpOrderList() {
		return stmpOrderList;
	}

	public void setStmpOrderList(List<StmpOrder> stmpOrderList) {
		this.stmpOrderList = stmpOrderList;
	}

	public SmtpPlan getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(SmtpPlan idPlan) {
		this.idPlan = idPlan;
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
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof StmpUser)) {
			return false;
		}
		StmpUser other = (StmpUser) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.uniandes.stampidia.model.StmpUser[ id=" + id + " ]";
	}

}
