package br.com.zup.catalisa.APIViaCep.repository;

import br.com.zup.catalisa.APIViaCep.model.CepModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepRepository extends JpaRepository<CepModel, Long> {
}
