package top.gn.entity;

import org.springframework.stereotype.Component;

/**
 *  
 * @ClassName: Manager  
 * @Description: 对应数据库当中manager表  属于管理员的javaBean 
 * @author xiaomi  
 * @date 1 Apr 2018  
 *
 */
@Component
public class Manager {
	
	private Integer id;
	
	private String account;
	
	private String hash;
	
	private String nickname;
	
	private int level;
	

	public Manager() {
	}
	
	
	public Manager(Integer id, String account, String hash, String nickname, int level) {
		super();
		this.id = id;
		this.account = account;
		this.hash = hash;
		this.nickname = nickname;
		this.level = level;
	}

	public Manager(String account, String hash, String nickname, int level) {
		this.account = account;
		this.hash = hash;
		this.nickname = nickname;
		this.level = level;
	}
	
	public Manager(String account, String hash, String nickname) {
		this.account = account;
		this.hash = hash;
		this.nickname = nickname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", account=" + account + ", hash=" + hash + ", nickname=" + nickname + ", level="
				+ level + "]";
	}
	
	
	
	
	
	
	
	
}
