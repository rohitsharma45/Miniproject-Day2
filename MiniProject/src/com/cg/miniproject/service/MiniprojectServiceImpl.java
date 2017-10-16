package com.cg.miniproject.service;

import java.util.ArrayList;

import com.cg.miniproject.bean.MacBean;
import com.cg.miniproject.bean.MiniprojectBean;
import com.cg.miniproject.dao.IMiniprojectDao;
import com.cg.miniproject.dao.MiniprojectDaoImpl;

public class MiniprojectServiceImpl implements IMiniprojectService {

	IMiniprojectDao dao=null;
	public int insertData(MiniprojectBean bean) {
		 dao=new MiniprojectDaoImpl();
		return dao.insertData(bean);
	}
	public String getProgramId() {
		dao=new MiniprojectDaoImpl();
			return dao.getProgramId();
	}
	@Override
	public boolean checkLogin(MacBean mac) {
		ArrayList<MacBean> list = new ArrayList<MacBean>();
		dao=new MiniprojectDaoImpl();
		list=dao.allLogin(mac);
		int flag = 0;
		for(MacBean b:list)
		{
			if(b.getLoginId().equals(mac.getLoginId()) && b.getPassword().equals(mac.getPassword())){
				flag = 1;
				break;
			}
				
		}
		
		if(flag == 1){
			return true;
		}
		else return false;
		
	}
	/*@Override
	public boolean validateUser(ArrayList<MacBean> list) {
		
		return false;
	}*/

}

