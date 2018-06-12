package cn.mao.newsssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mao.newsssm.dao.BaseDao;
import cn.mao.newsssm.entity.Cmenu;

@Service
public class MenuSvc {
	@Resource
	private BaseDao<Cmenu> dao;

	public List<Cmenu> listMenu(int pid) {
		return dao.list2(pid);
	}
}
