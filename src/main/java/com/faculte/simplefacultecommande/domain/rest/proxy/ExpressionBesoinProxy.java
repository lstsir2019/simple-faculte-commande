/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest.proxy;

import com.faculte.simplefacultecommande.domain.rest.vo.exchange.ExpressionBesoinItemVo;
import com.faculte.simplefacultecommande.domain.rest.vo.exchange.ExpressionBesoinVo;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author ismail
 */
@FeignClient(name = "simple-faculte-besoin" , url = "localhost:8099")
public interface ExpressionBesoinProxy {
    
    @GetMapping("/faculte-besoin/expressionbesoins/")
    public List<ExpressionBesoinVo> findAll();
    
    @GetMapping("/find/{id}")
    public ExpressionBesoinItemVo findById(@PathVariable Long id);
    
}
