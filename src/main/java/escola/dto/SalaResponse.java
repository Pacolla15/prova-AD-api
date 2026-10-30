package escola.dto;

public class SalaResponse {

    private Long id;
    private String codigo;
    private String nome;
    private Integer capacidade;
    private boolean reservada;

    public SalaResponse(Long id, String codigo, String nome,
                        Integer capacidade, boolean reservada) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.capacidade = capacidade;
        this.reservada = reservada;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public boolean isReservada() {
        return reservada;
    }
}