package br.com.nicolas.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nicolas.data.vo.v1.PessoaVO;
import br.com.nicolas.exceptions.ResourceNotFoundException;
import br.com.nicolas.mapper.DozerMapper;
import br.com.nicolas.models.Pessoa;
import br.com.nicolas.repositories.PessoaRepository;

@Service
public class PessoaServices {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public PessoaVO buscaPorId(Long id) {
		Pessoa entity = buscaPorIdEntity(id);
		return DozerMapper.parseObjeto(entity, PessoaVO.class);
	}
	
	public List<PessoaVO> pegaTudo() {
		return DozerMapper.parseListaObjetos(pessoaRepository.findAll(), PessoaVO.class);
	}
	
	public PessoaVO cria(PessoaVO pessoa) {
		Pessoa entity = DozerMapper.parseObjeto(pessoa, Pessoa.class);
		PessoaVO vo = DozerMapper.parseObjeto(pessoaRepository.save(entity), PessoaVO.class);
		return vo;
	}
	
	public PessoaVO atualiza(Long id, PessoaVO pessoa) {
		
		Pessoa entity = buscaPorIdEntity(id);
		
		entity.setPrimeiroNome(pessoa.getPrimeiroNome());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setGenero(pessoa.getGenero());
		
		PessoaVO vo = DozerMapper.parseObjeto(pessoaRepository.save(entity), PessoaVO.class);
		return vo;
	}
	
	public void deleta(Long id) {
		
		Pessoa entity = buscaPorIdEntity(id);
		pessoaRepository.delete(entity);
	}
	
	private Pessoa buscaPorIdEntity(Long id) {
		Pessoa entity = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum recurso foi encontrado"));
		return entity;
	}
	
}
