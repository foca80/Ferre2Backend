package pe.upc.ferre.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.upc.ferre.entidades.Type;
import pe.upc.ferre.repository.TypeRepository;

@RestController
@RequestMapping("/api")
public class TypServiceRest {
    
	@Autowired
	private TypeRepository typeRepository;
	
	@GetMapping("/types")
	public List<Type> listTypes(){
       return (List<Type>)typeRepository.findAll();	
    }
	@PostMapping("/type")
	public Type register(@Valid @RequestBody Type type) {
		return typeRepository.save(type);
	}
	
	
}
