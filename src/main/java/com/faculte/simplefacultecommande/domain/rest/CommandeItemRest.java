/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest;

import com.faculte.simplefacultecommande.domain.bean.CommandeItem;
import com.faculte.simplefacultecommande.domain.model.service.CommandeItemService;
import com.faculte.simplefacultecommande.domain.model.service.CommandeSourceService;
import com.faculte.simplefacultecommande.domain.rest.converter.AbstractConverter;
import com.faculte.simplefacultecommande.domain.rest.vo.CommandeItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ismail
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/faculte-commande/items")
public class CommandeItemRest {

    @Autowired
    @Qualifier("commandeItemConverter")
    private AbstractConverter<CommandeItem, CommandeItemVo> commandeItemConverter;

    @Autowired
    private CommandeItemService commandeItemService;

    @Autowired
    private CommandeSourceService commandeSourceService;

    //========================================= Delegate Methods =============================================
    @PutMapping("/QteReception/increment")
    public int incrementQteReception(@RequestBody CommandeItemVo commandeItemVo) {
        return commandeItemService.incrementQteReception(commandeItemVo);
    }

    @PutMapping("/QteReception/decrement")
    public int decrementQteReception(@RequestBody CommandeItemVo commandeItemVo) {
        return commandeItemService.decrementQteReception(commandeItemVo);
    }

    @PutMapping("/commandeExpression/{referenceCommandeExpression}/QteLivre/{qte}/increment")
    public int incerementQteLivre(@PathVariable String referenceCommandeExpression, @PathVariable int qte) {
        return commandeSourceService.incerementQteLivre(referenceCommandeExpression, qte);
    }
    
    @PutMapping("/commandeExpression/{referenceCommandeExpression}/QteLivre/{qte}/decrement")
    public int decerementQteLivre(@PathVariable String referenceCommandeExpression, @PathVariable int qte) {
        return commandeSourceService.decerementQteLivre(referenceCommandeExpression, qte);
    }

    @DeleteMapping("/deletItem/id/{id}")
    public int deletItem(@PathVariable Long id) {
        return commandeItemService.deletItem(id);
    }

    @PutMapping("/update/id/{id}/qte/{qte}/prix/{prix}")
    public int updateItem(@PathVariable Long id, @PathVariable double qte, @PathVariable double prix) {
        return commandeItemService.updateItem(id, qte, prix);
    }

    //======================================== GETTER AND SETTER =============================================
    public CommandeItemService getCommandeItemService() {
        return commandeItemService;
    }

    public void setCommandeItemService(CommandeItemService commandeItemService) {
        this.commandeItemService = commandeItemService;
    }

    public AbstractConverter<CommandeItem, CommandeItemVo> getCommandeItemConverter() {
        return commandeItemConverter;
    }

    public void setCommandeItemConverter(AbstractConverter<CommandeItem, CommandeItemVo> commandeItemConverter) {
        this.commandeItemConverter = commandeItemConverter;
    }

}
