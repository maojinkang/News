package cn.mao.newsssm.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.mao.newsssm.entity.Cmenu;
import cn.mao.newsssm.entity.EasyUITree;
import cn.mao.newsssm.entity.User;
import cn.mao.newsssm.service.MenuSvc;
import cn.mao.newsssm.utils.BaseUtil;

@Controller
public class MenuAct {
	@Autowired
	private MenuSvc menuSvc;

	private String jsonResult;

	@RequestMapping(value = "menutree")
	public void menutree(HttpServletRequest req, HttpServletResponse response) {

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("me");
		String role = user.getRole();
		List<Cmenu> menulist = menuSvc.listMenu(0);
		List<EasyUITree> eList = new ArrayList<EasyUITree>();
		if (menulist.size() != 0) {
			for (int i = 0; i < menulist.size(); i++) {
				Cmenu t = menulist.get(i);
				if (!t.getPermission().contains(role))
					continue;
				EasyUITree e = new EasyUITree();
				e.setId(t.getId() + "");
				e.setText(t.getName());
				List<EasyUITree> eList2 = new ArrayList<EasyUITree>();
				List<Cmenu> menu2 = menuSvc.listMenu(t.getId());
				for (int j = 0; j < menu2.size(); j++) {
					Cmenu t2 = menu2.get(j);
					if (!t2.getPermission().contains(role))
						continue;
					Map<String, Object> attributes = new HashMap<String, Object>();
					attributes.put("url", t2.getUrl());
					attributes.put("role", t2.getPermission());
					EasyUITree e1 = new EasyUITree();
					e1.setAttributes(attributes);
					e1.setId(t2.getId() + "");
					e1.setText(t2.getName());
					e1.setState("open");
					eList2.add(e1);
				}
				e.setChildren(eList2);
				e.setState("closed");
				eList.add(e);
			}
		}
		jsonResult = BaseUtil.toJson(eList);

		BaseUtil.outPrint(response, jsonResult);
	}
}
