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
     //��--��¼
     @At
     @Ok("json")
     @Filters()
     public Object doLogin(@Param("uid")String uid, @Param("pwd") String pwd,
             HttpSession session,HttpServletRequest req){
       NutMap re = new NutMap();
       User user = dao.fetch(User.class, uid);//��ȡ��¼ �õڶ���������ѯ���ݿ�
       if (user == null ) {
           re.put("ok", false);
           re.put("msg", "���Ų�����");
           return re;
       }
       
       String p =lrwCode(pwd, "");
       if (!p.equals(user.getPwd())) {
           re.put("ok", false);
           re.put("msg", "���벻��ȷ");
           return re;
       }
       String role=user.getRole();
       //��¼�ɹ���...���û���Ϣ���浽session
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
           re.put("msg", "ϵͳ����");
           return re;
       }
     }
     
     /**
      * �˳���¼
      * @param session
      */
     @At
     @Ok(">>:/")
     public void doLogout(HttpSession session) {
         session.invalidate();
     }
     @At
     @Ok("beetl:web/index.html")//������¼�ɹ�����ת��������Ϣҳ��
     public void goIndex(HttpSession session,HttpServletRequest req){
           User loginuser=(User)session.getAttribute("me");
           req.setAttribute("user", loginuser);
     }
     @At
     @Ok("beetl:web/admin.html")//����Ա��¼�ɹ�����ת��������Ϣҳ��
     public void goAdmin(HttpSession session,HttpServletRequest req){
           User loginuser=(User)session.getAttribute("me");
           req.setAttribute("user", loginuser);
     }
	
}
