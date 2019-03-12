/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.model.service;

import com.faculte.simplefacultecommande.domain.bean.Commande;

/**
 *
 * @author mohcine
 */
public interface PaiementService {
    
    public int payerCommande(String referenceCommande,double montant);
    
}
