package firstproject.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import firstproject.northwind.business.abstracts.UserService;
import firstproject.northwind.core.dataAccess.UserDao;
import firstproject.northwind.core.entities.User;
import firstproject.northwind.core.utilities.results.DataResult;
import firstproject.northwind.core.utilities.results.Result;
import firstproject.northwind.core.utilities.results.SucccessDataResult;
import firstproject.northwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;

	@Autowired 
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SucccessDataResult<User>(
				this.userDao.findByEmail(email),"Kullanıcı bulundu");
	}

}
