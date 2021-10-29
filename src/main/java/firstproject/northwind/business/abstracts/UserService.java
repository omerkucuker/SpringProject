package firstproject.northwind.business.abstracts;


import firstproject.northwind.core.entities.User;
import firstproject.northwind.core.utilities.results.DataResult;
import firstproject.northwind.core.utilities.results.Result;

public interface UserService {
	Result add(User user);
	
	DataResult<User> findByEmail(String email);

}
