/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.model.dao;

import com.faculte.simplefacultecommande.domain.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mohcine
 */
@Repository
public interface CommandeDao extends JpaRepository<Commande, Long>{
    public Commande findByReference(String reference);
    
}
