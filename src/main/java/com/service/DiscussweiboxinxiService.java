package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussweiboxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussweiboxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussweiboxinxiView;


/**
 * 微博信息评论表
 *
 * @author 
 * @email 
 * @date 2021-03-24 20:24:34
 */
public interface DiscussweiboxinxiService extends IService<DiscussweiboxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussweiboxinxiVO> selectListVO(Wrapper<DiscussweiboxinxiEntity> wrapper);
   	
   	DiscussweiboxinxiVO selectVO(@Param("ew") Wrapper<DiscussweiboxinxiEntity> wrapper);
   	
   	List<DiscussweiboxinxiView> selectListView(Wrapper<DiscussweiboxinxiEntity> wrapper);
   	
   	DiscussweiboxinxiView selectView(@Param("ew") Wrapper<DiscussweiboxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussweiboxinxiEntity> wrapper);
   	
}

