package firstproject.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //lombok parametreli constructor
@NoArgsConstructor  //lombok parametresiz constructor
@Table(name="categories") //veri tabanıyla ilişkilendiriyoruz
@Entity //bunun bir veritabanı tablosu olduğunu belirtiyoruz
public class Category {
	
	@Id
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@OneToMany(mappedBy = "categories") //bir kategoride birden çok ürün ilişkisi
	private List<Product> products;
}
