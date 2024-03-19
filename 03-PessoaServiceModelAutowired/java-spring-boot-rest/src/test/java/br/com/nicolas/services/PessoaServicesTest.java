package br.com.nicolas.services;

import br.com.nicolas.models.Pessoa;
import br.com.nicolas.repositories.PessoaRepository;
import br.com.nicolas.unittests.mapper.mocks.MockPessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
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
    assertEquals(result, new Object());
  }

  @Test
  void buscaTudo() {
  }

  @Test
  void cria() {
  }

  @Test
  void atualiza() {
  }

  @Test
  void atualizaV2() {
  }

  @Test
  void deleta() {
  }
}