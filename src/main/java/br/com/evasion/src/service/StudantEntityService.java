package br.com.evasion.src.service;

import br.com.evasion.src.dto.StudantDTO;
import br.com.evasion.src.entity.StudantEntity;
import br.com.evasion.src.enums.ErrorsEnum;
import br.com.evasion.src.exception.GeneralException;
import br.com.evasion.src.repository.StudantEntityRepository;
import br.com.evasion.src.utils.BuilderObjectsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudantEntityService {
    private final StudantEntityRepository studantEntityRepository;
    @Transactional(propagation = Propagation.REQUIRED)
    public void createOrUpdateStudant (StudantDTO dto) {

        Optional<StudantEntity> studantEntity =
                studantEntityRepository.findByIdStudantRegistration(dto.getIdStudantRegistration());

        if (studantEntity.isEmpty()) {
            studantEntityRepository.save(BuilderObjectsUtils.buildStudantEntity(dto)).getId();
        } else {
            studantEntity.get().setUserName(dto.getUserName());
            studantEntity.get().setUserEmail(dto.getUserEmail());
            studantEntity.get().setStudantCRA(dto.getStudantCRA());
            studantEntity.get().setStudantPeriod(dto.getStudantPeriod());
            studantEntity.get().setStudantGender(dto.getStudantGender());
            studantEntity.get().setStudantHaveJob(dto.getStudantHaveJob());
            studantEntity.get().setStudantHasSon(dto.getStudantHasSon());
            studantEntity.get().setStudantLiveAlone(dto.getStudantLiveAlone());
            studantEntity.get().setStudantNumAge(dto.getStudantNumAge());
            studantEntity.get().setStudantNumDisciplines(dto.getStudantNumDisciplines());
            studantEntity.get().setStudantWillEvade(dto.getStudantWillEvade());
            studantEntityRepository.save(studantEntity.get());
        }
    }

    public ArrayList<StudantDTO> findByStudantSample (Boolean isStudanteSample) {
        ArrayList<StudantEntity> listStudantEntity =
                studantEntityRepository.findByIsStudantSample(isStudanteSample);
        ArrayList<StudantDTO> listStudantDTO = new ArrayList<>();
        listStudantEntity.forEach(entity -> {
            listStudantDTO.add(BuilderObjectsUtils.buildStudantDTO(entity));
        });
        return listStudantDTO;
    }

    public ArrayList<StudantDTO> findByStudanteWillEvade () {
        ArrayList<StudantEntity> listStudantEntity =
                studantEntityRepository.findByStudantWillEvadeAndIsStudantSampleIsNullOrIsStudantSampleIsFalse(Boolean.TRUE);
        ArrayList<StudantDTO> listStudantDTO = new ArrayList<>();
        listStudantEntity.forEach(entity -> {
            listStudantDTO.add(BuilderObjectsUtils.buildStudantDTO(entity));
        });
        return listStudantDTO;
    }

    public void deleteStudant (String idStudantRegistration) {
        Optional<StudantEntity> studantEntity =
                studantEntityRepository.findByIdStudantRegistration(idStudantRegistration);
        if (studantEntity.isEmpty()) {
            throw new GeneralException(ErrorsEnum.STUDANT_NOT_EXIST);
        }
        studantEntityRepository
                .delete(studantEntity.get());
    }
}
