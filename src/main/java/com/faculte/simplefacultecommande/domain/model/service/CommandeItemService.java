/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.model.service;

import com.faculte.simplefacultecommande.domain.bean.Commande;
import com.faculte.simplefacultecommande.domain.bean.CommandeItem;
import java.util.List;

/**
 *
 * @author mohcine
 */
public interface CommandeItemService {
    
    public int saveCommandeItems(Commande commande,List<CommandeItem> commandeItems);
    public List<CommandeItem> findByCommandeReference(String reference);
    public List<CommandeItem> getCommandeItems(Commande commande);
     public int deletItem(CommandeItem commandeItem);
    
    

}
