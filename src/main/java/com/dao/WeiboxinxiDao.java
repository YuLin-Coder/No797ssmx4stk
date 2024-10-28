package com.dao;

import com.entity.WeiboxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WeiboxinxiVO;
import com.entity.view.WeiboxinxiView;


/**
 * 微博信息
 * 
 * @author 
 * @email 
 * @date 2021-03-24 20:24:34
 */
public interface WeiboxinxiDao extends BaseMapper<WeiboxinxiEntity> {
	
	List<WeiboxinxiVO> selectListVO(@Param("ew") Wrapper<WeiboxinxiEntity> wrapper);
	
	WeiboxinxiVO selectVO(@Param("ew") Wrapper<WeiboxinxiEntity> wrapper);
	
	List<WeiboxinxiView> selectListView(@Param("ew") Wrapper<WeiboxinxiEntity> wrapper);

	List<WeiboxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<WeiboxinxiEntity> wrapper);
	
	WeiboxinxiView selectView(@Param("ew") Wrapper<WeiboxinxiEntity> wrapper);
	
}
