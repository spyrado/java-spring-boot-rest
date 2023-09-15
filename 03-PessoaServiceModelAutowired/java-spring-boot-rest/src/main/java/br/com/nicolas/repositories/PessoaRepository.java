package br.com.nicolas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nicolas.models.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{}

