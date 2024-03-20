package br.com.nicolas.services;

import br.com.nicolas.data.vo.v1.PessoaVO;
import br.com.nicolas.models.Pessoa;
import br.com.nicolas.repositories.PessoaRepository;
import br.com.nicolas.unittests.mapper.mocks.MockPessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PessoaServicesTest {

  MockPessoa pessoaMock;

  @InjectMocks
  private PessoaServices pessoaServices;

  @Mock
  private PessoaRepository pessoaRepository;

  @BeforeEach
  void setUp() {
    pessoaMock = new MockPessoa();
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void buscaPorId() {
    Pessoa pessoa = pessoaMock.mockEntity(5);
    when(pessoaRepository.findById(pessoa.getId())).thenReturn(Optional.of(pessoa));

    var result = pessoaServices.buscaPorId(pessoa.getId());

    assertNotNull(result);
    assertNotNull(result.getKey());
    assertNotNull(result.getLinks());

    assertTrue(result.toString().contains("links: [</pessoa/5>;rel=\"self\"]"));

    assertEquals("First Name Test5", result.getPrimeiroNome());
    assertEquals("Last Name Test5", result.getSobrenome());
    assertEquals("Female", result.getGenero());
    assertEquals("Addres Test5", result.getEndereco());
  }

  @Test
  void buscaTudo() {
  }

  @Test
  void cria() {
      Pessoa entity = pessoaMock.mockEntity(0);
      Pessoa persistida  = pessoaMock.mockEntity(1);
      PessoaVO payload = pessoaMock.mockVO(0);
      when(pessoaRepository.save(entity)).thenReturn(persistida);

      var result = pessoaServices.cria(payload);
      assertEquals(1, result.getKey());
  }

  @Test
  void atualiza() {

    var id = 2L;
    PessoaVO pessoa = pessoaMock.mockVO(2);
    pessoa.setPrimeiroNome("Nick TT");    
    Pessoa entity = pessoaMock.mockEntity(2);

    when(pessoaRepository.findById(2L)).thenReturn(Optional.of(entity));
    when(pessoaRepository.save((entity))).thenReturn(entity);

    var result = pessoaServices.atualiza(id, pessoa);

    assertEquals("Nick TT", result.getPrimeiroNome());
  }

  @Test
  void atualizaV2() {
  }

  @Test
  void deleta() {

    Long id = 2L;

    pessoaServices.deletaPorId(id);

    ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
    verify(pessoaRepository).deleteById(argumentCaptor.capture());
    
    assertEquals(id, argumentCaptor.getValue());
  }
}