package br.com.evasion.src.entity;

import br.com.evasion.src.enums.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
@Entity
@Table(name = "user_system")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_user")
    private BigInteger id;

    @Column(name = "des_user_name")
    private String userName;

    @Column(name = "des_user_password")
    private String userPassword;

    @Column(name = "des_user_email")
    private String userEmail;

    @Column(name = "des_user_type")
    private UserTypeEnum userType;

    @Column(name = "dat_user_creation")
    private LocalDateTime userDateCreation;

}
