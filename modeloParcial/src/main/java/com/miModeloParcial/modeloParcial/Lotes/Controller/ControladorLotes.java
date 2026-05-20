package com.miModeloParcial.modeloParcial.Lotes.Controller;

import com.miModeloParcial.modeloParcial.Lotes.Dominio.DTO.LotesDTO;
import com.miModeloParcial.modeloParcial.Lotes.ServicioLotes.IServicioLotes;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/lotes")
public class ControladorLotes {

    private IServicioLotes servicioLotes;

    @GetMapping("/id/{id}")
    public ResponseEntity<LotesDTO> buscarPorId(@PathVariable Long id)
    {
        return ResponseEntity.ok(servicioLotes.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity <List<LotesDTO>>buscarTodos()
    {
        return ResponseEntity.ok(servicioLotes.buscarTodos());
    }


    @PostMapping
    public ResponseEntity<LotesDTO> guardar(@RequestBody @Valid LotesDTO lotesDTO)
    {
        return new ResponseEntity<>(servicioLotes.guardar(lotesDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LotesDTO> actualizar(@PathVariable Long id, @RequestBody @Valid LotesDTO lotesDTO)
    {
        return ResponseEntity.ok(servicioLotes.actualizar(id,lotesDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id)
    {
        servicioLotes.borrar(id);

        return ResponseEntity.noContent().build();
    }





}
