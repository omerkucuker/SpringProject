package firstproject.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import firstproject.northwind.business.abstracts.ProductService;
import firstproject.northwind.core.utilities.results.DataResult;
import firstproject.northwind.core.utilities.results.Result;
import firstproject.northwind.core.utilities.results.SucccessDataResult;
import firstproject.northwind.core.utilities.results.SuccessResult;
import firstproject.northwind.dataAccess.abstracts.ProductDao;
import firstproject.northwind.entities.concretes.Product;


@Service
public class ProductManager implements ProductService{

	private ProductDao productDao;
	
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return new SucccessDataResult<List<Product>>(
				this.productDao.findAll(),"Data Listelendi");
				
				
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün Eklendi");
	}

}
