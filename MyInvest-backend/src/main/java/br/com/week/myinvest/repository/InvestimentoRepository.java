package br.com.week.myinvest.repository;

import br.com.week.myinvest.domain.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {
}
