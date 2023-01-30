package br.com.evasion.src.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class StudantDTO {

    private BigInteger idStudant;

    private String userName;

    private String userEmail;

    private String idStudantRegistration;

    private Boolean studantPeriod;

    private Integer studantCRA;

    private Integer studantNumAge;

    private Boolean studantGender;

    private Integer studantNumDisciplines;

    private Boolean studantLiveAlone;

    private Boolean studantHasSon;

    private Boolean studantHaveJob;

    private Boolean studantWillEvade;
}
