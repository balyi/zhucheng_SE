package com.chateau.controller;

import com.chateau.pojo.Chateau;
import com.chateau.pojo.Wine;
import com.chateau.service.ChateauService;
import com.chateau.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by tedu on 2017/11/28.
 */
@RequestMapping("/back")
@Controller
public class BackWineController {
    @Autowired
    private WineService wineService;
    @Autowired
    private ChateauService chateauService;
    @RequestMapping("/wine")
    public String wine(Model model){
        List<Wine> wines=wineService.findAll();
        model.addAttribute("wines",wines);
        return "back/wine";
    }

    @RequestMapping("/addWine")
    public String addWine(Model model){
        List<Chateau> chateaus=chateauService.findAllChateau();
        model.addAttribute("chateaus",chateaus);
        return "back/addWine";
    }

    @RequestMapping("/save")
    public String save(Wine wine){
        wineService.saveWine(wine);
        return "redirect:/back/wine";
    }

    @RequestMapping("/delete")
    public String toDelete(@RequestParam(value="wineId",required = false) String[] wineIds){
        if(wineIds!=null){
            wineService.deleteWineById(wineIds);
        }
        return "redirect:/back/wine";
    }

    @RequestMapping("/view")
    public String view(Model model,String wineId){
        Wine wine=wineService.findOne(wineId);
        model.addAttribute("wine",wine);
        return "/back/wineView";
    }

    @RequestMapping("/toupdateWine")
    public String toupdateWine(String wineId,Model model){
        Wine wine=wineService.findOne(wineId);
        model.addAttribute("wine",wine);
        return "/back/updateWine";
    }
    @RequestMapping("/updateWine")
    public String updateWine(Wine wine){
        wineService.updateWine(wine);
        return "redirect:/back/wine";
    }

}
