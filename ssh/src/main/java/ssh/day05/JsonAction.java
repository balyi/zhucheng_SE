package ssh.day05;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ssh.day02.JsonResult;

public abstract class JsonAction 
	extends ActionSupport
	implements SessionAware{
	
	public static final String JSON="json";
	
	protected JsonResult jsonResult;

	protected Map<String, Object> session;
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	 
	public JsonResult getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(JsonResult jsonResult) {
		this.jsonResult = jsonResult;
	}

}