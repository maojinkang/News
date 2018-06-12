package cn.mao.cnm;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import cn.mao.cnm.pojo.User;

public class MainSetup implements Setup{

	@Override
	public void destroy(NutConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(NutConfig nc) {
		// TODO Auto-generated method stub
        Ioc ioc = nc.getIoc();
        Dao dao = ioc.get(Dao.class);
        Daos.createTablesInPackage(dao, "cn.mao.cnm.pojo", false);
        // 初始化默认根用户
        if (dao.count(User.class) == 0) {
            User user = new User();
            user.setUid("15436341");
            user.setName("毛靖康");
            String salt="abcdefghijklmnopqrstuvwx";
            user.setPwd(new Sha256Hash("123", salt, 1024).toBase64());
            user.setBj("信息学院");
            user.setRole("1");
            dao.insert(user);
        }
	}

}
