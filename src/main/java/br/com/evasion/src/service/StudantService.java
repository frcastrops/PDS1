package br.com.evasion.src.service;

import br.com.evasion.src.dto.StudantDTO;
import br.com.evasion.src.entity.StudantEntity;
import br.com.evasion.src.enums.ErrorsEnum;
import br.com.evasion.src.exception.GeneralException;
import br.com.evasion.src.response.FindStudantReportResponse;
import br.com.evasion.src.response.FindUserResponse;
import br.com.evasion.src.utils.BuilderObjectsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class StudantService {

    private final StudantEntityService studantEntityService;

    private final KNNService knnService;
    public void createOrUpdateStudant (StudantDTO dto) throws Exception{
        processKNNonUserCreated(dto);
        studantEntityService.createOrUpdateStudant(dto);
    }

    public void deleteStudant (String idStudantRegistration) throws Exception{
        studantEntityService.deleteStudant(idStudantRegistration);
    }

    private void processKNNonUserCreated (StudantDTO dto) throws Exception{
        if(dto.getStudantWillEvade() == null) {
            knnService.processKNNonUserCreated(dto);
        }
    }

    public ArrayList<FindStudantReportResponse> findByStudanteWillEvade () {
        try {
            ArrayList<FindStudantReportResponse> listFindStudantReportResponse = new ArrayList<>();
            studantEntityService.findByStudanteWillEvade().forEach(dto -> {
                listFindStudantReportResponse.add(BuilderObjectsUtils.buildFindStudantReportResponse(dto));
            });
            return listFindStudantReportResponse;
        } catch (RuntimeException e){
            throw new GeneralException(ErrorsEnum.USER_NOT_EXIST);
        }
    }

}
