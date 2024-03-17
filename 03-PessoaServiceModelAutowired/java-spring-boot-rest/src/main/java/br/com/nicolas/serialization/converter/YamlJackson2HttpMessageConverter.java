package br.com.nicolas.serialization.converter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

public class YamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {
  public YamlJackson2HttpMessageConverter() {
    super(
      new YAMLMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL), // deixamos como NON_NULL para quando um campo estiver como nome: null, ele não inclua ele.
      MediaType.parseMediaType("application/x-yaml")
    );
  }
}
