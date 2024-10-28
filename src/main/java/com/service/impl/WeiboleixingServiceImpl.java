package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.WeiboleixingDao;
import com.entity.WeiboleixingEntity;
import com.service.WeiboleixingService;
import com.entity.vo.WeiboleixingVO;
import com.entity.view.WeiboleixingView;

@Service("weiboleixingService")
public class WeiboleixingServiceImpl extends ServiceImpl<WeiboleixingDao, WeiboleixingEntity> implements WeiboleixingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeiboleixingEntity> page = this.selectPage(
                new Query<WeiboleixingEntity>(params).getPage(),
                new EntityWrapper<WeiboleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeiboleixingEntity> wrapper) {
		  Page<WeiboleixingView> page =new Query<WeiboleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeiboleixingVO> selectListVO(Wrapper<WeiboleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeiboleixingVO selectVO(Wrapper<WeiboleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeiboleixingView> selectListView(Wrapper<WeiboleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeiboleixingView selectView(Wrapper<WeiboleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
