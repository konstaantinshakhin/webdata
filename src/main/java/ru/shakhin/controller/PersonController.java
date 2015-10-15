package ru.shakhin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.shakhin.model.Contact;
import ru.shakhin.model.Person;
import ru.shakhin.services.PersonService;

import java.math.BigInteger;

/**
 * Created by kshahin on 10/14/2015.
 */
@Controller
public class PersonController {
    @Autowired
    private PersonService personService;
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("all");

        modelAndView.addObject("persons", personService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "/addperson", method = RequestMethod.GET)
    public ModelAndView showAddForm() {
        return new ModelAndView("person_form", "person", new Contact());
    }

    @RequestMapping(value = "/addperson", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person) {
        if(person.getId() == null) personService.add(person,new BigInteger("0"));
        else personService.update(person,new BigInteger("0"));

        return "redirect:/persons";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView showEditForm(@RequestParam(required = true) BigInteger id) {
        return new ModelAndView("add_form", "contact", personService.get(id));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteContact(@RequestParam(required = true) BigInteger id) {
        personService.remove(id,new BigInteger("0"));

        return "redirect:/persons";
    }


}
