/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.model.service.impl;

import com.faculte.simplefacultecommande.commun.util.NumberUtil;
import com.faculte.simplefacultecommande.domain.bean.CommandeSource;
import com.faculte.simplefacultecommande.domain.model.dao.CommandeSourceDao;
import com.faculte.simplefacultecommande.domain.model.service.CommandeSourceService;
import com.faculte.simplefacultecommande.domain.rest.proxy.ExpressionBesoinProxy;
import com.faculte.simplefacultecommande.domain.rest.vo.CommandeSourceWithProduit;
import com.faculte.simplefacultecommande.domain.rest.vo.exchange.ExpressionBesoinItemVo;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<CommandeSourceWithProduit> findByRefCommandeAndRefEntite(String refCommande, String refEntite) {
        List<ExpressionBesoinItemVo> expressionBesoins = expressionBesoinProxy.findByExpressionBesoinCodeEntity(refEntite);
        List<Long> referencesExpressionBesoinItem = new ArrayList();
        for (ExpressionBesoinItemVo expressionBesoin : expressionBesoins) {
            referencesExpressionBesoinItem.add(expressionBesoin.getId());
        }    
        List<CommandeSource> commandeSources = commandeSourceDao.findByCommandeItemCommandeReference(refCommande);
        List<CommandeSource> res = new ArrayList();
        for (CommandeSource commandeSource : commandeSources) {
            if (referencesExpressionBesoinItem.contains(commandeSource.getReferenceExpressionBesoinItem())) {
                res.add(commandeSource);
            }
        }
        List<CommandeSourceWithProduit> fin = new ArrayList();
        for (CommandeSource re : res) {
            ExpressionBesoinItemVo exp = expressionBesoinProxy.findById(re.getReferenceExpressionBesoinItem());
            CommandeSourceWithProduit cswp = new CommandeSourceWithProduit();
            cswp.setQteAffecte(NumberUtil.intToString(re.getQteAffecte()));
            cswp.setReferenceProduit(exp.getReferenceProduit());
            fin.add(cswp);
            
        }
        
        return fin;
    }
    
     @Override
    public List<ExpressionBesoinItemVo> findByProduit(String referenceProduit) {
        return expressionBesoinProxy.findByReferenceProduit(referenceProduit);
    }

    public ExpressionBesoinProxy getExpressionBesoinProxy() {
        return expressionBesoinProxy;
    }

    public void setExpressionBesoinProxy(ExpressionBesoinProxy expressionBesoinProxy) {
        this.expressionBesoinProxy = expressionBesoinProxy;
    }

    public CommandeSourceDao getCommandeSourceDao() {
        return commandeSourceDao;
    }

    public void setCommandeSourceDao(CommandeSourceDao commandeSourceDao) {
        this.commandeSourceDao = commandeSourceDao;
    }

   

    

    
    
}
