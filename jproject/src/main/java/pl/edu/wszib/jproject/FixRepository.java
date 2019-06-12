package pl.edu.wszib.jproject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FixRepository extends JpaRepository<Fix, Long>, FixRepositoryCustom {
    List<Fix> findAllById(Fix id);
}
