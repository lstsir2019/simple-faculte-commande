/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.model.service;

import com.faculte.simplefacultecommande.domain.bean.Commande;
import java.util.List;

/**
 *
 * @author mohcine
 */
public interface CommandeService {
    
    public int saveCommande(Commande commande);
    public Commande findByReference(String reference);
    public List<Commande> findAllCommande();
    public int deleteByReference(String reference);

}
