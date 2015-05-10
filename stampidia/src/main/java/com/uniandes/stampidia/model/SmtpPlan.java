/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.stampidia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author harold
 */
@Entity
@Table(name = "smtp_plan")
@NamedQueries({
   @NamedQuery(name = "SmtpPlan.findAll", query = "SELECT s FROM SmtpPlan s")})
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class SmtpPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "status")
    private boolean status;
    @OneToMany(mappedBy = "idPlan")
    private List<StmpUser> stmpUserList;

    public SmtpPlan() {
    }

    public SmtpPlan(Integer id) {
        this.id = id;
    }

    public SmtpPlan(Integer id, String name, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<StmpUser> getStmpUserList() {
        return stmpUserList;
    }

    public void setStmpUserList(List<StmpUser> stmpUserList) {
        this.stmpUserList = stmpUserList;
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
        if (!(object instanceof SmtpPlan)) {
            return false;
        }
        SmtpPlan other = (SmtpPlan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniandes.stampidia.model.SmtpPlan[ id=" + id + " ]";
    }
    
}
