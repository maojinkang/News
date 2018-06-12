package cn.mao.cnm.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import cn.mao.cnm.bean.User;
import cn.mao.cnm.service.UserSvc;
import cn.mao.cnm.utils.BaseUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



@Controller
public class UserAct extends ActionSupport {
	@Resource
	private UserSvc userSvc;
	private String uid, pwd;
	private String jsonResult;
	private HashMap<String, Object> jsonobj = new HashMap<String, Object>();

	public String doLogin() {
		try {
			Long n = userSvc.getCount();
			if (n == 0) {
				User user = new User();
				user.setUid("15436341");
				user.setName("毛靖康");
				user.setPwd(BaseUtil.lrwCode("123", ""));

				user.setBj("信息学院");
				user.setRole("1");
				userSvc.addU(user);
			}
			User user0 = userSvc.findU(uid, pwd);
			System.out.println(user0);
			jsonobj.clear();
			if (user0 != null) {
				jsonobj.put("ok", true);
				jsonobj.put("msg", "goIndex");
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("me", user0);
			} else {
				jsonobj.put("ok", false);
				jsonobj.put("msg", "用户不存在");
			}
		} catch (Exception e) {
			jsonobj.put("ok", false);
			jsonobj.put("msg", "系统错误");
		}
		jsonResult = BaseUtil.toJson(jsonobj);
		HttpServletResponse response = ServletActionContext.getResponse();
		BaseUtil.outPrint(response, jsonResult);
		return null;
	}

	public String doLogout() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		session.put("me", null);
		return "logout";
	}
	
	public String goIndex(){
		return "goadmin";
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
