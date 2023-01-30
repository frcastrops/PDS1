package br.com.evasion.src.service;

import br.com.evasion.src.dto.UserDTO;
import br.com.evasion.src.entity.UserEntity;
import br.com.evasion.src.repository.UserEntityRepository;
import br.com.evasion.src.utils.BuilderObjectsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserEntityService {

    private final UserEntityRepository userEntityRepository;
    public UserDTO findUserByUserEmailAndUserPassword(String userEmail, String userPassword) {
        return returnUserDTOByEntity(userEntityRepository.findUserByUserEmailAndUserPassword(userEmail, userPassword));
    }

    public UserDTO findByEmail(String userEmail) {
        return returnUserDTOByEntity(userEntityRepository.findUserByUserEmail(userEmail));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void createUser(UserDTO dto) {
        userEntityRepository.save(BuilderObjectsUtils.buildUserEntity(dto));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(String userEmail) {
        userEntityRepository.delete(BuilderObjectsUtils.buildUserEntity(findByEmail(userEmail)));
    }

    public ArrayList<UserDTO> findAllUser () {
        ArrayList<UserDTO> listUserDTO = new ArrayList<>();
        for (UserEntity userEntity : userEntityRepository.findAll()) {
            listUserDTO.add(BuilderObjectsUtils.buildUserDTO(userEntity));
        }
        return listUserDTO;
    }

    private UserDTO returnUserDTOByEntity(Optional<UserEntity> userEntity) {
        return userEntity.map(BuilderObjectsUtils::buildUserDTO).orElse(null);
    }
}



