/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.model.service.impl;


import com.faculte.simplefacultecommande.domain.bean.Commande;
import com.faculte.simplefacultecommande.domain.bean.CommandeItem;
import com.faculte.simplefacultecommande.domain.model.dao.CommandeItemDao;
import com.faculte.simplefacultecommande.domain.model.service.CommandeItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mohcine
 */
@Service
public class CommandeServiceItemImpl implements CommandeItemService{
    @Autowired
    private CommandeItemDao commandeItemDao;
    @Override
    public int saveCommandeItems(Commande commande, List<CommandeItem> commandeItems) {
         if (commandeItems==null || commandeItems.isEmpty()) {
            return -1;
        }else{
             for (CommandeItem commandeItem : commandeItems) {
                 commandeItem.setCommande(commande);
                 commandeItemDao.save(commandeItem);
             }
             return 1;
         }
    }
    
    @Override
    public List<CommandeItem> getCommandeItems(Commande commande) {
        return commandeItemDao.findByCommandeReference(commande.getReference());
    }

    

    public CommandeItemDao getCommandeItemDao() {
        return commandeItemDao;
    }

    public void setCommandeItemDao(CommandeItemDao commandeItemDao) {
        this.commandeItemDao = commandeItemDao;
    }

    @Override
    public List<CommandeItem> findByCommandeReference(String reference) {
        return commandeItemDao.findByCommandeReference(reference);
    }

    
    
    
}
