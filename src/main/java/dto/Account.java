package dto;

public class Account {
	private String id;
	private String name;
	private String mail;
	private String pw;
	private String HashedPw;
	private String salt;
	public Account(String id, String name, String mail, String pw, String hashedPw, String salt) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.pw = pw;
		HashedPw = hashedPw;
		this.salt = salt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getHashedPw() {
		return HashedPw;
	}
	public void setHashedPw(String hashedPw) {
		HashedPw = hashedPw;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
}
