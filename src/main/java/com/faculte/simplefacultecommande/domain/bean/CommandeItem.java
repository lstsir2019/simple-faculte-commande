/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author ismail boulaanait
 */
@Entity
public class CommandeItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String referenceProduit;
    private double prix;
    private double qte;
    private double qteAffecte;
    private double qteReception;
    @ManyToOne
    private Commande commande;
    @OneToMany(mappedBy = "commandeItem")
    private List<CommandeSource> commandeSources;

    public CommandeItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //@JsonIgnore
    public List<CommandeSource> getCommandeSources() {
        return commandeSources;
    }

    //@JsonSetter
    public void setCommandeSources(List<CommandeSource> commandeSources) {
        this.commandeSources = commandeSources;
    }

    public String getReferenceProduit() {
        return referenceProduit;
    }

    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQteReception() {
        return qteReception;
    }

    public void setQteReception(double qteReception) {
        this.qteReception = qteReception;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public double getQteAffecte() {
        return qteAffecte;
    }

    public void setQteAffecte(double qteAffecte) {
        this.qteAffecte = qteAffecte;
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
        if (!(object instanceof CommandeItem)) {
            return false;
        }
        CommandeItem other = (CommandeItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.faculte.facultecommande.bean.CommandeItem[ id=" + id + " ]";
    }

}
