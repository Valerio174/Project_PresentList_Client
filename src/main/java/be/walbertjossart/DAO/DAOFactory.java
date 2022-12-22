package be.walbertjossart.DAO;

import java.sql.Connection;

import be.walbertjossart.JavaBeans.List;
import be.walbertjossart.JavaBeans.Message;
import be.walbertjossart.JavaBeans.Present;
import be.walbertjossart.JavaBeans.Users;

public class DAOFactory extends AbstractDAOFactory{
	
	public DAO<Users> getUsersDAO(){
		return new UsersDAO();
	}
	
	public DAO<List> getListDAO(){
		return new ListDAO();
	}
	
	public DAO<Message> getMessageDAO(){
		return new MessageDAO();
	}
	
	public DAO<Present> getPresentDAO() {
		return new PresentDAO();
	}
}
