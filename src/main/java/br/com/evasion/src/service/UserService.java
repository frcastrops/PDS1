package br.com.evasion.src.service;

import br.com.evasion.src.dto.UserDTO;
import br.com.evasion.src.enums.ErrorsEnum;
import br.com.evasion.src.exception.GeneralException;
import br.com.evasion.src.response.FindUserResponse;
import br.com.evasion.src.utils.BuilderObjectsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class UserService {

    private final UserEntityService userEntityService;

    private final UserValidateService userValidateService;
    public String authUser (String userEmail, String userPassword) {
        try {
            UserDTO userDTO = userEntityService.findUserByUserEmailAndUserPassword(userEmail, userPassword);
            return userDTO.getUserName();
        } catch (RuntimeException e){
            throw new GeneralException(ErrorsEnum.USER_OR_PASS_ERROR);
        }
    }

    public UserDTO createUser (UserDTO dto) {
        try {
            userValidateService.userCreateValidation(dto);
            userValidateService.userAlreadyExist(dto);
            userEntityService.createUser(dto);
            return dto;
        } catch (RuntimeException e){
            throw e;
        }
    }

    public void deleteUser (String userEmail) {
        try {
            userEntityService.deleteUser(userEmail);
        } catch (RuntimeException e){
            throw new GeneralException(ErrorsEnum.USER_NOT_EXIST);
        }
    }

    public ArrayList<FindUserResponse> findAllUsers () {
        try {
            ArrayList<FindUserResponse> listFindUserResponse = new ArrayList<>();
            userEntityService.findAllUser().forEach(dto -> {
                listFindUserResponse.add(BuilderObjectsUtils.buildFindUserResponse(dto));
            });
            return listFindUserResponse;
        } catch (RuntimeException e){
            throw new GeneralException(ErrorsEnum.USER_NOT_EXIST);
        }
    }

}
