/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest;

import com.faculte.simplefacultecommande.commun.util.GeneratePdf;
import com.faculte.simplefacultecommande.commun.util.PdfUtil;
import com.faculte.simplefacultecommande.domain.bean.Commande;
import com.faculte.simplefacultecommande.domain.bean.Paiement;
import com.faculte.simplefacultecommande.domain.model.service.CommandeService;
import com.faculte.simplefacultecommande.domain.model.service.PaiementService;
import com.faculte.simplefacultecommande.domain.rest.converter.AbstractConverter;
import com.faculte.simplefacultecommande.domain.rest.vo.PaiementVo;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private CommandeService commandeService;

    
    
    @Autowired
    @Qualifier("paiementConverter")
    private AbstractConverter<Paiement,PaiementVo > paiementConverter;

    
    @GetMapping("/reference/{reference}")
    public List<PaiementVo> findByCommandeReference(@PathVariable String reference) {
        return paiementConverter.toVo(paiementService.findByCommandeReference(reference));
    }
    @PostMapping("/referenceCommande/{referenceCommande}/montant/{montant}/type/{type}")
    public int payerCommande(@PathVariable String referenceCommande,@PathVariable double montant,@PathVariable String type) {
        return paiementService.payerCommande(referenceCommande, montant,type);
    }
    
    @GetMapping("/pdf/paiement/{reference}")
    public ResponseEntity<Object> CommandePrint(@PathVariable String reference) throws JRException, IOException {
        Commande c = commandeService.findByReference(reference);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("refCommande", c.getReference());
        parameters.put("totalPaye", c.getTotalPaiement());
        parameters.put("reste", c.getTotal()-c.getTotalPaiement());

        return PdfUtil.generate("paiemment", parameters,paiementService.findByCommandeReference(reference), "/reports/paiemment.jasper");
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

    public CommandeService getCommandeService() {
        return commandeService;
    }

    public void setCommandeService(CommandeService commandeService) {
        this.commandeService = commandeService;
    }
    
    
}
