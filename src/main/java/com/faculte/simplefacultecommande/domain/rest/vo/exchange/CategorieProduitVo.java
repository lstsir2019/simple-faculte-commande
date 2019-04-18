/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest.vo.exchange;

import java.io.Serializable;

/**
 *
 * @author YOUNES
 */
public class CategorieProduitVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String libelle;
    private String referenceCompteBuditaire;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReferenceCompteBuditaire() {
        return referenceCompteBuditaire;
    }

    public void setReferenceCompteBuditaire(String referenceCompteBuditaire) {
        this.referenceCompteBuditaire = referenceCompteBuditaire;
    }

    @Override
    public String toString() {
        return "CategorieProduitVo{" + "libelle=" + libelle + ", referenceCompteBuditaire=" + referenceCompteBuditaire + '}';
    }

   
    
}
