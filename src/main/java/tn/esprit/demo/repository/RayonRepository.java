package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.demo.entities.Rayon;

public interface RayonRepository extends JpaRepository<Rayon, Long> {
}
