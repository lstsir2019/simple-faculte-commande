/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest.converter;


import com.faculte.simplefacultecommande.commun.util.NumberUtil;
import com.faculte.simplefacultecommande.domain.bean.CommandeSource;
import com.faculte.simplefacultecommande.domain.rest.vo.CommandeSourceVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author mohcine
 */
@Component
public class CommandeSourceConverter extends AbstractConverter<CommandeSource, CommandeSourceVo>{

    @Override
    public CommandeSource toItem(CommandeSourceVo vo) {
          if (vo==null) {
            return null;
        }else{
             CommandeSource item=new CommandeSource();
             item.setId(vo.getId());
             item.setQteAffecte(NumberUtil.toDecimal(vo.getQteAffecte()));
             item.setQteLivre(NumberUtil.toDecimal(vo.getQteLivre()));
             item.setReferenceExpressionBesoinItem(NumberUtil.StringtoLong(vo.getReferenceExpressionBesoinItem()));
             item.setCommandeItem(new CommandeItemConverter().toItem(vo.getCommandeItemVo()));
             return item;
          }
    }

    @Override
    public CommandeSourceVo toVo(CommandeSource item) {
         if (item==null) {
             return null;
        }else{
            CommandeSourceVo vo=new CommandeSourceVo();
            vo.setId(item.getId());
            vo.setQteAffecte(NumberUtil.toString(item.getQteAffecte()));
             vo.setQteLivre(NumberUtil.toString(item.getQteLivre()));
            vo.setReferenceExpressionBesoinItem(NumberUtil.LongToString(item.getReferenceExpressionBesoinItem()));
            vo.setCommandeItemVo(new CommandeItemConverter().toVo(item.getCommandeItem()));
            return vo;
            
         }
    }

    
    
}
