        package com.bezkoder.springjwt.security.services;


        import com.bezkoder.springjwt.Message.ReponseMessage;
        import com.bezkoder.springjwt.models.Pays;
        import com.bezkoder.springjwt.models.Regions;
        import com.bezkoder.springjwt.repository.PaysRepository;
        import com.bezkoder.springjwt.repository.RegionsRepository;
        import com.bezkoder.springjwt.repository.UserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;
        @Service
        public class RegionsService {
            @Autowired
            RegionsRepository regionsRepository;

        @Autowired
        PaysRepository paysRepository;
        Pays pays;
            private final UserRepository userRepository;

            //Controllers
        public RegionsService(RegionsRepository regionsRepository,
                              UserRepository userRepository)
        {
            this.regionsRepository = regionsRepository;
            this.userRepository = userRepository;
        }
//Ajouter des Regions
        public ReponseMessage ajouterRegions(Regions regions)
        {
           if(regionsRepository.findByNomregions(regions.getNomregions() ) == null){
               regionsRepository.save(regions);
               ReponseMessage message = new ReponseMessage("Région ajoutée avec succès",true);
               return message;
            }
            else {
                ReponseMessage message = new ReponseMessage("Regions existe déja",false);
                return message;
            }






        /*
            try {

                 regionsRepository.save(regions);
                 ReponseMessage message = new ReponseMessage("Région ajoutée avec succès",true);
                 return message;
            }
            catch (Exception e)
            {
                ReponseMessage message = new ReponseMessage("Regions existe déja",false);
                return message;
            }

         */


        }
//Afficher la liste des Regions
        public List<Regions> afficherRegions()
            {
                return regionsRepository.findAll();
            }

// Afficher une seule region
            public ReponseMessage afficherUneRegion(Long id_regions)
            {
                Optional<Regions> regions = this.regionsRepository.findById(id_regions);

                if (!regions.isPresent()) {
                    ReponseMessage message = new ReponseMessage("Cette région n'est pas trouvée !", false);
                    return message;
                }
                else {
                    Regions RG =  this.regionsRepository.findById(id_regions).get();
                    ReponseMessage message = new ReponseMessage(" Nom: "+RG.getNomregions()+" Pays: "+RG.getPays().getNompays()+" Activité "+RG.getActiviterregion()+" Code région: "+RG.getCoderegion()+" Langue: "+RG.getLanguemregion()+" Superficie: "+RG.getSuperficieregion(), true);
                    return message;
                }

            }
 //Modifier un pays
            public ReponseMessage modifierRegions(Regions regions, Long id_regions)
            {
                Optional<Regions> regionExistePays = this.regionsRepository.findById(id_regions);
                if (!regionExistePays.isPresent())
                {
                    ReponseMessage message = new ReponseMessage("Cette région n'est pas trouvée !", false);
                    return message;
                }
                else {
                    Regions regions1 = regionsRepository.findById(id_regions).get();
                    regions1.setActiviterregion(regions.getActiviterregion());
                    regions1.setLanguemregion(regions.getLanguemregion());
                    regions1.setSuperficieregion(regions.getSuperficieregion());
                    regions1.setCoderegion(regions.getCoderegion());
                    regions1.setNomregions(regions.getNomregions());
                    regions1.setPays(regions.getPays());
                     this.regionsRepository.save(regions1);
                    ReponseMessage message = new ReponseMessage("Région modifiée avec succès !", true);
                    return message;
                }

            }

//Supprimer une region
            public ReponseMessage supprimer(Long id_region)
            {
                Optional<Regions> regions = this.regionsRepository.findById(id_region);
                if (!regions.isPresent())
                {
                    ReponseMessage message = new ReponseMessage("Région non trouvée !", false);
                    return message;
                }
                else {
                    this.regionsRepository.delete(regions.get());
                    ReponseMessage message = new ReponseMessage("Région supprimé avec succès !", true);
                    return message;
                }

            }


            public Iterable<Object[]> mesRegions() {
                return this.regionsRepository.mesRegions();
            }

            public Iterable<Object[]> mesRegionsAvecPays()
            {
                return this.regionsRepository.mesRegionsAvecPays();
            }
/*
            public Regions Generale(Regions regions)
            {

                          return regionsRepository.save(regions);
            }

 */

        }
