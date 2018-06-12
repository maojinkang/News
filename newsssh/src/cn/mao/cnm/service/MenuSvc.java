package cn.mao.cnm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mao.cnm.bean.Cmenu;
import cn.mao.cnm.dao.BaseDao;

@Service
public class MenuSvc {
	@Resource
	private BaseDao<Cmenu> dao;

	public List<Cmenu> listMenu(int pid) {
		return dao.find("from Cmenu cmenu where cmenu.pid=?",
				new Object[] { pid });
	}
}
