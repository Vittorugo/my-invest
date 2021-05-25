package br.com.week.myinvest.resources;

import br.com.week.myinvest.domain.Investimento;
import br.com.week.myinvest.repository.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoResource {

    @Autowired
    private InvestimentoRepository repository;

    @GetMapping
    public List<Investimento> listarTodos(){
        return repository.findAll();
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
    public Investimento cadastrar(@RequestBody Investimento investimento) {
        return repository.save(investimento);
    }
}
