/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest.converter.vo;

/**
 *
 * @author mohcine
 */
public class CommandeSourceVo {
    
     private Long id;
    private CommandeItemVo commandeItemVo;
    private String referenceExpressionBesoinItem;
    private String qteLivre;

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

    public String getQteLivre() {
        return qteLivre;
    }

    public void setQteLivre(String qteLivre) {
        this.qteLivre = qteLivre;
    }
    
    
}
