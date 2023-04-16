package Model;

public class member {
	private Integer id;
	private String idNumber;
	private String username;
	private String password;
	private String name;
	private String phone;
	private String mail;
	
	public member(String idNumber, String username, String password, String name, String phone, String mail) {
		super();
		this.idNumber = idNumber;
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
	}

	public member(Integer id, String idNumber, String username, String password, String name, String phone, String mail) {
		super();
		this.id = id;
		this.idNumber = idNumber;
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
	}
	
	public member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
						
}
