package com.miModeloParcial.modeloParcial.Reactivos.Controller;

import com.miModeloParcial.modeloParcial.Reactivos.Dominio.DTO.ReactivoDTO;
import com.miModeloParcial.modeloParcial.Reactivos.Servicio.IServicioReactivos;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reactivos")
public class ControladorReactivos {


    private final IServicioReactivos servicioReactivos;

    @GetMapping
    public ResponseEntity<List<ReactivoDTO>> buscarTodos()
    {
        return ResponseEntity.ok(servicioReactivos.buscarTodos());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ReactivoDTO> buscarPorId(@PathVariable Long id)
    {
        return ResponseEntity.ok(servicioReactivos.buscarPorId(id));
    }

    @GetMapping("/nombre/{name}")
    public ResponseEntity<List<ReactivoDTO>> buscarPorNombre(@PathVariable String name)
    {
        return ResponseEntity.ok(servicioReactivos.buscarPorNombre(name));
    }

    @GetMapping("/nivel/{nivelPeligro}")
    public ResponseEntity<List<ReactivoDTO>> buscarPorNivelPeligro(@PathVariable Long nivelPeligro)
    {
        return ResponseEntity.ok(servicioReactivos.buscarPorNivelPeligro(nivelPeligro));
    }

    @GetMapping("/procursor/{esProcursorQuimico}") //“en esta parte de la URL voy a recibir un valor dinámico y guardarlo en la variable esProcursorQuimico”.
    // Por ejemplo:/api/reactivos/precursor/true
    public ResponseEntity<List<ReactivoDTO>> buscarPorProcursor(@PathVariable boolean esProcursorQuimico)
    {
        return ResponseEntity.ok(servicioReactivos.buscarPorProcursorQuimico(esProcursorQuimico));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ReactivoDTO> actualizar (@PathVariable Long id, @RequestBody @Valid ReactivoDTO reactivoDTO)
    {
        return ResponseEntity.ok(servicioReactivos.actualizar(id,reactivoDTO));
    }

    @PostMapping
    public ResponseEntity<ReactivoDTO> guardar (@RequestBody @Valid ReactivoDTO reactivoDTO)
    {
        return new ResponseEntity<>(servicioReactivos.guardar(reactivoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar (@PathVariable Long id)
    {
        servicioReactivos.borrar(id);
        return ResponseEntity.noContent().build();
    }




















}













