/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest.vo;

/**
 *
 * @author mohcine
 */
public class CommandeSourceVo {
    
    private Long id;
    private CommandeItemVo commandeItemVo;
    private String referenceExpressionBesoinItem;
    private String qteAffecte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommandeItemVo getCommandeItemVo() {
        return commandeItemVo;
    }

    public void setCommandeItemVo(CommandeItemVo commandeItemVo) {
        this.commandeItemVo = commandeItemVo;
    }

    public String getReferenceExpressionBesoinItem() {
        return referenceExpressionBesoinItem;
    }

    public void setReferenceExpressionBesoinItem(String referenceExpressionBesoinItem) {
        this.referenceExpressionBesoinItem = referenceExpressionBesoinItem;
    }

    public String getQteAffecte() {
        return qteAffecte;
    }

    public void setQteAffecte(String qteAffecte) {
        this.qteAffecte = qteAffecte;
    }

  
    
    
}
