package br.com.nicolas.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.nicolas.data.vo.v1.PessoaVO;
import br.com.nicolas.models.Pessoa;

public class MockPessoa {


    public Pessoa mockEntity() {
        return mockEntity(0);
    }
    
    public PessoaVO mockVO() {
        return mockVO(0);
    }
    
    public List<Pessoa> mockEntityList() {
        List<Pessoa> persons = new ArrayList<Pessoa>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PessoaVO> mockVOList() {
        List<PessoaVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    public Pessoa mockEntity(Integer number) {
        Pessoa person = new Pessoa();
        person.setEndereco("Addres Test" + number);
        person.setPrimeiroNome("First Name Test" + number);
        person.setGenero(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setSobrenome("Last Name Test" + number);
        return person;
    }

    public PessoaVO mockVO(Integer number) {
        PessoaVO person = new PessoaVO();
        person.setEndereco("Addres Test" + number);
        person.setPrimeiroNome("First Name Test" + number);
        person.setGenero(((number % 2)==0) ? "Male" : "Female");
        person.setKey(number.longValue());
        person.setSobrenome("Last Name Test" + number);
        return person;
    }

}
