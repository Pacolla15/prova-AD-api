package escola.controller;

import escola.dto.SalaRequest;
import escola.dto.SalaResponse;
import escola.service.SalaService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    // Cadastrar sala
    @PostMapping
    public ResponseEntity<SalaResponse> cadastrar(
            @Valid @RequestBody SalaRequest request) {

        SalaResponse sala = service.cadastrar(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(sala);
    }

    // Listar todas as salas
    @GetMapping
    public ResponseEntity<List<SalaResponse>> listarTodas() {

        return ResponseEntity.ok(service.listarTodas());
    }

    // Buscar sala pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<SalaResponse> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Reservar sala
    @PatchMapping("/{id}/reservar")
    public ResponseEntity<SalaResponse> reservar(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.reservar(id));
    }

    // Liberar sala
    @PatchMapping("/{id}/liberar")
    public ResponseEntity<SalaResponse> liberar(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.liberar(id));
    }

    // Excluir sala
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }
}