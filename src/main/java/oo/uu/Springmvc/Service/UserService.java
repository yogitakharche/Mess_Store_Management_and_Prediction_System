package oo.uu.Springmvc.Service;

import java.util.List;

import oo.uu.Springmvc.Model.UserModel;

public interface UserService {
	
	public boolean isAddUser(UserModel uModel);
	
    List<UserModel> getAllUser();
      
    public boolean isDeleteUser(int id);
    
    public boolean isUpdateUser(UserModel model);
    
    
    public UserModel sessionData(UserModel umodel);
  
    
}
