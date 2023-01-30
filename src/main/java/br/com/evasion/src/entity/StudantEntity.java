package br.com.evasion.src.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "studant")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_studant")
    private BigInteger id;

    @Column(name = "des_studant_name")
    private String userName;

    @Column(name = "des_studant_email")
    private String userEmail;

    @Column(name = "num_studant_registration")
    private String idStudantRegistration;

    @Column(name = "flg_studant_sample")
    private Boolean isStudantSample;
    // 1 - Integral / 0 - Noturno
    @Column(name = "flg_studant_period")
    private Boolean studantPeriod;

    @Column(name = "num_studant_cra")
    private Integer studantCRA;

    @Column(name = "num_studant_age")
    private Integer studantNumAge;

    // 1 - Masculino / 0 - Feminino
    @Column(name = "flg_studant_gender")
    private Boolean studantGender;

    @Column(name = "num_studant_disciplines")
    private Integer studantNumDisciplines;

    // 1 - Mora sozinho / 0 - Não mora
    @Column(name = "flg_studant_live_alone")
    private Boolean studantLiveAlone;

    // 1 - Tem filho(s) / 0 - Não tem
    @Column(name = "flg_studant_has_son")
    private Boolean studantHasSon;

    // 1 - Tem emprego / 0 - Não tem
    @Column(name = "flg_studant_have_job")
    private Boolean studantHaveJob;

    @Column(name = "flg_studant_will_evade")
    private Boolean studantWillEvade;
}
