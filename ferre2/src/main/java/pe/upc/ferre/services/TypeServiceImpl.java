package pe.upc.ferre.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.upc.ferre.entidades.Type;
import pe.upc.ferre.repository.TypeRepository;
@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeRepository typeRepository;

	@Override
	public List<Type> listTypes() {
		return (List<Type>)typeRepository.findAll();
	}

	@Override
	public Type register(Type type) {
		return typeRepository.save(type);
	}
	

}
