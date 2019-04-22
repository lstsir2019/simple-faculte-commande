/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest;


import com.faculte.simplefacultecommande.domain.bean.Fournisseur;
import com.faculte.simplefacultecommande.domain.model.service.FournisseurService;
import com.faculte.simplefacultecommande.domain.rest.converter.AbstractConverter;
import com.faculte.simplefacultecommande.domain.rest.vo.FournisseurVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mohcine
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/faculte-commande/fournisseurs")
public class FournisseurRest {

    @Autowired
   private FournisseurService fournisseurService;
    
    @Autowired
    @Qualifier("fournisseurConverter")
    private AbstractConverter<Fournisseur, FournisseurVo> fournisseurConverter;
    
    @PostMapping("/")
    public int createFournisseur(@RequestBody FournisseurVo fournisseurVo) {
        return fournisseurService.createFournisseur(fournisseurConverter.toItem(fournisseurVo));
    }
    
    @GetMapping("/reference/{reference}")
    public Fournisseur findByReference(@PathVariable String reference) {
        return fournisseurService.findByReference(reference);
    }
    
    @GetMapping("/finAll")
    public List<FournisseurVo> findAllFournisseur() {
        return fournisseurConverter.toVo(fournisseurService.findAllFournisseur());
    }

    @PutMapping("/reference/{reference}/fournisseur")
    public int updateFournisseur(@PathVariable String reference,@RequestBody FournisseurVo fournisseurVo) {
        return fournisseurService.updateFournisseur(reference, fournisseurConverter.toItem(fournisseurVo));
    }
    
    
    
    
    //=====================================

    public FournisseurService getFournisseurService() {
        return fournisseurService;
    }

    public void setFournisseurService(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    public AbstractConverter<Fournisseur, FournisseurVo> getFournisseurConverter() {
        return fournisseurConverter;
    }

    public void setFournisseurConverter(AbstractConverter<Fournisseur, FournisseurVo> fournisseurConverter) {
        this.fournisseurConverter = fournisseurConverter;
    }

    
    
    
}
