package tn.esprit.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Rayon;
import tn.esprit.demo.repository.RayonRepository;

import java.util.List;

@Service
public class RayonServiceImpl implements RayonService {
    @Autowired
    private RayonRepository rayonRepository;

    @Override
    public List<Rayon> getAllRayon() {
        return null;
    }

    @Override
    public void saveStock(Rayon r) {

    }

    @Override
    public Rayon get(Long id) {
        return null;
    }

    @Override
    public void saveRayon(Rayon r) {

    }
}
