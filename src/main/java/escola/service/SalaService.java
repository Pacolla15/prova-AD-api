package escola.service;

import escola.dto.SalaRequest;
import escola.dto.SalaResponse;
import escola.exception.RegraNegocioException;
import escola.exception.SalaNaoEncontradaException;
import escola.model.Sala;
import escola.repository.SalaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalaService {

    private final SalaRepository repository;

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }

    // Converter entidade para resposta
    private SalaResponse converterParaResponse(Sala sala) {
        return new SalaResponse(
                sala.getId(),
                sala.getCodigo(),
                sala.getNome(),
                sala.getCapacidade(),
                sala.isReservada()
        );
    }

    // Cadastrar sala
    @Transactional
    public SalaResponse cadastrar(SalaRequest request) {

        if (repository.existsByCodigo(request.getCodigo())) {
            throw new RegraNegocioException(
                    "Já existe uma sala com esse código."
            );
        }

        Sala sala = new Sala(
                request.getCodigo(),
                request.getNome(),
                request.getCapacidade()
        );

        Sala salva = repository.save(sala);

        return converterParaResponse(salva);
    }

    // Listar todas as salas
    @Transactional(readOnly = true)
    public List<SalaResponse> listarTodas() {

        return repository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    // Buscar sala pelo ID
    @Transactional(readOnly = true)
    public SalaResponse buscarPorId(Long id) {

        Sala sala = buscarEntidade(id);

        return converterParaResponse(sala);
    }

    // Método auxiliar para localizar uma sala
    private Sala buscarEntidade(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new SalaNaoEncontradaException(
                                "Sala com ID " + id + " não encontrada."
                        )
                );
    }

    // Reservar sala
    @Transactional
    public SalaResponse reservar(Long id) {

        Sala sala = buscarEntidade(id);

        if (sala.isReservada()) {
            throw new RegraNegocioException(
                    "Esta sala já está reservada."
            );
        }

        sala.setReservada(true);

        Sala atualizada = repository.save(sala);

        return converterParaResponse(atualizada);
    }

    // Liberar sala
    @Transactional
    public SalaResponse liberar(Long id) {

        Sala sala = buscarEntidade(id);

        if (!sala.isReservada()) {
            throw new RegraNegocioException(
                    "Esta sala já está livre."
            );
        }

        sala.setReservada(false);

        Sala atualizada = repository.save(sala);

        return converterParaResponse(atualizada);
    }

    // Excluir sala
    @Transactional
    public void excluir(Long id) {

        Sala sala = buscarEntidade(id);

        if (sala.isReservada()) {
            throw new RegraNegocioException(
                    "Não é possível excluir uma sala reservada."
            );
        }

        repository.delete(sala);
    }
}