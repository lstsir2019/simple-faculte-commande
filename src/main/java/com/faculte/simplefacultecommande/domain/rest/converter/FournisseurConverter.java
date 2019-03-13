/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest.converter;


import com.faculte.simplefacultecommande.domain.bean.Fournisseur;
import com.faculte.simplefacultecommande.domain.rest.vo.FournisseurVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author mohcine
 */
@Component
public class FournisseurConverter extends AbstractConverter<Fournisseur, FournisseurVo>{

    @Override
    public Fournisseur toItem(FournisseurVo vo) {
        if (vo==null) {
            return null;
        }else{
            Fournisseur item=new Fournisseur();
            item.setId(vo.getId());
            item.setReference(vo.getReference());
            item.setLibelle(vo.getLibelle());
            item.setRaisonSocial(vo.getRaisonSocial());
            return item;
        }
    }

    @Override
    public FournisseurVo toVo(Fournisseur item) {
       if (item==null) {
             return null;
        }else{
           FournisseurVo vo=new FournisseurVo();
           vo.setId(item.getId());
           vo.setLibelle(item.getLibelle());
           vo.setRaisonSocial(item.getRaisonSocial());
           vo.setReference(item.getReference());
           return vo;
       }
    }

    
}
