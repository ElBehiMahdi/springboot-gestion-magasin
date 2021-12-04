package tn.esprit.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Rayon;
import tn.esprit.demo.entities.Stock;
import tn.esprit.demo.repository.RayonRepository;
import tn.esprit.demo.repository.StockRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RayonServiceImpl implements RayonService {

    @Autowired
    private RayonRepository rayonRepository;

    @Override
    public Optional<Rayon> get(Long id) {

        return rayonRepository.findById(id);
    }

    @Override
    public Rayon saveRayon(Rayon r) {

        return rayonRepository.save(r);
    }

    @Override
    public Rayon updateRayon(Rayon r) {

        return rayonRepository.save(r);
    }

    @Override
    public List<Rayon> getAllRayon() {

        return rayonRepository.findAll();
    }

    @Override
    public void deleteRayon(Long id) {

        rayonRepository.deleteById(id);
    }
}
