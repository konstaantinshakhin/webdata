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
        ModelAndView modelAndView = new ModelAndView("listpersons");

        modelAndView.addObject("persons", personService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.GET)
    public ModelAndView showEditForm() {
        return new ModelAndView("editperson", "person", new Person());
    }

    @RequestMapping(value = "/editPerson", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person) {
        if(person.getId() == null) personService.add(person,new BigInteger("0"));
        else personService.update(person,new BigInteger("0"));

        return "redirect:/persons";
    }

    @RequestMapping(value = "/editPerson", method = RequestMethod.GET)
    public ModelAndView editPerson(@RequestParam(required = true) BigInteger id) {
        return new ModelAndView("editperson", "person", personService.get(id));
    }

    @RequestMapping(value = "/deletePerson", method = RequestMethod.GET)
    public String deletePerson(@RequestParam(required = true) BigInteger id) {
        personService.remove(personService.get(id),new BigInteger("0"));

        return "redirect:/persons";
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public ModelAndView history(@RequestParam(required = true) BigInteger id) {
        return new ModelAndView("history", "historyes", personService.getHistory(id));
    }
}
