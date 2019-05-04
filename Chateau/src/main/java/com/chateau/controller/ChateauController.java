package com.chateau.controller;

import com.chateau.pojo.Chateau;
import com.chateau.pojo.Wine;
import com.chateau.service.ChateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Austin on 2017/11/26.
 */
@Controller
@RequestMapping("/chateau")
public class ChateauController {

    @Autowired
    private ChateauService chateauService;
    
    @RequestMapping("/list")
    public String chateauList(Model model){

        List<Chateau> listChateau = chateauService.findAllChateau();

        model.addAttribute("listChateaus",listChateau);
        return "chateau/jChateauList";
    }

    @RequestMapping("/toInfo")
    public String chateauInfo(String chateauId,Model model){
        Chateau chateau = chateauService.findOneChateau(chateauId);
        model.addAttribute("chateau",chateau);

        List<Wine> listWine = chateauService.findChateauWine(chateauId);
        model.addAttribute("listWine",listWine);
        return "chateau/jChateauInfo";
    }

}
