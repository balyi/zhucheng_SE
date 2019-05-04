package com.chateau.controller;

/**
 * Created by tedu on 2017/11/27.
 */

import com.chateau.pojo.Chateau;
import com.chateau.pojo.User;
import com.chateau.service.ChateauService;
import com.chateau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/back")
public class BackChateauController {

    @Autowired
    private ChateauService chateauService;

    @Autowired
    private UserService userService;

    @RequestMapping("/chateau")
    public String backChateau(Model model){
        List<Chateau> allChateau = chateauService.findAllChateau();
        model.addAttribute("listChateau",allChateau);
        return "/back/chateau";
    }

    @RequestMapping("/toDeleteChateau")
    public String toDeleteChateau(@RequestParam(value = "chateauId",required = false)String[] ids){

        if (ids != null){
            chateauService.delete(ids);
        }
        return "redirect:/back/chateau";
    }

    @RequestMapping("/toCreateChateau")
    public String toCreateChateau(Model model){

        List<User> masters = userService.findAllMaster();
        model.addAttribute("userList",masters);
        return "/back/addChateau";
    }

    @RequestMapping("toSaveChateau")
    public String toSaveChateau(Chateau chateau){

        chateauService.saveChateau(chateau);

        return "redirect:/back/chateau";
    }

    @RequestMapping("toUpdateChateau")
    public String toUpdateChateau(String chateauId,Model model){

        Chateau chateau = chateauService.findOneChateau(chateauId);
        model.addAttribute("chateau",chateau);

        List<User> masters = userService.findAllMaster();
        model.addAttribute("userList",masters);

        return "/back/ChateauUpdate";
    }

    @RequestMapping("updateChateau")
    public String updateChateau(Chateau chateau){

        chateauService.updateChateau(chateau);
        return "redirect:/back/chateau";
    }


    @RequestMapping("/toViewChateau")
    public String viewChateau(String chateauId,Model model){

        Chateau chateau = chateauService.findOneChateau(chateauId);
        model.addAttribute("chateau",chateau);

        return "/back/chateauInfo";
    }
}
