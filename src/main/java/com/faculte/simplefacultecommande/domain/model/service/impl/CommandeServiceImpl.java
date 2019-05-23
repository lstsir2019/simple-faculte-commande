/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.model.service.impl;

import com.faculte.simplefacultecommande.commun.util.cherche.CommandeCHerche;
import com.faculte.simplefacultecommande.domain.bean.Commande;
import com.faculte.simplefacultecommande.domain.bean.CommandeItem;
import com.faculte.simplefacultecommande.domain.bean.Fournisseur;
import com.faculte.simplefacultecommande.domain.model.dao.CommandeDao;
import com.faculte.simplefacultecommande.domain.model.service.CommandeItemService;
import com.faculte.simplefacultecommande.domain.model.service.CommandeService;
import com.faculte.simplefacultecommande.domain.model.service.FournisseurService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mohcine
 */
@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    CommandeItemService commandeItemService;

    @Autowired
    CommandeService commandeService;

    @Autowired
    CommandeCHerche commandeCHerche;

    @Autowired
    FournisseurService fournisseurService;

    @Override
    public int saveCommande(Commande commande) {
        Fournisseur fournisseur = fournisseurService.findByReference(commande.getFournisseur().getReference());
        if (fournisseur == null) {
            return -1;
        } else if (commandeService.findByReference(commande.getReference()) != null || commande.getReference().equals("")) {
            return -2;
        }
        calculerTotal(commande, commande.getCommandeItems());
        commande.setFournisseur(fournisseur);
        commandeDao.save(commande);
        commandeItemService.saveCommandeItems(commande, commande.getCommandeItems());
        return 1;

    }

    @Override
    public List<Commande> chercherCommande(String reference, Date dateMax, Date dateMin) {
        return commandeCHerche.chercherCommande(reference, dateMax, dateMin);
    }

    @Override
    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    private void calculerTotal(Commande commande, List<CommandeItem> commandeItems) {
        double total = 0;
        if (commandeItems != null || !commandeItems.isEmpty()) {
            for (CommandeItem commandeItem : commandeItems) {
                total = total + (commandeItem.getPrix() * commandeItem.getQte());
            }
        }
        commande.setTotal(total);
    }

    @Override
    public int deleteByReference(String reference) {
        Commande commande = commandeService.findByReference(reference);
        if (commande == null) {
            return -1;
        } else {
            List<CommandeItem> commandeItems = commandeItemService.getCommandeItems(commande);
            for (CommandeItem commandeItem : commandeItems) {
                commandeItemService.deletItem(commandeItem.getId());
            }
            commandeDao.delete(commande);
            return 1;
        }

    }

    @Override
    public List<Commande> findAllCommande() {
        return commandeDao.findAll();
    }
    
    @Override
    public Commande findByReferenceOffre(String referenceOffre) {
            return commandeDao.findByReferenceOffre(referenceOffre);
    }

    

    public CommandeItemService getCommandeItemService() {
        return commandeItemService;
    }

    public void setCommandeItemService(CommandeItemService commandeItemService) {
        this.commandeItemService = commandeItemService;
    }

    public CommandeDao getCommandeDao() {
        return commandeDao;
    }

    public void setCommandeDao(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    public FournisseurService getFournisseurService() {
        return fournisseurService;
    }

    public void setFournisseurService(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    public CommandeCHerche getCommandeCHerche() {
        return commandeCHerche;
    }

    public void setCommandeCHerche(CommandeCHerche commandeCHerche) {
        this.commandeCHerche = commandeCHerche;
    }

    public CommandeService getCommandeService() {
        return commandeService;
    }

    public void setCommandeService(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    

}
