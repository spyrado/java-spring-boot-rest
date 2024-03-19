package br.com.nicolas.services;
import java.util.List;

import br.com.nicolas.controllers.PessoaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.nicolas.data.vo.v1.PessoaVO;
import br.com.nicolas.data.vo.v2.PessoaVOV2;
import br.com.nicolas.exceptions.ResourceNotFoundException;
import br.com.nicolas.mapper.DozerMapper;
import br.com.nicolas.mapper.custom.PessoaMapper;
import br.com.nicolas.models.Pessoa;
import br.com.nicolas.repositories.PessoaRepository;

@Service
public class PessoaServices {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaMapper pessoaMapper;
	
	public PessoaVO buscaPorId(Long id) {
		Pessoa entity = buscaPorIdEntity(id);
		PessoaVO vo = DozerMapper.parseObjeto(entity, PessoaVO.class);
		vo.add(linkTo(methodOn(PessoaController.class).buscaPorId(id)).withSelfRel());
		return vo;
	}
	
	public List<PessoaVO> buscaTudo() {
		List<PessoaVO> pessoas = DozerMapper.parseListaObjetos(pessoaRepository.findAll(), PessoaVO.class);
		pessoas.forEach(pessoa -> {
			pessoa.add(linkTo(methodOn(PessoaController.class).buscaPorId(pessoa.getKey())).withSelfRel());
		});
		return pessoas;
	}
	
	public PessoaVO cria(PessoaVO pessoa) {
		Pessoa entity = DozerMapper.parseObjeto(pessoa, Pessoa.class);
		PessoaVO vo = DozerMapper.parseObjeto(pessoaRepository.save(entity), PessoaVO.class);
		vo.add(linkTo(methodOn(PessoaController.class).buscaPorId(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public PessoaVO atualiza(Long id, PessoaVO pessoa) {
		
		Pessoa entity = buscaPorIdEntity(id);
		
		entity.setPrimeiroNome(pessoa.getPrimeiroNome());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setGenero(pessoa.getGenero());
		
		PessoaVO vo = DozerMapper.parseObjeto(pessoaRepository.save(entity), PessoaVO.class);
		vo.add(linkTo(methodOn(PessoaController.class).buscaPorId(vo.getKey())).withSelfRel());
		return vo;
	}
	
public PessoaVOV2 atualizaV2(Long id, PessoaVOV2 pessoa) {
		
		Pessoa entity = buscaPorIdEntity(id);
		
		entity.setPrimeiroNome(pessoa.getPrimeiroNome());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setGenero(pessoa.getGenero());
		
		PessoaVOV2 vo = pessoaMapper.converteEntidadeParaVO(pessoaRepository.save(entity));
		return vo;
	}
	
	public void deleta(Long id) {
		
		Pessoa entity = buscaPorIdEntity(id);
		pessoaRepository.delete(entity);
	}
	
	protected Pessoa buscaPorIdEntity(Long id) {
		Pessoa entity = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum recurso foi encontrado"));
		return entity;
	}
	
}
