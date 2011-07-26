package com.personnelmanager.controller;

import com.personnelmanager.domain.db.Person;
import com.personnelmanager.service.PersonnelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


/**
 * Controller for personnel, the matching of the url is done after personnelManager.
 * User: MikeChen
 * Date: Nov 24, 2010
 * Time: 5:39:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class PersonnelController {
    Logger logger = Logger.getLogger(PersonnelController.class);

//    @Autowired
//    private Validator validator;

    @Autowired
    private PersonnelService service;

    public PersonnelService getService() {
        return service;
    }

    public void setService(PersonnelService service) {
        this.service = service;
    }

//    public Validator getValidator() {
//        return validator;
//    }
//
//    public void setValidator(Validator validator) {
//        this.validator = validator;
//    }

    /**
     * For every request for this controller, this will
     * create a person instance for the form.
     */
    @ModelAttribute
    public Person newRequest(@RequestParam(required=false) Long id) {
        System.out.println("Id is " + id);
        return (id != null ? service.getPerson(id) : new Person());
    }

    @RequestMapping(value="/welcome.htm")
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value="/addPerson.htm", method = RequestMethod.GET)
    public String addPerson(Model model) {
        return "addPerson";
    }

    @RequestMapping(value="/savePerson.htm", method = RequestMethod.POST)
    public String savePerson(@Valid Person person, BindingResult result) {
        Person personToBeSaved = null;
        if (result.hasErrors()) {
            return "addPerson";
        }
        if (person.getPersonId() != null) {
            personToBeSaved = service.getPerson(person.getPersonId());
            updatePerson(personToBeSaved, person);
        } else {
            personToBeSaved = person;
        }

        service.save(personToBeSaved);
        return "welcome";
    }

    private void updatePerson(Person personToBeSaved, Person person) {
        personToBeSaved.setSalutation(person.getSalutation());
        personToBeSaved.setFirstName(person.getFirstName());
        personToBeSaved.setMiddleName(person.getMiddleName());
        personToBeSaved.setLastName(person.getLastName());
        personToBeSaved.setDob(person.getDob());
        personToBeSaved.setRole(person.getRole());

    }

    @RequestMapping(value="/searchPerson.htm", method = RequestMethod.GET)
    public String searchPerson() {
        return "searchPerson";
    }

    @RequestMapping(value="/searchPerson.htm", method = RequestMethod.POST)
    public String showSearchPerson(@ModelAttribute Person criteria, Model model) {
        List searchResult =  service.findPerson(criteria);
        model.addAttribute("searchResult", searchResult);
        return "searchPersonResult";
    }

    @RequestMapping(value="/editPerson.htm", method = RequestMethod.GET)
    public String editPerson() {
        return "addPerson";
    }


//
//    /**
//     * <p>Person form request.</p>
//     *
//     * <p>Expected HTTP GET and request '/person/form'.</p>
//     */
//    @RequestMapping(value="/person", method= RequestMethod.GET)
//    public void form(Model model) {
//        model.addAttribute("person", newRequest(null));
//    }
//
//    /**
//     * <p>Saves a person.</p>
//     *
//     * <p>Expected HTTP POST and request '/person/form'.</p>
//     */
//    @RequestMapping(value="/person", method=RequestMethod.POST)
//    public void form(Person person, Model model) {
//        Person result = (Person) service.save(person);
//
//        // set id from create
//        if (person.getPersonId() == null) {
//            person.setPersonId(result.getPersonId());
//        }
//
//        model.addAttribute("statusMessageKey", "person.form.msg.success");
//    }
//
//    /**
//     * <p>Deletes a person.</p>
//     *
//     * <p>Expected HTTP POST and request '/person/delete'.</p>
//     */
//    @RequestMapping(value="/person/delete", method=RequestMethod.POST)
//    public String delete(Person person) {
//        personDao.delete(person);
//
//        return SEARCH_VIEW_KEY;
//    }
//
//    /**
//     * <p>Searches for all persons and returns them in a
//     * <code>Collection</code>.</p>
//     *
//     * <p>Expected HTTP GET and request '/person/search'.</p>
//     */
//    @RequestMapping(value="/person/search", method=RequestMethod.GET)
//    public @ModelAttribute(SEARCH_MODEL_KEY) Collection<Person> search() {
//        return personDao.findPersons();
//    }

}
