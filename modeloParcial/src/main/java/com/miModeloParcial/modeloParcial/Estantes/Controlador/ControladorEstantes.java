package com.miModeloParcial.modeloParcial.Estantes.Controlador;

import com.miModeloParcial.modeloParcial.Estantes.Dominio.DTO.EstanteDTO;
import com.miModeloParcial.modeloParcial.Estantes.Servicio.IServicioEstantes;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/estantes")
public class ControladorEstantes {

    private final IServicioEstantes servicioEstantes;

    @GetMapping("/id/{id}")
    public ResponseEntity<EstanteDTO> buscarPorId (@PathVariable Long id)
    {
        return ResponseEntity.ok(servicioEstantes.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<EstanteDTO>> buscarTodos()
    {
        return ResponseEntity.ok(servicioEstantes.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<EstanteDTO> guardar (@RequestBody @Valid EstanteDTO estanteDTO)
    {
        return new ResponseEntity<>(servicioEstantes.guardar(estanteDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstanteDTO> actualizar (@PathVariable Long id, @RequestBody @Valid EstanteDTO estanteDTO)
    {
        return ResponseEntity.ok(servicioEstantes.actualizar(id,estanteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id)
    {
        servicioEstantes.borrar(id);

        return ResponseEntity.noContent().build();
    }



}
