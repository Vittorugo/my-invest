package br.com.week.myinvest.resources;

import br.com.week.myinvest.domain.Categoria;
import br.com.week.myinvest.domain.Investimento;
import br.com.week.myinvest.dto.InvestimentoDto;
import br.com.week.myinvest.repository.CategoriaRepository;
import br.com.week.myinvest.repository.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investimentos")
@CrossOrigin(origins = "http://localhost:3000")
public class InvestimentoResource {

    @Autowired
    private InvestimentoRepository repository;

    @Autowired
    private CategoriaRepository repositoryCategoria;

    @GetMapping
    public List<InvestimentoDto> listarTodos(){
        return InvestimentoDto.converter(repository.findAll());
    }

    @GetMapping("/{codigo}")
    public Investimento buscarPeloCodigo(@PathVariable Long codigo){
        return repository.findById(codigo).orElse(null);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable Long codigo){
        repository.deleteById(codigo);
    }

    @PostMapping
    public InvestimentoDto cadastrar(@RequestBody Investimento investimento) {
        Categoria categoria = repositoryCategoria.findById(investimento.categoria.getCodigo()).orElse(null);
        investimento.setCategoria(categoria);
        repository.save(investimento);
        return InvestimentoDto.converterCadastro(investimento);
    }
}
