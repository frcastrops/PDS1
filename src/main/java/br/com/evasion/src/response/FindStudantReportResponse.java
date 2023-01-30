package br.com.evasion.src.response;


import br.com.evasion.src.enums.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FindStudantReportResponse {

    private String nome;

    private String matricula;

    private String email;

    private String situacao;

}
