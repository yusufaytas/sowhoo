package sowhoo.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

@Indexed
@Entity
@Table(name = "sowhoouser")
public class User {
	
	@Id
	@DocumentId
	@Column(name = "uemail")
	private String email;
	
	@Column(name = "uip")
	private String ip;
	
	@Column(name = "upassword")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPassword() {
		
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
