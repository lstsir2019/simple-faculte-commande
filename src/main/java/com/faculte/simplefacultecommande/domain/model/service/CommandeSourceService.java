/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.model.service;

import com.faculte.simplefacultecommande.domain.bean.CommandeItem;
import com.faculte.simplefacultecommande.domain.bean.CommandeSource;
import com.faculte.simplefacultecommande.domain.rest.vo.exchange.ExpressionBesoinVo;
import java.util.List;

/**
 *
 * @author mohcine
 */
public interface CommandeSourceService {
    
    public int create (CommandeSource commandeSource);
    
}
