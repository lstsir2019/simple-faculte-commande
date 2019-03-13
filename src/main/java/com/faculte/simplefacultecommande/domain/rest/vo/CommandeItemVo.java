/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest.vo;

import java.util.List;

/**
 *
 * @author mohcine
 */
public class CommandeItemVo {
    
     private Long id;
    private String referenceProduit;
    private String qte;
    private String prix;
    private String qteReception;
    private CommandeVo commandeVo;
    private List<CommandeSourceVo> commandeSourceVos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceProduit() {
        return referenceProduit;
    }

    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }

    public String getQte() {
        return qte;
    }

    public void setQte(String qte) {
        this.qte = qte;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getQteReception() {
        return qteReception;
    }

    public void setQteReception(String qteReception) {
        this.qteReception = qteReception;
    }

    public CommandeVo getCommandeVo() {
        return commandeVo;
    }

    public void setCommandeVo(CommandeVo commandeVo) {
        this.commandeVo = commandeVo;
    }

    public List<CommandeSourceVo> getCommandeSourceVos() {
        return commandeSourceVos;
    }

    public void setCommandeSourceVos(List<CommandeSourceVo> commandeSourceVos) {
        this.commandeSourceVos = commandeSourceVos;
    }
    
    
    
}
