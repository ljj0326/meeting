package com.mzmy.MeetingManager.model.dao.infldao;

import java.util.*;

import com.mzmy.MeetingManager.model.vo.DeptVo;
import com.mzmy.MeetingManager.model.vo.FenYeVo;

/**
 * 分页的的数据查询
 * @author mzmy
 *
 */
public interface InfFenYeDao {
   //查询总的数据
	public int myDataCount();
	//查询最后一条数据
	public ArrayList<DeptVo> selMyDatas(FenYeVo fy);
}
