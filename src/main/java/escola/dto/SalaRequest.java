package escola.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class SalaRequest {

    @NotBlank(message = "O código é obrigatório")
    private String codigo;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotNull(message = "A capacidade é obrigatória")
    @Positive(message = "A capacidade deve ser maior que zero")
    private Integer capacidade;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
}