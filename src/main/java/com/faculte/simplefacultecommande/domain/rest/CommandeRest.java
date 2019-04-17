/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest;

import com.faculte.simplefacultecommande.commun.util.DateUtil;
import com.faculte.simplefacultecommande.domain.bean.Commande;
import com.faculte.simplefacultecommande.domain.bean.CommandeItem;
import com.faculte.simplefacultecommande.domain.bean.CommandeSource;
import com.faculte.simplefacultecommande.domain.model.service.CommandeItemService;
import com.faculte.simplefacultecommande.domain.model.service.CommandeService;
import com.faculte.simplefacultecommande.domain.model.service.CommandeSourceService;
import com.faculte.simplefacultecommande.domain.rest.converter.AbstractConverter;
import com.faculte.simplefacultecommande.domain.rest.converter.CommandeConverter;
import com.faculte.simplefacultecommande.domain.rest.vo.CommandeItemVo;
import com.faculte.simplefacultecommande.domain.rest.vo.CommandeVo;
import com.faculte.simplefacultecommande.domain.rest.vo.exchange.ExpressionBesoinItemVo;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mohcine
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/faculte-commande/commandes")
public class CommandeRest {

    @Autowired
    private CommandeService commandeService;
    @Autowired
    private CommandeSourceService commandeSourceService;

    @Autowired
    private CommandeItemService commandeItemService;

    @Autowired
    @Qualifier("commandeConverter")
    private AbstractConverter<Commande, CommandeVo> commandeConverter;

    @Autowired
    @Qualifier("commandeItemConverter")
    private AbstractConverter<CommandeItem, CommandeItemVo> commandeItemConverter;

    @PostMapping("/")
    public int saveCommande(@RequestBody CommandeVo commandeVo) {
        Commande myCommande = commandeConverter.toItem(commandeVo);
        return commandeService.saveCommande(myCommande);
    }

    @GetMapping("/reference/{reference}")
    public CommandeVo findByReference(@PathVariable String reference) {
        return new CommandeConverter().toVo(commandeService.findByReference(reference));
    }

    @GetMapping("/")
    public List<CommandeVo> findAllCommande() {
        return commandeConverter.toVo(commandeService.findAllCommande());
    }

    @GetMapping("/reference/{reference}/commande-items")
    public List<CommandeItemVo> findByCommande(@PathVariable("reference") String reference) {
        final List<CommandeItem> commandeItems = commandeItemService.findByCommandeReference(reference);
        return commandeItemConverter.toVo(commandeItems);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return commandeService.deleteByReference(reference);
    }

    @GetMapping("/faculte-besoin/item/produit/{referenceProduit}")
    public List<ExpressionBesoinItemVo> findByProduit(@PathVariable String referenceProduit) {
        return commandeSourceService.findByProduit(referenceProduit);
    }
    @PostMapping("/chercherCommande")
    public List<CommandeVo> chercherCommande(@RequestBody CommandeVo commandeVO) {
        Date datemn=DateUtil.parse(commandeVO.getDateMin());
        Date datemx=DateUtil.parse(commandeVO.getDateMax());
        return commandeConverter.toVo(commandeService.chercherCommande(commandeVO.getReference(),datemx,datemn));
    }


    public CommandeService getCommandeService() {
        return commandeService;
    }

    public void setCommandeService(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    public AbstractConverter<Commande, CommandeVo> getCommandeConverter() {
        return commandeConverter;
    }

    public void setCommandeConverter(AbstractConverter<Commande, CommandeVo> commandeConverter) {
        this.commandeConverter = commandeConverter;
    }

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

    public CommandeSourceService getCommandeSourceService() {
        return commandeSourceService;
    }

    public void setCommandeSourceService(CommandeSourceService commandeSourceService) {
        this.commandeSourceService = commandeSourceService;
    }

}
