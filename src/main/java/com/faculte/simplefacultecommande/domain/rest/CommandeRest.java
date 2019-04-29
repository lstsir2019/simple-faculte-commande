/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.domain.rest;

import com.faculte.simplefacultecommande.commun.util.DateUtil;
import com.faculte.simplefacultecommande.commun.util.GeneratePdf;
import com.faculte.simplefacultecommande.domain.bean.Commande;
import com.faculte.simplefacultecommande.domain.bean.CommandeItem;
import com.faculte.simplefacultecommande.domain.bean.CommandeSource;
import com.faculte.simplefacultecommande.domain.model.service.CommandeItemService;
import com.faculte.simplefacultecommande.domain.model.service.CommandeService;
import com.faculte.simplefacultecommande.domain.model.service.CommandeSourceService;
import com.faculte.simplefacultecommande.domain.rest.converter.AbstractConverter;
import com.faculte.simplefacultecommande.domain.rest.converter.CommandeConverter;
import com.faculte.simplefacultecommande.domain.rest.proxy.ProduitProxy;
import com.faculte.simplefacultecommande.domain.rest.vo.CommandeItemVo;
import com.faculte.simplefacultecommande.domain.rest.vo.CommandeSourceVo;
import com.faculte.simplefacultecommande.domain.rest.vo.CommandeSourceWithProduit;
import com.faculte.simplefacultecommande.domain.rest.vo.CommandeVo;
import com.faculte.simplefacultecommande.domain.rest.vo.exchange.CategorieProduitVo;
import com.faculte.simplefacultecommande.domain.rest.vo.exchange.ProduitVo;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Produces;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
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
    private ProduitProxy produitProxy;

    @Autowired
    @Qualifier("commandeConverter")
    private AbstractConverter<Commande, CommandeVo> commandeConverter;

    @Autowired
    @Qualifier("commandeSourceConverter")
    private AbstractConverter<CommandeSource, CommandeSourceVo> commandeSourceConverter;

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

    @PostMapping("/commandeSource")
    public int create(@RequestBody CommandeSourceVo commandeSourceVo) {
        return commandeSourceService.create(commandeSourceConverter.toItem(commandeSourceVo));
    }

//    @GetMapping("/faculte-besoin/item/produit/{referenceProduit}")
//    public List<ExpressionBesoinItemVo> findByProduit(@PathVariable String referenceProduit) {
//        return commandeSourceService.findByProduit(referenceProduit);
//    }
    @PostMapping("/chercherCommande")
    public List<CommandeVo> chercherCommande(@RequestBody CommandeVo commandeVO) {
        Date datemn = DateUtil.parse(commandeVO.getDateMin());
        Date datemx = DateUtil.parse(commandeVO.getDateMax());
        return commandeConverter.toVo(commandeService.chercherCommande(commandeVO.getReference(), datemx, datemn));
    }

    @GetMapping("/produit/")
    public List<ProduitVo> findAllProduit() {
        return produitProxy.findAll();

    }

    @GetMapping("/CategorieProduit/")
    public List<CategorieProduitVo> findAllCategorieProduit() {
        return produitProxy.findAllCategorier();
    }

    @GetMapping("/produits/libelle/{libelle}")
    public List<ProduitVo> findByCategorieProduitLibelle(@PathVariable String libelle) {
        return produitProxy.findByCategorieProduitLibelle(libelle);
    }

    @GetMapping("/commande/{refCommande}/entity/{refEntite}")
    public List<CommandeSourceWithProduit> findByRefCommandeAndRefEntite(@PathVariable String refCommande, @PathVariable String refEntite) {
        return commandeSourceService.findByRefCommandeAndRefEntite(refCommande, refEntite);
    }

    @PostMapping("/commandeSources")
    public List<CommandeSourceVo> findCommandeSourcesByCommandeItem(@RequestBody CommandeItem commandeItem) {
        List<CommandeSourceVo> res = commandeSourceService.findCommandeSourcesByCommandeItem(commandeItem);
        for (CommandeSourceVo re : res) {
            re.setCommandeItemVo(commandeItemConverter.toVo(commandeItem));
        }
        return res;
    }

    @DeleteMapping("/commandeSource/{id}")
    public int delete(@PathVariable Long id) {
        return commandeSourceService.delete(id);
    }

    @GetMapping("/pdf/reference/{reference}")
    public ResponseEntity<Object> report(@PathVariable String reference) throws JRException, IOException {
        Commande c = commandeService.findByReference(reference);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fournisseur", c.getFournisseur().getLibelle());
        parameters.put("reference", c.getReference());
        parameters.put("date", c.getDateCommande());
        parameters.put("total", c.getTotal());
        

        return GeneratePdf.generate("commande", parameters, commandeItemService.findByCommandeReference(reference), "/reports/commande.jasper");
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

    public ProduitProxy getProduitProxy() {
        return produitProxy;
    }

    public void setProduitProxy(ProduitProxy produitProxy) {
        this.produitProxy = produitProxy;
    }

}
