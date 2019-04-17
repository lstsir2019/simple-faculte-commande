/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.commun.util.cherche;

import com.faculte.simplefacultecommande.commun.util.SearchUtil;
import com.faculte.simplefacultecommande.domain.bean.Commande;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohcine
 */
@Repository
public class CommandeCHerche {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Commande> chercherCommande(String reference, Date dateMax, Date dateMin) {

        String query = "select c from Commande c where 1=1";
        
            query += SearchUtil.addConstraint("c", "reference", "LIKE", reference);
        
       
            query += SearchUtil.addConstraintMinMaxDate("c", "dateCommande", dateMin, dateMax);
        
        return entityManager.createQuery(query).getResultList();
    }

}
