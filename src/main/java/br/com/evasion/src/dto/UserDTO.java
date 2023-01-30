package br.com.evasion.src.dto;

import br.com.evasion.src.enums.UserTypeEnum;

import java.math.BigInteger;
import java.time.LocalDateTime;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDTO {

    private BigInteger idUser;

    private String userName;

    private String userPassword;

    private String userEmail;

    private UserTypeEnum userType;

    private LocalDateTime userDateCreation;
}
