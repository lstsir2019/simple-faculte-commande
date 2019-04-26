/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest.vo.exchange;


/**
 *
 * @author ismail boulaanait
 */
public class ExpressionBesoinItemVo {
    private Long id;
    private String referenceCategorieProduit;
    private String referenceProduit;
    private String quantiteDemande;
    private String quantiteAccorder;
    private String quantiteCommander;
    private String description;
    private String quantiteLivre;
    ExpressionBesoinVo expressionBesoinVo;
    private String entityAdmin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceCategorieProduit() {
        return referenceCategorieProduit;
    }

    public void setReferenceCategorieProduit(String referenceCategorieProduit) {
        this.referenceCategorieProduit = referenceCategorieProduit;
    }

    public String getReferenceProduit() {
        return referenceProduit;
    }

    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }

    public String getQuantiteDemande() {
        return quantiteDemande;
    }

    public void setQuantiteDemande(String quantiteDemande) {
        this.quantiteDemande = quantiteDemande;
    }

    public String getQuantiteAccorder() {
        return quantiteAccorder;
    }

    public void setQuantiteAccorder(String quantiteAccorder) {
        this.quantiteAccorder = quantiteAccorder;
    }

    public String getQuantiteCommander() {
        return quantiteCommander;
    }

    public void setQuantiteCommander(String quantiteCommander) {
        this.quantiteCommander = quantiteCommander;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantiteLivre() {
        return quantiteLivre;
    }

    public void setQuantiteLivre(String quantiteLivre) {
        this.quantiteLivre = quantiteLivre;
    }

    public ExpressionBesoinVo getExpressionBesoinVo() {
        return expressionBesoinVo;
    }

    public void setExpressionBesoinVo(ExpressionBesoinVo expressionBesoinVo) {
        this.expressionBesoinVo = expressionBesoinVo;
    }

    public String getEntityAdmin() {
        return entityAdmin;
    }

    public void setEntityAdmin(String entityAdmin) {
        this.entityAdmin = entityAdmin;
    }
    
    
}
