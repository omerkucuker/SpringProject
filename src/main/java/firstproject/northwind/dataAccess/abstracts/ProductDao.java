package firstproject.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import firstproject.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product,Integer>{
 
	//jpa repo. hazır sql kodları
	Product getByProductName(String productName); //findBy da aynı amaç, kolon adı= ürün adından ürünü getirir.
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId); //ürün adı ve kategori id den ürünü getirir.
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

	//select * from products where category_id in (1,2,3,4)
	List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	//jpql nesneleri sql sorgusuna gönderme, isimlendirme entities deki class ve fieldlara göre
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory_CategoryId(String productName,int categoryId);
	//select * from products where product_name=foo and categoryId=foo
}
