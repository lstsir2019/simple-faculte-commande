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
public class FournisseurVo {
    
     private Long id;
    private String reference;
    private String numero;
    private String email;
    private List<CommandeVo> commandeVos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public List<CommandeVo> getCommandeVos() {
        return commandeVos;
    }

    public void setCommandeVos(List<CommandeVo> commandeVos) {
        this.commandeVos = commandeVos;
    }
    
    
}
