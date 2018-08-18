package com.trailer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trailer.model.Trailer;
import com.trailer.service.TrailerService;


@Controller
public class TrailerUploadController {

    private TrailerService trailerService;

    @Autowired(required = true)
    public TrailerService getTrailerService() {
        return trailerService;
    }

    public void setTrailerService(TrailerService trailerService) {
        this.trailerService = trailerService;
    }

    @RequestMapping(value = "/listTrailers", method = RequestMethod.GET)
    public String listTrailers(Model model) {
        // model.addAttribute("trailer", new Trailer());
        model.addAttribute("listTrailers", this.trailerService.listTrailers());
        return "trailer_list";
    }

    @RequestMapping(value = "/trailer-upload", method = RequestMethod.POST)
    public String trialerUpload(@ModelAttribute("trailer") Trailer trailer) {
        System.out.println("In Controller");
        if (trailer.getTrailerVid().trim().equals("")) {
            // new person, add it
            this.trailerService.addTrailer(trailer);
        } else {
            // existing person, call update
            this.trailerService.updateTrailer(trailer);
        }

        return "redirect:/listTrailers";
    }

    @RequestMapping("/remove/{vid}")
    public String removePerson(@PathVariable("vid") long vid) {

        this.trailerService.removeTrailer(vid);
        ;
        return "redirect:/listTrailers";
    }

    @RequestMapping("/edit/{vid}")
    public String editPerson(@PathVariable("vid") String vid, Model model) {
        model.addAttribute("trailer", this.trailerService.getTrailerByVid(vid));
        model.addAttribute("listTrailers", this.trailerService.listTrailers());
        return "listTrailers";
    }

    @RequestMapping(value = "/trailer", method = RequestMethod.GET)
    public String adminPage() {
        return "trailer-upload";
    }

}
