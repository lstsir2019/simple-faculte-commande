/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.model.service.impl;


import com.faculte.simplefacultecommande.domain.bean.Fournisseur;
import com.faculte.simplefacultecommande.domain.model.dao.FournisseurDao;
import com.faculte.simplefacultecommande.domain.model.service.FournisseurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mohcine
 */
@Service
public class FourniseurServiceImpl implements FournisseurService {

    @Autowired
    private FournisseurDao fournisseurDao;

    @Override
    public Fournisseur findByReference(String reference) {
        return fournisseurDao.findByReference(reference);
    }
    
     @Override
    public List<Fournisseur> findAllFournisseur() {
        return fournisseurDao.findAll();
    }

    @Override
    public int createFournisseur(Fournisseur fournisseur) {
        if(findByReference(fournisseur.getReference())!=null){
            return -1;
        }else if (fournisseur.getReference().equals("")) {
            return -2;
        }else{
            fournisseurDao.save(fournisseur);
            return 1;
        }
    }
    
    @Override
    public int updateFournisseur(String reference, Fournisseur fournisseur) {
        Fournisseur fr=findByReference(reference);
        if (fr==null) {
            return -1;
        }else{
            fr.setEmail(fournisseur.getNumero());
            fr.setEmail(fournisseur.getEmail());
            fournisseurDao.save(fr);
            return 1;
        }
    }

    public FournisseurDao getFournisseurDao() {
        return fournisseurDao;
    }

    public void setFournisseurDao(FournisseurDao fournisseurDao) {
        this.fournisseurDao = fournisseurDao;
    }

    

   

}
