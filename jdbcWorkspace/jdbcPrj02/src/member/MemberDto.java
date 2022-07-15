package member;

import java.sql.Timestamp;

public class MemberDto {
	
	//생성자(기본)
	public MemberDto() {
		
	}
	
	//생성자(매개변수 있는)
	public MemberDto(String id, String pwd, String nick, Timestamp enrollDate, char quitYn) {
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.enrollDate = enrollDate;
		this.quitYn = quitYn;
	}
	
	//필드
	private String id;
	private String pwd;
	private String nick;
	private Timestamp enrollDate;
	private char quitYn;
	
	
	//getter/setetr
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Timestamp getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}

	public char getQuitYn() {
		return quitYn;
	}

	public void setQuitYn(char quitYn) {
		this.quitYn = quitYn;
	}

	//toString
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", enrollDate=" + enrollDate + ", quitYn="
				+ quitYn + "]";
	}

}//class



























