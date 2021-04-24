package eurostat.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="authorityid_generator")
	@SequenceGenerator(name="authorityid_generator", sequenceName = "authorities_seq", allocationSize = 1)
	@Column(name="auth_id")
	private long authId;
	@Column(name="username")
	private String userName;
	@Column (name="authority")
	private String authority;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	public Authority() {
		super();
	}
	public Authority(String userName, String authority) {
		super();
		this.userName = userName;
		this.authority = authority;
	}
	
	
}
