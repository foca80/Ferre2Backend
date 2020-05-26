package pe.upc.ferre.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import pe.upc.ferre.entidades.Product;

public interface ProductService {
	public List<Product> lista();
	public Product registrar(@RequestBody Product product);
	public List<Product> obtenerListadoNombre(String description);
	public Product getProduct(Long id) throws Exception;
		
}
