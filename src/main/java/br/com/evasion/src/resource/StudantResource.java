package br.com.evasion.src.resource;

import br.com.evasion.src.request.CreateStudantRequest;
import br.com.evasion.src.response.FindStudantReportResponse;
import br.com.evasion.src.response.FindUserResponse;
import br.com.evasion.src.service.StudantService;
import br.com.evasion.src.utils.BuilderObjectsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class StudantResource {

    private final StudantService studantService;

    @PostMapping("createOrUpdate/studant")
    public void createOrUpdateStudant(@RequestBody final CreateStudantRequest createStudantRequest) throws Exception{
        studantService.createOrUpdateStudant(BuilderObjectsUtils.buildStudantDTO(createStudantRequest));
    }

    @PostMapping("delete/studant")
    public void deleteStudant(@RequestBody final String idStudantRegistration) throws Exception{
        studantService.deleteStudant(idStudantRegistration);
    }

    @RequestMapping(value = "report/studant", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<FindStudantReportResponse> findStudantReport() {
        return studantService.findByStudanteWillEvade();
    }
}

