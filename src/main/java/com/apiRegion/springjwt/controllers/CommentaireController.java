package com.apiRegion.springjwt.controllers;


import com.apiRegion.springjwt.models.Commentaire;
import com.apiRegion.springjwt.models.Regions;
import com.apiRegion.springjwt.models.User;
import com.apiRegion.springjwt.repository.CommentaireRepository;
import com.apiRegion.springjwt.repository.RegionsRepository;
import com.apiRegion.springjwt.repository.UserRepository;
import com.apiRegion.springjwt.security.services.CommentaireService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/projet/odk/Commentaire",name ="Commentaire")
public class CommentaireController {

    private CommentaireService commentaireService;
    private final CommentaireRepository commentaireRepository;
    private final UserRepository userRepository;
    private final RegionsRepository regionsRepository;

    public CommentaireController(CommentaireService commentaireService,
                                 CommentaireRepository commentaireRepository,
                                 UserRepository userRepository,
                                 RegionsRepository regionsRepository) {
        this.commentaireService = commentaireService;
        this.commentaireRepository = commentaireRepository;
        this.userRepository = userRepository;
        this.regionsRepository = regionsRepository;
    }


    @PostMapping(path = "/creer/{id_user}/{id_region}")

    public String ajouterCommentaire(@RequestBody Commentaire commentaire, @PathVariable("id_user") Long id_user, @PathVariable("id_region") Long id_region){
        System.out.println("Je suis le commentaire "+commentaire);

        User user =  userRepository.findById(id_user).get();
        Regions regions = regionsRepository.findById(id_region).get();

        commentaire.setUser(user);
        commentaire.setRegions(regions);

        return commentaireService.addNewCommentaire(commentaire);
    }
/*
    @PostMapping(path = "/creer")

    public String ajouterCommentaire(@RequestBody Commentaire commentaire){
        System.out.println("Je suis le commentaire "+commentaire);
        return commentaireService.addNewCommentaire(commentaire);
    }
      /**/
/*
    @PostMapping(path = "/creer")
    public String ajouterCommentaire(@RequestParam(value = "commentaire") String commentaireVenant) throws  JsonProcessingException {

        Commentaire commentaireRecuperer = new JsonMapper().readValue(commentaireVenant, Commentaire.class);

        return commentaireService.addNewCommentaire(commentaireRecuperer);
    }



    @PostMapping("/ajoutcommentaire")
    public String ajoutCommentaire(@RequestParam(value = "data") String comm){
        Commentaire commentaires = null;

        try {
            commentaires = new JsonMapper().readValue(comm, Commentaire.class);
            System.out.println(commentaires);
            // utilisateurs = new JsonMapper().readValue(userVenant, Utilisateur.class);
        } catch (Exception e) {
            System.out.println("erreru lors de l'ajout de commentaires"+commentaires);
        }
        try {
            commentaireService.addNewCommentaire(commentaires);
        }
        catch (Exception e){
            System.out.println("erreru lors de l'ajout de commentaires"+commentaires);
        }

        return  "Operation effectuer avec succes";
    }
*/

    @GetMapping(path = "/lister")
    public List<Commentaire> mesCommanteurs(){
        return commentaireService.toutLesCommentaires();
    }


    @GetMapping(path = "/RegionsCommentaire/{id_regions}")
    public List<Commentaire> LesCommentaireDuneRegion(@PathVariable("id_regions") Long id_region){
        return commentaireService.LesCommentaireDuneRegion(id_region);
    }
}
