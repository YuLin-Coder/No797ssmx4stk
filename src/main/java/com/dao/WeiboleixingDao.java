package com.dao;

import com.entity.WeiboleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WeiboleixingVO;
import com.entity.view.WeiboleixingView;


/**
 * 微博类型
 * 
 * @author 
 * @email 
 * @date 2021-03-24 20:24:34
 */
public interface WeiboleixingDao extends BaseMapper<WeiboleixingEntity> {
	
	List<WeiboleixingVO> selectListVO(@Param("ew") Wrapper<WeiboleixingEntity> wrapper);
	
	WeiboleixingVO selectVO(@Param("ew") Wrapper<WeiboleixingEntity> wrapper);
	
	List<WeiboleixingView> selectListView(@Param("ew") Wrapper<WeiboleixingEntity> wrapper);

	List<WeiboleixingView> selectListView(Pagination page,@Param("ew") Wrapper<WeiboleixingEntity> wrapper);
	
	WeiboleixingView selectView(@Param("ew") Wrapper<WeiboleixingEntity> wrapper);
	
}
