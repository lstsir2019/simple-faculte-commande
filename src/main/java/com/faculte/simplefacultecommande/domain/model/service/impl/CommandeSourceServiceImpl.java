/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.model.service.impl;

import com.faculte.simplefacultecommande.commun.util.NumberUtil;
import com.faculte.simplefacultecommande.domain.bean.CommandeItem;
import com.faculte.simplefacultecommande.domain.bean.CommandeSource;
import com.faculte.simplefacultecommande.domain.model.dao.CommandeSourceDao;
import com.faculte.simplefacultecommande.domain.model.service.CommandeSourceService;
import com.faculte.simplefacultecommande.domain.rest.proxy.ExpressionBesoinProxy;
import com.faculte.simplefacultecommande.domain.rest.vo.exchange.ExpressionBesoinItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mohcine
 */
@Service
public class CommandeSourceServiceImpl implements CommandeSourceService{
    
    @Autowired
    ExpressionBesoinProxy expressionBesoinProxy;
    
    @Autowired
    CommandeSourceDao commandeSourceDao;

    @Override
    public int create(CommandeSource commandeSource) {
        ExpressionBesoinItemVo expressionBesoinItemVo = expressionBesoinProxy.findById(commandeSource.getReferenceExpressionBesoinItem());
        if (expressionBesoinItemVo==null) {
            return -1;
        }else{
            int qteAccorder = NumberUtil.toInt(expressionBesoinItemVo.getQuantiteAccorder());
            int qteCommander = NumberUtil.toInt(expressionBesoinItemVo.getQuantiteCommander());
            if (commandeSource.getQteAffecte() > qteAccorder-qteCommander) {
                return -2;
            }else if (!commandeSource.getCommandeItem().getReferenceProduit().equals(expressionBesoinItemVo.getReferenceProduit())) {
                return -3;
            }else{
                commandeSourceDao.save(commandeSource);
                return 1;
            }
        }
    }

    

    
    
}
