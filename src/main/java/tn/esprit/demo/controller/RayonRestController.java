package tn.esprit.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Rayon;
import tn.esprit.demo.service.RayonService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "Rayon management")
@RequestMapping("/rayon")
public class RayonRestController {

    @Autowired
    RayonService rayonService;

    //http://localhost:8089/SpringMVC/rayon/retrieve-all-rayons
    @GetMapping("/retrieve-all-rayons")
    @ApiOperation(value = "Récupérer la liste des rayons")
    @ResponseBody
    public List<Rayon> getRayons() {
        List<Rayon> listRayons = rayonService.getAllRayon();
        return listRayons;
    }

    // http://localhost:8089/SpringMVC/rayon/retrieve-rayon/1
    @GetMapping("/retrieve-rayon/{Rayon-id}")
    @ApiOperation(value = "Récupérer un Rayon par id")
    @ResponseBody
    public Optional<Rayon> retrieveRayon(@PathVariable("Rayon-id") Long RayonId) {
        return rayonService.get(RayonId);
    }

    //http://localhost:8089/SpringMVC/rayon/add-rayon
    @PostMapping("/add-rayon")
    @ApiOperation(value = "Ajouter un Rayon")
    @ResponseBody
    public Rayon addRayon(@RequestBody Rayon s)
    {
        Rayon Rayon = rayonService.saveRayon(s);
        return Rayon;
    }

    //http://localhost:8089/SpringMVC/rayon/modify-rayon
    @PutMapping("/modify-rayon")
    @ApiOperation(value = "Modifier un Rayon")
    @ResponseBody
    public Rayon modifyRayon(@RequestBody Rayon Rayon) {
        return rayonService.updateRayon(Rayon);
    }
}
