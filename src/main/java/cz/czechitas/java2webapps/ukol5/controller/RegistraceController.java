package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;

/**
 * Kontroler obsluhující registraci účastníků dětského tábora.
 */

@Controller

@RequestMapping("/")
public class RegistraceController {

    // STEJNA METODA JAKO NA RADKU 32-35, ALE DELSI ZAPIS
    @GetMapping("/")
    public ModelAndView formular() {
        ModelAndView result = new ModelAndView("formular");
        result.addObject("form", new RegistraceForm());
        return result;
    }
    // STEJNA METODA JAKO NA RADKU 26-29, ALE KRATSI ZAPIS
//    @GetMapping("/")
//    public ModelAndView formular() {
//        return new ModelAndView("/formular").addObject("form", new RegistraceForm());
//    }
//
//}

    @PostMapping("/")
    public Object form(@ModelAttribute("form") @Valid RegistraceForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/formular";
        }

//      METODA PRO VYPOCET VEKU
//      VYTVORENI PODMINEK -> vek ditete, vyplneny sport
        Period period = form.getDatumNarozeni().until(LocalDate.now());
        int vek = period.getYears();

        if (vek < 8 || vek > 15) {
            bindingResult.rejectValue("datumNarozeni", "", "Věk dítěte musí být mezi 9 - 15 lety (včetně).");
            return "formular";
        }
        if (form.getSport().size() < 2) {
            bindingResult.rejectValue("sport", "", "Musíte vybrat alespoň dva sporty.");
            return "formular";
        }

//      METODA PRO ODESLANI REGISTRACE A PRESMEROVANI NA REKAPITULACI
        return new ModelAndView("rekapitulace");
    }


}
