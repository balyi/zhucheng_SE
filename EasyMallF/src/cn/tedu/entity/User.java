package cn.tedu.entity;

import cn.tedu.exception.MsgException;
import cn.tedu.utils.WebUtils;

public class User {
	private int id;
	private String username;
	private String password;
	private String nickname;
	private String email;
	private String password2;
	private String valistr;
	private String role;
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void check() throws MsgException{
		//>>�ǿ�У��
		if(WebUtils.isNull(username)){
			//����û���Ϊ��, ��ת��ע��ҳ����ʾ�û�"�û�������Ϊ��!"
			throw new MsgException("�û�������Ϊ��!");
		}
		if(WebUtils.isNull(password)){
			throw new MsgException("���벻��Ϊ��!");
		}
		if(WebUtils.isNull(password2)){
			throw new MsgException("ȷ�����벻��Ϊ��!");
		}
		if(WebUtils.isNull(nickname)){
			throw new MsgException("�ǳƲ���Ϊ��!");
		}
		if(WebUtils.isNull(email)){
			throw new MsgException("���䲻��Ϊ��!");
		}
		if(WebUtils.isNull(valistr)){
			throw new MsgException("��֤�벻��Ϊ��!");
		}
		
		//>>���������Ƿ�һ��У��
		if(!password.equals(password2)){
			throw new MsgException("�������벻һ��!");
		}
		//>>�����ʽ�Ƿ���ȷ
		//admin123@163.com  admin123@sina.com.cn
		//��������: "^\\w+@\\w+(\\.[a-z]+)+$"
		if(!email.matches("^\\w+@\\w+(\\.[a-z]+)+$")){
			throw new MsgException("�����ʽ����ȷ!");
		}
	}
	
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getValistr() {
		return valistr;
	}

	public void setValistr(String valistr) {
		this.valistr = valistr;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
