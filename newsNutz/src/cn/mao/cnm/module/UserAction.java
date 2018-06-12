package cn.mao.cnm.module;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import cn.mao.cnm.pojo.User;
import cn.mao.cnm.utils.BaseSrv;
import cn.mao.cnm.utils.LoginFilter;
@IocBean
@At("/user")
@Filters({@By(type=LoginFilter.class)})
public class UserAction extends BaseSrv{
	 @Inject
     protected Dao dao;
     //查--登录
     @At
     @Ok("json")
     @Filters()
     public Object doLogin(@Param("uid")String uid, @Param("pwd") String pwd,
             HttpSession session,HttpServletRequest req){
       NutMap re = new NutMap();
       User user = dao.fetch(User.class, uid);//获取记录 用第二个参数查询数据库
       if (user == null ) {
           re.put("ok", false);
           re.put("msg", "考号不存在");
           return re;
       }
       
       String p =lrwCode(pwd, "");
       if (!p.equals(user.getPwd())) {
           re.put("ok", false);
           re.put("msg", "密码不正确");
           return re;
       }
       String role=user.getRole();
       //登录成功后...将用户信息保存到session
       session.setAttribute("me", user);
       if(role.equals("5")) {
           re.put("ok", true);
           re.put("msg", "user/goIndex");
           return re;
       }
       else if(role.equals("1")) {
           re.put("ok", true);
           re.put("msg", "user/goAdmin");
           return re;
       }
       else {
           re.put("ok", false);
           re.put("msg", "系统错误！");
           return re;
       }
     }
     
     /**
      * 退出登录
      * @param session
      */
     @At
     @Ok(">>:/")
     public void doLogout(HttpSession session) {
         session.invalidate();
     }
     @At
     @Ok("beetl:web/index.html")//考生登录成功，跳转到考试信息页面
     public void goIndex(HttpSession session,HttpServletRequest req){
           User loginuser=(User)session.getAttribute("me");
           req.setAttribute("user", loginuser);
     }
     @At
     @Ok("beetl:web/admin.html")//管理员登录成功，跳转到管理信息页面
     public void goAdmin(HttpSession session,HttpServletRequest req){
           User loginuser=(User)session.getAttribute("me");
           req.setAttribute("user", loginuser);
     }
	
}
