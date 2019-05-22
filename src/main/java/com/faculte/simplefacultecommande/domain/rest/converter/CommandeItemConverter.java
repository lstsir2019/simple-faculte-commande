/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest.converter;


import com.faculte.simplefacultecommande.commun.util.NumberUtil;
import com.faculte.simplefacultecommande.domain.bean.CommandeItem;
import com.faculte.simplefacultecommande.domain.rest.vo.CommandeItemVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author mohcine
 */
@Component
public class CommandeItemConverter extends AbstractConverter<CommandeItem, CommandeItemVo>{


    @Override
    public CommandeItem toItem(CommandeItemVo vo) {
        if (vo==null) {
            return null;
        }else{
            CommandeItem item=new CommandeItem();
            item.setId(vo.getId());
            item.setReferenceProduit(vo.getReferenceProduit());
            item.setPrix(NumberUtil.toDecimal(vo.getPrix()));
            item.setQteAffecte(NumberUtil.toDecimal(vo.getQteAffecte()));
            item.setQteReception(NumberUtil.toDecimal(vo.getQteReception()));
            item.setQte(NumberUtil.toDecimal(vo.getQte()));
            
            return item;
        }
    }

    @Override
    public CommandeItemVo toVo(CommandeItem item) {
        if (item==null) {
             return null;
        }else{
           CommandeItemVo vo=new CommandeItemVo();
           vo.setId(item.getId());
           vo.setPrix(NumberUtil.toString(item.getPrix()));
           vo.setQte(NumberUtil.toString(item.getQte()));
           vo.setQteAffecte(NumberUtil.toString(item.getQteAffecte()));
           vo.setQteReception(NumberUtil.toString(item.getQteReception()));
           vo.setReferenceProduit(item.getReferenceProduit());
           return vo;
        }
    }

    
}
