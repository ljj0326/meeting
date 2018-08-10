package com.mzmy.MeetingManager.model.dao.infldao;

import java.util.*;

import com.mzmy.MeetingManager.model.vo.EmpVo;

/**
 * 员工信息操作的接口
 * 
 * @author mzmy
 *
 */
public interface InfEmpDao {
	//查询员工通过部门id
	public Map<Integer,String> selEmpsByDid(int did);

}
