package pl.edu.wszib.jproject;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class FixRepositoryCustomImpl implements FixRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveFix(Fix fix) {
        entityManager.merge(fix);
    }
}
