package firstproject.northwind.business.abstracts;

import java.util.List;

import firstproject.northwind.core.utilities.results.DataResult;
import firstproject.northwind.core.utilities.results.Result;
import firstproject.northwind.entities.concretes.Product;

public interface ProductService {
	DataResult<List<Product>> getAll();
	Result add(Product product);
}
