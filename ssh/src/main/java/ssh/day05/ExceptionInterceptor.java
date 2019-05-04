package ssh.day05;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import ssh.day02.JsonResult;

@Component
public class ExceptionInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation inv)
			throws Exception {
		try{
			//执行后续的控制器
			String val = inv.invoke();
			return val;
		}catch(Exception e){
			e.printStackTrace();
			Object act=inv.getAction();
			if(act instanceof JsonAction){
				JsonAction action=(JsonAction)act;
				action.setJsonResult(new JsonResult(e));
				return JsonAction.JSON;
			}
			throw e;
		}
	}

}





