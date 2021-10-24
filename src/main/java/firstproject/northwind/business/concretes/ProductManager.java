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

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SucccessDataResult<Product>(
				this.productDao.getByProductName(productName),"Data Listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		//business codes kısmı iş kuralları buraya yazılacak
		
		return new SucccessDataResult<Product>(
				this.productDao.getByProductNameAndCategoryId(productName,categoryId),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SucccessDataResult<List<Product>>(
				this.productDao.getByProductNameOrCategoryId(productName,categoryId),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SucccessDataResult<List<Product>>(
				this.productDao.getByCategoryIdIn(categories),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SucccessDataResult<List<Product>>(
				this.productDao.getByProductNameContains(productName),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SucccessDataResult<List<Product>>(
				this.productDao.getByProductNameStartsWith(productName),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SucccessDataResult<List<Product>>(
				this.productDao.getByNameAndCategory(productName,categoryId),"Data Listelendi");
	}

}
