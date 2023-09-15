package br.com.nicolas.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nicolas.exceptions.ResourceNotFoundException;
import br.com.nicolas.models.Pessoa;
import br.com.nicolas.repositories.PessoaRepository;

@Service
public class PessoaServices {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa buscaPorId(Long id) {
		return pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum recurso foi encontrado"));
	}
	
	public List<Pessoa> pegaTudo() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa cria(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa atualiza(Long id, Pessoa pessoa) {
		
		
		Pessoa entity = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum recurso foi encontrado"));
		
		entity.setPrimeiroNome(pessoa.getPrimeiroNome());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setGenero(pessoa.getGenero());
		
		return pessoaRepository.save(entity);
	}
	
	public void deleta(Long id) {
		
		Pessoa entity = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum recurso foi encontrado"));
		pessoaRepository.delete(entity);
	}
	
}
