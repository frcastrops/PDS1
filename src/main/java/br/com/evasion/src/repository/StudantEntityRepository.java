package br.com.evasion.src.repository;

import br.com.evasion.src.entity.StudantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface StudantEntityRepository extends JpaRepository<StudantEntity, BigInteger> {

    ArrayList<StudantEntity> findByIsStudantSample(Boolean isStudantSample);

    Optional<StudantEntity> findByIdStudantRegistration(String idStudantRegistration);

    ArrayList<StudantEntity> findByStudantWillEvadeAndIsStudantSampleIsNullOrIsStudantSampleIsFalse(Boolean isStudantWillEvade);

}