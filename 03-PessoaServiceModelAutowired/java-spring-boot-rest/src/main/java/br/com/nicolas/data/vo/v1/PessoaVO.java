package br.com.nicolas.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;
@JsonPropertyOrder({"id", "primeiroNome", "sobrenome", "endereco", "genero"})
public class PessoaVO extends RepresentationModel<PessoaVO> implements Serializable {

	private static final long serialVersionUID = 1L;


	@Mapping("id") // o dozer n consegue fazer o parser pois a entidade é id e a vo é key, então para ele conseguir temos que fazer o Mapping de key para id
	private Long key;
	@JsonProperty("primeiro_nome")
	private String primeiroNome;
	private String sobrenome;
	private String endereco;
	private String genero;
	
	public PessoaVO() {}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		PessoaVO pessoaVO = (PessoaVO) o;
		return Objects.equals(key, pessoaVO.key) && Objects.equals(primeiroNome, pessoaVO.primeiroNome) && Objects.equals(sobrenome, pessoaVO.sobrenome) && Objects.equals(endereco, pessoaVO.endereco) && Objects.equals(genero, pessoaVO.genero);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), key, primeiroNome, sobrenome, endereco, genero);
	}
}
