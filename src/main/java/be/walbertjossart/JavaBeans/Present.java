package be.walbertjossart.JavaBeans;

import java.awt.Image;
import java.io.Serializable;
import java.sql.SQLException;

import be.walbertjossart.DAO.AbstractDAOFactory;
import be.walbertjossart.DAO.DAO;

public class Present implements Serializable{

	/*Attributs*/
	private static final long serialVersionUID = -2220492601912596085L;
	private int id_present;
	private String name;
	private String description;
	private double average_price;
	private int priority;
	private String state;
	private String link;
	private Image image;
	private List list;
	static AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	static DAO<Present> presentDAO = adf.getPresentDAO();
	
	/*Getters/Setters*/
	public int getId_present() {
		return id_present;
	}
	public void setId_present(int id_present) {
		this.id_present = id_present;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAverage_price() {
		return average_price;
	}
	public void setAverage_price(double average_price) {
		this.average_price = average_price;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	/*Constructor(s)*/
	public Present() {}
	
	/*With ALL attributs*/
	public Present(int id_present, String name, String description, double average_price, int priority, String state,
			String link, Image image, List list) {
 		this.id_present = id_present;
		this.name = name;
		this.description = description;
		this.average_price = average_price;
		this.priority = priority;
		this.state = state;
		this.link = link;
		this.image = image;
		this.list =list;
	}
	/*Without link*/
	public Present(int id_present, String name, String description, double average_price, int priority, String state,
			  Image image, List list) {
 		this.id_present = id_present;
		this.name = name;
		this.description = description;
		this.average_price = average_price;
		this.priority = priority;
		this.state = state;
 		this.image = image;
		this.list =list;
	}
	/*Without image*/
	public Present(int id_present, String name, String description, double average_price, int priority, String state,
			String link, List list) {
 		this.id_present = id_present;
		this.name = name;
		this.description = description;
		this.average_price = average_price;
		this.priority = priority;
		this.state = state;
		this.link = link;
 		this.list =list;
	}
	/*Without link AND image*/
	public Present(int id_present, String name, String description, double average_price, int priority, String state,
			List list) {
 		this.id_present = id_present;
		this.name = name;
		this.description = description;
		this.average_price = average_price;
		this.priority = priority;
		this.state = state;
  		this.list =list;
	}
	
	/*Methods*/
	public boolean insertPresent() throws SQLException {
		return presentDAO.create(this);
	}
}
