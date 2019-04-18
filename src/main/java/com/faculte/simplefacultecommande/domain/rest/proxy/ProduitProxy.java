/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest.proxy;

import com.faculte.simplefacultecommande.domain.rest.vo.exchange.CategorieProduitVo;
import com.faculte.simplefacultecommande.domain.rest.vo.exchange.ProduitVo;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author ismail
 */
@FeignClient(name = "microservice-produits" , url = "localhost:8070")
public interface ProduitProxy {
    
     @GetMapping("/produit_api/produit/")
    public List<ProduitVo> findAll();
    
    @GetMapping("/produit_api/categoriType/categorie/findAll")
    public List<CategorieProduitVo> findAllCategorier();
    
     @GetMapping("/produit_api/produit/chercher/categorie/libelle/{libelle}")
    public List<ProduitVo> findByCategorieProduitLibelle(@PathVariable String libelle);
    
}
