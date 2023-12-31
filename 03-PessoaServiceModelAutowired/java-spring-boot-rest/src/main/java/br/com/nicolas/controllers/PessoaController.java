package br.com.nicolas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nicolas.data.vo.v1.PessoaVO;
import br.com.nicolas.data.vo.v2.PessoaVOV2;
import br.com.nicolas.services.PessoaServices;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

  // Como era instanciada uma service antigamente
  //	private PessoaServices pessoaService = new PessoaServices();

  // Como é feito hoje em dia com @Autowired
  @Autowired
  private PessoaServices pessoaService;


  @GetMapping(
    path = "/{id}",
    produces = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE,
    }
  )
  public PessoaVO buscaPorId(
    @PathVariable(value = "id") Long id
  ) {
    return pessoaService.buscaPorId(id);
  }

  @GetMapping(produces = {
    MediaType.APPLICATION_JSON_VALUE,
    MediaType.APPLICATION_XML_VALUE,
  })
  public List<PessoaVO> pessoas() {
    return pessoaService.buscaTudo();
  }

  @PostMapping(
    consumes = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE,
    }, // consome JSON
    produces = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE,
    } // produz JSON
  )
  public PessoaVO cria(
    @RequestBody PessoaVO pessoa) {

    return pessoaService.cria(pessoa);
  }

  @PutMapping(
    path = "/{id}",
    consumes = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE,
    },
    produces = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE,
    }
  )
  public PessoaVO atualiza(
    @RequestBody PessoaVO pessoa,
    @PathVariable(value = "id") Long id
  ) {

    return pessoaService.atualiza(id, pessoa);
  }

  @PutMapping(
    path = "/v2/{id}",
    consumes = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE,
    },
    produces = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE,
    }
  )
  public PessoaVOV2 atualizaV2(
    @RequestBody PessoaVOV2 pessoa,
    @PathVariable(value = "id") Long id
  ) {

    return pessoaService.atualizaV2(id, pessoa);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<?> deleta(
    @PathVariable(value = "id") Long id) {
    pessoaService.deleta(id);
    return ResponseEntity.noContent().build();
  }


}
