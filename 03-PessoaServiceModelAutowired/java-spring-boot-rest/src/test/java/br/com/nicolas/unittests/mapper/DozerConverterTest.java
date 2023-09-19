package br.com.nicolas.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.nicolas.data.vo.v1.PessoaVO;
import br.com.nicolas.mapper.DozerMapper;
import br.com.nicolas.models.Pessoa;
import br.com.nicolas.unittests.mapper.mocks.MockPessoa;

public class DozerConverterTest {
    
    MockPessoa inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPessoa();
    }

    @Test
    public void parseEntityToVOTest() {
        PessoaVO output = DozerMapper.parseObjeto(inputObject.mockEntity(), PessoaVO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getPrimeiroNome());
        assertEquals("Last Name Test0", output.getSobrenome());
        assertEquals("Addres Test0", output.getEndereco());
        assertEquals("Male", output.getGenero());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PessoaVO> outputList = DozerMapper.parseListaObjetos(inputObject.mockEntityList(), PessoaVO.class);
        PessoaVO outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getPrimeiroNome());
        assertEquals("Last Name Test0", outputZero.getSobrenome());
        assertEquals("Addres Test0", outputZero.getEndereco());
        assertEquals("Male", outputZero.getGenero());
        
        PessoaVO outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getPrimeiroNome());
        assertEquals("Last Name Test7", outputSeven.getSobrenome());
        assertEquals("Addres Test7", outputSeven.getEndereco());
        assertEquals("Female", outputSeven.getGenero());
        
        PessoaVO outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getPrimeiroNome());
        assertEquals("Last Name Test12", outputTwelve.getSobrenome());
        assertEquals("Addres Test12", outputTwelve.getEndereco());
        assertEquals("Male", outputTwelve.getGenero());
    }

    @Test
    public void parseVOToEntityTest() {
        Pessoa output = DozerMapper.parseObjeto(inputObject.mockVO(), Pessoa.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getPrimeiroNome());
        assertEquals("Last Name Test0", output.getSobrenome());
        assertEquals("Addres Test0", output.getEndereco());
        assertEquals("Male", output.getGenero());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Pessoa> outputList = DozerMapper.parseListaObjetos(inputObject.mockVOList(), Pessoa.class);
        Pessoa outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getPrimeiroNome());
        assertEquals("Last Name Test0", outputZero.getSobrenome());
        assertEquals("Addres Test0", outputZero.getEndereco());
        assertEquals("Male", outputZero.getGenero());
        
        Pessoa outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getPrimeiroNome());
        assertEquals("Last Name Test7", outputSeven.getSobrenome());
        assertEquals("Addres Test7", outputSeven.getEndereco());
        assertEquals("Female", outputSeven.getGenero());
        
        Pessoa outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getPrimeiroNome());
        assertEquals("Last Name Test12", outputTwelve.getSobrenome());
        assertEquals("Addres Test12", outputTwelve.getEndereco());
        assertEquals("Male", outputTwelve.getGenero());
    }
}
