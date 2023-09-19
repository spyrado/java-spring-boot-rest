package br.com.nicolas.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O, D> D parseObjeto(O origem, Class<D> destino) {
		return mapper.map(origem, destino);
	}
	
	public static <O, D> List<D> parseListaObjetos(List<O> origens, Class<D> destino) {
		List<D> destinoObjetos = new ArrayList<D>();
		for (O origem : origens) {
			destinoObjetos.add(mapper.map(origem, destino));
		}
		return destinoObjetos;
	}
}
