/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest.converter;


import com.faculte.simplefacultecommande.commun.util.DateUtil;
import com.faculte.simplefacultecommande.commun.util.NumberUtil;
import com.faculte.simplefacultecommande.domain.bean.Commande;
import com.faculte.simplefacultecommande.domain.rest.vo.CommandeVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author mohcine
 */
@Component
public class CommandeConverter extends AbstractConverter<Commande, CommandeVo>{

    @Override
    public Commande toItem(CommandeVo vo) {
        if (vo==null) {
            return null;
        }else{
            Commande item = new Commande();
            item.setReference(vo.getReference());
            item.setId(vo.getId());
            item.setTotal(NumberUtil.toDecimal(vo.getTotal()));
            item.setDateCommande(DateUtil.parse(vo.getDateCommande()));
            item.setTotalPaiement(NumberUtil.toDecimal(vo.getTotalPaiement()));
            item.setCommandeItems(new CommandeItemConverter().toItem(vo.getCommandeItemVos()));
            item.setFournisseur(new FournisseurConverter().toItem(vo.getFournisseurVo()));
            //item.setPaiements(new PaiementConverter().toItem(vo.getPaiementVos()));
            return item;
            
        }
    }

    @Override
    public CommandeVo toVo(Commande item) {
        if (item==null) {
             return null;
        }else{
            CommandeVo vo =new CommandeVo();
            vo.setId(item.getId());
            vo.setReference(item.getReference());
            vo.setTotal(NumberUtil.toString(item.getTotal()));
            vo.setTotalPaiement(NumberUtil.toString(item.getTotalPaiement()));
            vo.setCommandeItemVos(new CommandeItemConverter().toVo(item.getCommandeItems()));
            vo.setDateCommande(DateUtil.formateDate(item.getDateCommande()));
            //vo.setPaiementVos(new PaiementConverter().toVo(item.getPaiements()));
            vo.setFournisseurVo(new FournisseurConverter().toVo(item.getFournisseur()));
            return vo;
        }
        
    }

   
    
}
