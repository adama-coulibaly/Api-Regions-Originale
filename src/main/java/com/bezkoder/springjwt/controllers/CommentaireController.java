package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.Commentaire;
import com.bezkoder.springjwt.repository.CommentaireRepository;
import com.bezkoder.springjwt.security.services.CommentaireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CommentaireController {

    private CommentaireService commentaireService;
    private final CommentaireRepository commentaireRepository;

    public CommentaireController(CommentaireService commentaireService,
                                 CommentaireRepository commentaireRepository) {
        this.commentaireService = commentaireService;
        this.commentaireRepository = commentaireRepository;
    }

    @PostMapping(path = "/commentaire")
    public String ajouterCommentaire(@RequestBody Commentaire commentaire){
         //   System.out.println("############################################: tttt " + commentaire + "##############################");
        return commentaireService.addNewCommentaire(commentaire);
    }

    @GetMapping(path = "/lister")
    public List<Commentaire> mesCommanteurs(){
        return commentaireService.toutLesCommentaires();
    }
}
