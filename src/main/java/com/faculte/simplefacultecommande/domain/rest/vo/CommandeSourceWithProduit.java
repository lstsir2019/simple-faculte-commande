/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest.vo;

/**
 *
 * @author ismail
 */
public class CommandeSourceWithProduit {
    private String referenceProduit;
    private String qteAffecte;

    public String getReferenceProduit() {
        return referenceProduit;
    }

    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }

    

    public String getQteAffecte() {
        return qteAffecte;
    }

    public void setQteAffecte(String qteAffecte) {
        this.qteAffecte = qteAffecte;
    }
    
    
}
