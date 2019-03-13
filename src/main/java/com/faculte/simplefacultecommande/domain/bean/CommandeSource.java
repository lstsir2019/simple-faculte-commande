/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ismail boulaanait
 */
@Entity
public class CommandeSource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private CommandeItem commandeItem;
    private Long referenceExpressionBesoinItem;
    private int qteAffecte;

    public CommandeSource() {
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommandeItem getCommandeItem() {
        return commandeItem;
    }

    public void setCommandeItem(CommandeItem commandeItem) {
        this.commandeItem = commandeItem;
    }

    public Long getReferenceExpressionBesoinItem() {
        return referenceExpressionBesoinItem;
    }

    public void setReferenceExpressionBesoinItem(Long referenceExpressionBesoinItem) {
        this.referenceExpressionBesoinItem = referenceExpressionBesoinItem;
    }

   

    public int getQteAffecte() {
        return qteAffecte;
    }

    public void setQteAffecte(int qteAffecte) {
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
        if (!(object instanceof CommandeSource)) {
            return false;
        }
        CommandeSource other = (CommandeSource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.faculte.facultecommande.bean.CommandeSource[ id=" + id + " ]";
    }
    
}
