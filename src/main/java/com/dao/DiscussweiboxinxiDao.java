package com.dao;

import com.entity.DiscussweiboxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussweiboxinxiVO;
import com.entity.view.DiscussweiboxinxiView;


/**
 * 微博信息评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-24 20:24:34
 */
public interface DiscussweiboxinxiDao extends BaseMapper<DiscussweiboxinxiEntity> {
	
	List<DiscussweiboxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussweiboxinxiEntity> wrapper);
	
	DiscussweiboxinxiVO selectVO(@Param("ew") Wrapper<DiscussweiboxinxiEntity> wrapper);
	
	List<DiscussweiboxinxiView> selectListView(@Param("ew") Wrapper<DiscussweiboxinxiEntity> wrapper);

	List<DiscussweiboxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussweiboxinxiEntity> wrapper);
	
	DiscussweiboxinxiView selectView(@Param("ew") Wrapper<DiscussweiboxinxiEntity> wrapper);
	
}
