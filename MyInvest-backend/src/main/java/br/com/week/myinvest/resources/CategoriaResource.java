package br.com.week.myinvest.resources;

import br.com.week.myinvest.domain.Categoria;
import br.com.week.myinvest.dto.CategoriaDto;
import br.com.week.myinvest.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public List<CategoriaDto> listarTodos() {
        return CategoriaDto.converter(repository.findAll());
    }

    @GetMapping("/{codigo}")
    public Categoria buscarPeloCodigo(@PathVariable Long codigo){
        return repository.findById(codigo).orElse(null);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable Long codigo){
        repository.deleteById(codigo);
    }

    @PostMapping
    public Categoria cadastrar(@RequestBody Categoria categoria) {
        return repository.save(categoria);
    }
}
