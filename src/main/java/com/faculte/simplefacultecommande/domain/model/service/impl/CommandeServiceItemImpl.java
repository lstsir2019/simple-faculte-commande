/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.model.service.impl;

import com.faculte.simplefacultecommande.commun.util.NumberUtil;
import com.faculte.simplefacultecommande.domain.bean.Commande;
import com.faculte.simplefacultecommande.domain.bean.CommandeItem;
import com.faculte.simplefacultecommande.domain.model.dao.CommandeDao;
import com.faculte.simplefacultecommande.domain.model.dao.CommandeItemDao;
import com.faculte.simplefacultecommande.domain.model.service.CommandeItemService;
import com.faculte.simplefacultecommande.domain.model.service.CommandeService;
import com.faculte.simplefacultecommande.domain.rest.vo.CommandeItemVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mohcine
 */
@Service
public class CommandeServiceItemImpl implements CommandeItemService {

    @Autowired
    private CommandeItemDao commandeItemDao;
    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private CommandeService commandeService;

    @Override
    public int saveCommandeItems(Commande commande, List<CommandeItem> commandeItems) {
        if (commandeItems == null || commandeItems.isEmpty()) {
            return -1;
        } else {
            for (CommandeItem commandeItem : commandeItems) {

                CommandeItem ci = commandeItemDao.findByCommandeAndReferenceProduit(commande, commandeItem.getReferenceProduit());

                if (ci == null) {
                    commandeItem.setCommande(commande);
                    commandeItemDao.save(commandeItem);
                } else {
                    ci.setQte(ci.getQte() + commandeItem.getQte());
                    commandeItemDao.save(ci);
                }

            }
            return 1;
        }
    }

    @Override
    public List<CommandeItem> getCommandeItems(Commande commande) {
        return commandeItemDao.findByCommandeReference(commande.getReference());
    }

    @Override
    public List<CommandeItem> findByCommandeReference(String reference) {
        return commandeItemDao.findByCommandeReference(reference);
    }

    @Override
    public int deletItem(Long id) {
        CommandeItem ci = commandeItemDao.getOne(id);
        String r = ci.getCommande().getReference();
        Commande cmd = commandeService.findByReference(r);
        if (ci == null) {
            return -1;
        } else if (ci.getQteAffecte() > 0 || ci.getQteReception() > 0) {
            return -3;
        } else if (cmd == null) {
            return -2;
        } else {
            double x = ci.getPrix() * ci.getQte();
            cmd.setTotal(cmd.getTotal() - x);
            commandeDao.save(cmd);
            commandeItemDao.delete(ci);
            return 1;
        }
    }

    @Override
    public int updateItem(Long id, double qte, double prix) {
        CommandeItem ci = commandeItemDao.getOne(id);
        if (ci == null) {
            return -1;
        } else if (ci.getQteAffecte() > 0 || ci.getQteReception() > 0) {
            return -3;
        } else {
            String r = ci.getCommande().getReference();
            Commande cmd = commandeService.findByReference(r);
            double x = ci.getPrix() * ci.getQte();
            double y = prix * qte;
            cmd.setTotal(cmd.getTotal()-x+y);
            ci.setPrix(prix);
            ci.setQte(qte);
            commandeDao.save(cmd);
            commandeItemDao.save(ci);
            return 1;
        }
    }

    @Override
    public int incrementQteReception(CommandeItemVo commandeItem) {

        CommandeItem ci = commandeItemDao.findByCommandeAndReferenceProduit(commandeDao.findByReference(commandeItem.getReferenceCommande()), commandeItem.getReferenceProduit());
        if (ci == null) {
            return -2;
        }
        if (NumberUtil.toInt(commandeItem.getQteReception()) > ci.getQte() - ci.getQteReception()) {
            return -1;
        } else {
            ci.setQteReception(ci.getQteReception() + NumberUtil.toDecimal(commandeItem.getQteReception()));
            commandeItemDao.save(ci);
            return 1;
        }

    }

    public CommandeItemDao getCommandeItemDao() {
        return commandeItemDao;
    }

    public void setCommandeItemDao(CommandeItemDao commandeItemDao) {
        this.commandeItemDao = commandeItemDao;
    }

    public CommandeDao getCommandeDao() {
        return commandeDao;
    }

    public void setCommandeDao(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    public CommandeService getCommandeService() {
        return commandeService;
    }

    public void setCommandeService(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

}
