/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.model.service;

import com.faculte.simplefacultecommande.domain.bean.Fournisseur;
import java.util.List;

/**
 *
 * @author mohcine
 */
public interface FournisseurService {
    public Fournisseur findByReference(String reference);
    
    public int createFournisseur(Fournisseur fournisseur);
    
    public List<Fournisseur> findAllFournisseur();
    
    public int updateFournisseur(String reference,Fournisseur fournisseur);
}
