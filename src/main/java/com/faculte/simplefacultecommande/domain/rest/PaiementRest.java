/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest;

import com.faculte.simplefacultecommande.domain.bean.Paiement;
import com.faculte.simplefacultecommande.domain.model.service.PaiementService;
import com.faculte.simplefacultecommande.domain.rest.converter.AbstractConverter;
import com.faculte.simplefacultecommande.domain.rest.converter.vo.PaiementVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mohcine
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/faculte-commande/paiementes")
public class PaiementRest {
    
    @Autowired
    private PaiementService paiementService;
    
    @Autowired
    @Qualifier("paiementConverter")
    private AbstractConverter<Paiement,PaiementVo > paiementConverter;

    @PostMapping("/referenceCommande/{referenceCommande}/montant/{montant}")
    public int payerCommande(@PathVariable String referenceCommande,@PathVariable double montant) {
        return paiementService.payerCommande(referenceCommande, montant);
    }

    public PaiementService getPaiementService() {
        return paiementService;
    }

    public void setPaiementService(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    public AbstractConverter<Paiement, PaiementVo> getPaiementConverter() {
        return paiementConverter;
    }

    public void setPaiementConverter(AbstractConverter<Paiement, PaiementVo> paiementConverter) {
        this.paiementConverter = paiementConverter;
    }
    
    
}
