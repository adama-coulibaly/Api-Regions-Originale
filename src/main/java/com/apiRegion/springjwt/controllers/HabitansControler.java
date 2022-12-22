package com.apiRegion.springjwt.controllers;


import com.apiRegion.springjwt.models.Regions;
import com.apiRegion.springjwt.security.services.HabitantsService;
import com.apiRegion.springjwt.models.Habitants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/projet/odk/Habitants",name ="Habitants")
public class HabitansControler {

    @Autowired
    private HabitantsService habitantsService;

    @Autowired
    public HabitansControler(HabitantsService habitantsService)
    {
        this.habitantsService=habitantsService;
    }


    @PostMapping(path = "/creer/{id_regions}")
    public Habitants ajouterHabitant(@RequestBody Habitants habitants,@PathVariable("id_regions") Regions id_regions)
    {
        Regions rd = new Regions();
        habitants.setRegions(id_regions);
        return this.habitantsService.ajouterHabitant(habitants);
    }
    @GetMapping(path ="/liste", name = "list")

    public List<Habitants> list()
    {
        return this.habitantsService.maListe();
    }


    @PutMapping(path ="/modifier/{id_habitans}", name = "modifier")
    public Habitants modifierHabitant(@RequestBody Habitants habitants, @PathVariable Long id_habitants)
    {
        return habitantsService.modifierHabitant(habitants, id_habitants);
    }


    @DeleteMapping(path ="/supprimer/{id_habitants}", name = "supprimer")
    public void supprimerHabitant(@PathVariable Long id_habitants)
    {
        this.habitantsService.supprimerHabitant(id_habitants);
    }

  /*  @GetMapping(path ="/listerParRegion/{id_regions}", name = "lister")
    public List<Habitants> trouverParHabitants(@PathVariable("id_regions") Long id_regions) {
        return habitantsService.trouverParHabitants(id_regions);
    }

   */




}
