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
public class ProduitVo implements Serializable {

    private static final long serialVersionUID = 1L;
     private String libelle;
    private String reference;
    private CategorieProduitVo categorieProduitVo;
    private TypeProduitVo typeProduitVo;

    public TypeProduitVo getTypeProduitVo() {
        return typeProduitVo;
    }

    public void setTypeProduitVo(TypeProduitVo typeProduitVo) {
        this.typeProduitVo = typeProduitVo;
    }
  
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public CategorieProduitVo getCategorieProduitVo() {
        return categorieProduitVo;
    }

    public void setCategorieProduitVo(CategorieProduitVo categorieProduitVo) {
        this.categorieProduitVo = categorieProduitVo;
    }

    @Override
    public String toString() {
        return "ProduitVo{" + "libelle=" + libelle + ", reference=" + reference + ", categorieProduitVo=" + categorieProduitVo + ", typeProduitVo=" + typeProduitVo + '}';
    }
    
}
