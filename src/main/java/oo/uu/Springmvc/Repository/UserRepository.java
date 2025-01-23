package oo.uu.Springmvc.Repository;

import java.util.List;

import oo.uu.Springmvc.Model.UserModel;

public interface UserRepository {
	
	public boolean isAddUser(UserModel uModel);
	
	List<UserModel> getAllUser();
	
	public boolean isDeleteUser(int id);
	
	public boolean isUpdateUser(UserModel umodel);
	
	public UserModel sessionData(UserModel umodel);
	
}
