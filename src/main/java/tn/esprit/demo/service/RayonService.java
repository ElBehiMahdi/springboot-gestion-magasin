package tn.esprit.demo.service;

import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.entities.Rayon;
import tn.esprit.demo.entities.Stock;


import java.util.List;
import java.util.Optional;

public interface RayonService {
    Optional<Rayon> get(Long id);
    Rayon saveRayon(Rayon s);
    Rayon updateRayon(Rayon s);
    List<Rayon> getAllRayon();
    void deleteRayon(Long id);
}
