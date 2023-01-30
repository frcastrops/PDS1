package br.com.evasion.src.service;

import br.com.evasion.src.dto.UserDTO;
import br.com.evasion.src.enums.ErrorsEnum;
import br.com.evasion.src.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidateService {

    private final UserEntityService userEntityService;
    public void userAlreadyExist (UserDTO dto) {
        UserDTO userDto = userEntityService.findByEmail(dto.getUserEmail());
        if (userDto != null)
            throw new GeneralException(ErrorsEnum.USER_ALREADY_EXIST);
    }

    public void userCreateValidation (UserDTO dto) {
        if (null == dto) {
            throw new GeneralException(ErrorsEnum.USER_CREATE_VALIDATION_ERROR);
        } else if (null == dto.getUserName()) {
            throw new GeneralException(ErrorsEnum.USER_CREATE_VALIDATION_ERROR);
        } else if (null == dto.getUserType()) {
            throw new GeneralException(ErrorsEnum.USER_CREATE_VALIDATION_ERROR);
        } else if (null == dto.getUserPassword()) {
            throw new GeneralException(ErrorsEnum.USER_CREATE_VALIDATION_ERROR);
        } else if (null == dto.getUserEmail()) {
            throw new GeneralException(ErrorsEnum.USER_CREATE_VALIDATION_ERROR);
        }

    }
}
