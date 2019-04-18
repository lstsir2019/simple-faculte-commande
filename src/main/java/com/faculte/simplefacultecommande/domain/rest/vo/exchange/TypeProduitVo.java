/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest.vo.exchange;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class TypeProduitVo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String libelle;
    private String code;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TypeProduitVo{" + "libelle=" + libelle + ", code=" + code + '}';
    }

    
}
