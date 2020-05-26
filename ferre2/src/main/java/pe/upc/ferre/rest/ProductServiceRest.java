package pe.upc.ferre.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.upc.ferre.entidades.Product;
import pe.upc.ferre.repository.ProductRepository;
import pe.upc.ferre.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductServiceRest{
	@Autowired
	private ProductRepository productRepositoy;
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public List<Product> list() {
		return productRepositoy.findAll();
	}

	@PostMapping("/product")
	public Product register(@RequestBody Product product) {
		return productRepositoy.save(product);
	}

	@GetMapping("/product/{description}")
	public List<Product> findProductDescrption(@PathVariable(value = "description") String description) throws ResponseStatusException{
		System.out.println("Servicio REST " + description);
		List<Product> lista = null;
		try {
			lista = productRepositoy.findProductDescription(description);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Disculpe la molestia");
		}
		return lista;
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable(value = "id") Long id) {
		Product pro = null;
		try {
			pro = productService.getProduct(id);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vuelva a intentarlo");
		}
		return pro;
	}
}
