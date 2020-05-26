package pe.upc.ferre.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.upc.ferre.entidades.Product;
import pe.upc.ferre.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> lista() {
		return (List<Product>)productRepository.findAll();
	}

	@Override
	public Product registrar(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> obtenerListadoNombre(String description) {
		return productRepository.findProductDescription(description);
	}

	@Override
	public Product getProduct(Long id) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getOne(id);
	}

}
