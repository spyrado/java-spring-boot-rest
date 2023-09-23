package br.com.nicolas.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.nicolas.data.vo.v2.PessoaVOV2;
import br.com.nicolas.models.Pessoa;

@Service
public class PessoaMapper {

	public PessoaVOV2 converteEntidadeParaVO(Pessoa pessoa) {
		PessoaVOV2 vo = new PessoaVOV2();
		
		vo.setId(pessoa.getId());
		vo.setPrimeiroNome(pessoa.getPrimeiroNome());
		vo.setSobrenome(pessoa.getSobrenome());
		vo.setEndereco(pessoa.getEndereco());
		vo.setGenero(pessoa.getGenero());
		vo.setDataAniversario(new Date()); // n setando na entity pq nesse exemplo n temos nada no banco nem na entity e vai dar erro
		return vo;
	}
	
	public Pessoa converteEntidadeParaVO(PessoaVOV2 pessoa) {
		Pessoa entity = new Pessoa();
		
		entity.setId(pessoa.getId());
		entity.setPrimeiroNome(pessoa.getPrimeiroNome());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setGenero(pessoa.getGenero());
//		entity.setDataAniversario(new Date()); // n setando na entity pq nesse exemplo n temos nada no banco nem na entity e vai dar erro
		return entity;
	}
}
