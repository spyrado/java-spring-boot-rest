package br.com.nicolas;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.nicolas.exceptions.UnsupportedMathOperationException;
import br.com.nicolas.helpers.MathHelper;

@RestController
public class MathController {

	@RequestMapping(path = "/soma/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double soma(
			@PathVariable(value = "numero1") String numero1,
			@PathVariable(value = "numberTwo") String numero2
	) throws Exception {
		if(!MathHelper.isNumeric(numero1) || !MathHelper.isNumeric(numero2)) {
			throw new UnsupportedMathOperationException();
		}
		return MathHelper.convertToDouble(numero1) + MathHelper.convertToDouble(numero2);
	}
	
	@RequestMapping(path = "/subtrai/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double substrai(
			@PathVariable(value = "numero1") String numero1,
			@PathVariable(value = "numero2") String numero2
		) throws Exception {
		
		if(!MathHelper.isNumeric(numero1) || !MathHelper.isNumeric(numero2)) {
			throw new UnsupportedMathOperationException();
		}
		
		return MathHelper.convertToDouble(numero1) - MathHelper.convertToDouble(numero2);
	}
	
	@RequestMapping(path = "/divide/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double divide(
			@PathVariable(value = "numero1") String numero1,
			@PathVariable(value = "numero2") String numero2
		) throws Exception {
		
		if(!MathHelper.isNumeric(numero1) || !MathHelper.isNumeric(numero2)) {
			throw new UnsupportedMathOperationException();
		}
		
		return MathHelper.convertToDouble(numero1) / MathHelper.convertToDouble(numero2);
	}
	
	@RequestMapping(path = "/multiplica/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double multiplica(
			@PathVariable(value = "numero1") String numero1,
			@PathVariable(value = "numero2") String numero2
		) throws Exception {
		
		if(!MathHelper.isNumeric(numero1) || !MathHelper.isNumeric(numero2)) {
			throw new UnsupportedMathOperationException();
		}
		
		return MathHelper.convertToDouble(numero1) * MathHelper.convertToDouble(numero2);
	}
	

}
