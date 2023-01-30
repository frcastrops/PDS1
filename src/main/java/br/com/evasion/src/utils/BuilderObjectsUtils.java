package br.com.evasion.src.utils;

import br.com.evasion.src.dto.StudantDTO;
import br.com.evasion.src.entity.StudantEntity;
import br.com.evasion.src.entity.UserEntity;
import br.com.evasion.src.dto.UserDTO;
import br.com.evasion.src.request.CreateStudantRequest;
import br.com.evasion.src.request.CreateUserRequest;
import br.com.evasion.src.response.FindStudantReportResponse;
import br.com.evasion.src.response.FindUserResponse;

import java.time.LocalDateTime;

public class BuilderObjectsUtils {

    public static UserDTO buildUserDTO (UserEntity userEntity) {
        return UserDTO.builder()
                .idUser(userEntity.getId())
                .userName(userEntity.getUserName())
                .userPassword(userEntity.getUserPassword())
                .userDateCreation(userEntity.getUserDateCreation())
                .userEmail(userEntity.getUserEmail())
                .userType(userEntity.getUserType())
                .build();
    }

    public static UserDTO buildUserDTO (CreateUserRequest createUserRequest) {
        return UserDTO.builder()
                .userName(createUserRequest.getUserName())
                .userPassword(createUserRequest.getUserPassword())
                .userDateCreation(LocalDateTime.now())
                .userEmail(createUserRequest.getUserEmail())
                .userType(createUserRequest.getUserType())
                .build();
    }

    public static UserEntity buildUserEntity (UserDTO dto) {
        return UserEntity.builder()
                .id(dto.getIdUser())
                .userName(dto.getUserName())
                .userPassword(dto.getUserPassword())
                .userDateCreation(dto.getUserDateCreation())
                .userEmail(dto.getUserEmail())
                .userType(dto.getUserType())
                .build();
    }

    public static StudantEntity buildStudantEntity (StudantDTO dto) {
        return StudantEntity.builder()
                .id(dto.getIdStudant())
                .userName(dto.getUserName())
                .userEmail(dto.getUserEmail())
                .idStudantRegistration(dto.getIdStudantRegistration())
                .studantPeriod(dto.getStudantPeriod())
                .studantCRA(dto.getStudantCRA())
                .studantNumAge(dto.getStudantNumAge())
                .studantGender(dto.getStudantGender())
                .studantNumDisciplines(dto.getStudantNumDisciplines())
                .studantLiveAlone(dto.getStudantLiveAlone())
                .studantHasSon(dto.getStudantHasSon())
                .studantHaveJob(dto.getStudantHaveJob())
                .studantWillEvade(dto.getStudantWillEvade())
                .build();
    }

    public static StudantDTO buildStudantDTO (CreateStudantRequest dto) {
        return StudantDTO.builder()
                .userName(dto.getUserName())
                .userEmail(dto.getUserEmail())
                .idStudantRegistration(dto.getIdStudantRegistration())
                .studantPeriod(dto.getStudantPeriod())
                .studantCRA(dto.getStudantCRA())
                .studantNumAge(dto.getStudantNumAge())
                .studantGender(dto.getStudantGender())
                .studantNumDisciplines(dto.getStudantNumDisciplines())
                .studantLiveAlone(dto.getStudantLiveAlone())
                .studantHasSon(dto.getStudantHasSon())
                .studantHaveJob(dto.getStudantHaveJob())
                .studantWillEvade(dto.getStudantWillEvade())
                .build();
    }

    public static StudantDTO buildStudantDTO (StudantEntity studantEntity) {
        return StudantDTO.builder()
                .idStudant(studantEntity.getId())
                .userName(studantEntity.getUserName())
                .userEmail(studantEntity.getUserEmail())
                .idStudantRegistration(studantEntity.getIdStudantRegistration())
                .studantPeriod(studantEntity.getStudantPeriod())
                .studantCRA(studantEntity.getStudantCRA())
                .studantGender(studantEntity.getStudantGender())
                .studantHaveJob(studantEntity.getStudantHaveJob())
                .studantHasSon(studantEntity.getStudantHasSon())
                .studantLiveAlone(studantEntity.getStudantLiveAlone())
                .studantNumAge(studantEntity.getStudantNumAge())
                .studantNumDisciplines(studantEntity.getStudantNumDisciplines())
                .studantWillEvade(studantEntity.getStudantWillEvade())
                .build();
    }

    public static FindUserResponse buildFindUserResponse (UserDTO dto) {
        return FindUserResponse.builder()
                .nome(dto.getUserName())
                .tipoUsuario(dto.getUserType())
                .dataCriacao(dto.getUserDateCreation().toString())
                .status("Ativo")
                .build();
    }

    public static FindStudantReportResponse buildFindStudantReportResponse(StudantDTO dto) {
        return FindStudantReportResponse.builder()
                .email(dto.getUserEmail())
                .matricula(dto.getIdStudantRegistration())
                .nome(dto.getUserName())
                .situacao(dto.getStudantWillEvade() == Boolean.TRUE ? "Provável Evasão" : "")
                .build();
    }

}
