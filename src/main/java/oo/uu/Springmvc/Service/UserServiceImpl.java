package oo.uu.Springmvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oo.uu.Springmvc.Model.UserModel;
import oo.uu.Springmvc.Repository.UserRepository;

@Service("usrServ")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository usrRepo;
	
	@Override
	public boolean isAddUser(UserModel uModel) {
		
		return usrRepo.isAddUser(uModel);
	}

	@Override
	public List<UserModel> getAllUser() {
		
		return usrRepo.getAllUser();
	}

	@Override
	public boolean isDeleteUser(int id) {
		
		return usrRepo.isDeleteUser(id);
	}

	@Override
	public boolean isUpdateUser(UserModel umodel) {
		
		return usrRepo.isUpdateUser(umodel);
	}

	@Override
	public UserModel sessionData(UserModel umodel) {
		// TODO Auto-generated method stub
		return usrRepo.sessionData(umodel);
	}

	
}
