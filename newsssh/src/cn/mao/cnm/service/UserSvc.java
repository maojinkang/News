package cn.mao.cnm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mao.cnm.bean.User;
import cn.mao.cnm.dao.BaseDao;
import cn.mao.cnm.utils.BaseUtil;

@Service
public class UserSvc {
	@Resource
	private BaseDao<User> dao;

	public void addU(User user) {
		dao.save(user);
	}
	
	public User findU(String uid, String pwd) {
		return dao.get("from User u where u.uid=? and u.pwd=?",new Object[]{uid, BaseUtil.lrwCode(pwd,"")});
	}

	public Long getCount() {
		return dao.count("select count(*) from User");
	}
}
