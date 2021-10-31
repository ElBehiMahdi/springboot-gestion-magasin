package tn.esprit.demo.service;

import tn.esprit.demo.entities.Fournisseur;
import tn.esprit.demo.entities.Rayon;

import java.util.List;

public interface RayonService {
    public abstract Rayon getRayonById(Long id);
    public abstract void saveRayon(Rayon r);
    public abstract void updateRayon(Rayon r);
    public abstract void deleteRayon(Long id);
    public abstract List<Rayon> getAllRayon();
}
