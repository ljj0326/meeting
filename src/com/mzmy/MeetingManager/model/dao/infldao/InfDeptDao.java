package com.mzmy.MeetingManager.model.dao.infldao;

import java.util.ArrayList;
import com.mzmy.MeetingManager.model.vo.DeptVo;

/**
 * 部门操作的相关的方法
 * @author mzmy
 */
public interface InfDeptDao {
    //查询所有的部门信息
	public ArrayList<DeptVo> selAllDepts();
}
