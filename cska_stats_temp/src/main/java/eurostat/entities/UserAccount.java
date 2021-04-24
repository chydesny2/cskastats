package eurostat.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_accounts")
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="userid_generator")
	@SequenceGenerator(name="userid_generator", sequenceName = "user_accounts_seq", allocationSize = 1)
	private long UserId;
	
	@NotBlank
	@Size(min=3, max=50)
	@Column(name="username")
	private String userName;
	
	
	@NotBlank
	@Size(min=6, max=100)
	@Column(name="email")
	private String email;
	
	@NotBlank
	@Size(min=6, max=100)
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled = true;
	
	private String role = "ADMIN";

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getUserId() {
		return UserId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public UserAccount() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserAccount(String userName, String email, String password, boolean enabled, String role) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}


	
	

	
	
}
