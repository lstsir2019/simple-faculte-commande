/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.model.service.impl;

import com.faculte.simplefacultecommande.domain.bean.Commande;
import com.faculte.simplefacultecommande.domain.bean.Paiement;
import com.faculte.simplefacultecommande.domain.model.dao.PaiementDao;
import com.faculte.simplefacultecommande.domain.model.service.CommandeService;
import com.faculte.simplefacultecommande.domain.model.service.PaiementService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mohcine
 */
@Service
public class PaiementServiceImpl implements PaiementService {

    @Autowired
    private PaiementDao paiementDao;

    @Autowired
    private CommandeService commandeService;
    
    
    @Override
    public List<Paiement> findByCommandeReference(String reference) {
        return paiementDao.findByCommandeReference(reference);
    }

    @Override
    public int payerCommande(String referenceCommande, double montant) {
        Commande commande = commandeService.findByReference(referenceCommande);
        if (commande == null) {
            return -1;
        } else if (commande.getTotal() < montant + commande.getTotalPaiement()) {
            return -2;
        } else if (commande.getTotal() == commande.getTotalPaiement()) {
            return -3;
        } else {
            commande.setTotalPaiement(commande.getTotalPaiement() + montant);
            Paiement p = new Paiement();
            p.setCommande(commande);
            p.setMontant(montant);
            p.setDatePaiement(new Date());
            paiementDao.save(p);
            return 1;
        }

    }

    public PaiementDao getPaiementDao() {
        return paiementDao;
    }

    public void setPaiementDao(PaiementDao paiementDao) {
        this.paiementDao = paiementDao;
    }

    public CommandeService getCommandeService() {
        return commandeService;
    }

    public void setCommandeService(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    

}
