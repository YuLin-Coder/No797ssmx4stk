package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeiboleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WeiboleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WeiboleixingView;


/**
 * 微博类型
 *
 * @author 
 * @email 
 * @date 2021-03-24 20:24:34
 */
public interface WeiboleixingService extends IService<WeiboleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeiboleixingVO> selectListVO(Wrapper<WeiboleixingEntity> wrapper);
   	
   	WeiboleixingVO selectVO(@Param("ew") Wrapper<WeiboleixingEntity> wrapper);
   	
   	List<WeiboleixingView> selectListView(Wrapper<WeiboleixingEntity> wrapper);
   	
   	WeiboleixingView selectView(@Param("ew") Wrapper<WeiboleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeiboleixingEntity> wrapper);
   	
}

