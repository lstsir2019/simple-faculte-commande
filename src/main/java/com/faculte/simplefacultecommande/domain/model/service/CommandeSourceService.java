/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.model.service;

import com.faculte.simplefacultecommande.domain.bean.CommandeItem;
import com.faculte.simplefacultecommande.domain.bean.CommandeSource;
import com.faculte.simplefacultecommande.domain.rest.vo.CommandeSourceVo;
import com.faculte.simplefacultecommande.domain.rest.vo.CommandeSourceWithProduit;
import com.faculte.simplefacultecommande.domain.rest.vo.exchange.ExpressionBesoinItemVo;
import java.util.List;

/**
 *
 * @author mohcine
 */
public interface CommandeSourceService {
    
    public int create (CommandeSource commandeSource);
    public List<ExpressionBesoinItemVo> findByProduit(String referenceProduit);
    public List<CommandeSourceWithProduit> findByRefCommandeAndRefEntite(String refCommande,String refEntite);
    public int incerementQteLivre(String referenceCommandeExpression , int qte);
    public List<CommandeSourceVo> findCommandeSourcesByCommandeItem(CommandeItem commandeItem);
    public int delete(Long id);
    
    
}
