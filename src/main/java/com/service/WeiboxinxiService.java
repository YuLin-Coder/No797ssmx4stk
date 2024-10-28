package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeiboxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WeiboxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WeiboxinxiView;


/**
 * 微博信息
 *
 * @author 
 * @email 
 * @date 2021-03-24 20:24:34
 */
public interface WeiboxinxiService extends IService<WeiboxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeiboxinxiVO> selectListVO(Wrapper<WeiboxinxiEntity> wrapper);
   	
   	WeiboxinxiVO selectVO(@Param("ew") Wrapper<WeiboxinxiEntity> wrapper);
   	
   	List<WeiboxinxiView> selectListView(Wrapper<WeiboxinxiEntity> wrapper);
   	
   	WeiboxinxiView selectView(@Param("ew") Wrapper<WeiboxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeiboxinxiEntity> wrapper);
   	
}

