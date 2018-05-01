package com.RUADota.Controller;

import com.RUADota.DAO.HeroDao;
import com.bangkura.Dota2ApiWrapper.Api.GetHeroes;
import com.bangkura.Dota2ApiWrapper.Model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HeroController {
    @Autowired
    private HeroDao heroDao;

    @RequestMapping(value="/heroes", method= RequestMethod.GET)
    public @ResponseBody List<Hero> getHeroes() {
        return heroDao.getAllHeroes();
    }
}
