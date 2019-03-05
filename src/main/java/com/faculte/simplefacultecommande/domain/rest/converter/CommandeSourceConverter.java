/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest.converter;


import com.faculte.simplefacultecommande.commun.util.NumberUtil;
import com.faculte.simplefacultecommande.domain.bean.CommandeSource;
import com.faculte.simplefacultecommande.domain.rest.converter.vo.CommandeSourceVo;
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
             item.setQteLivre(NumberUtil.toInt(vo.getQteLivre()));
             item.setReferenceExpressionBesoinItem(vo.getReferenceExpressionBesoinItem());
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
            vo.setQteLivre(NumberUtil.intToString(item.getQteLivre()));
            vo.setReferenceExpressionBesoinItem(item.getReferenceExpressionBesoinItem());
            return vo;
            
         }
    }

    
    
}
