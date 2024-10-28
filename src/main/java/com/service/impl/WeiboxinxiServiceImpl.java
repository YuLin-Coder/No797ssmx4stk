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


import com.dao.WeiboxinxiDao;
import com.entity.WeiboxinxiEntity;
import com.service.WeiboxinxiService;
import com.entity.vo.WeiboxinxiVO;
import com.entity.view.WeiboxinxiView;

@Service("weiboxinxiService")
public class WeiboxinxiServiceImpl extends ServiceImpl<WeiboxinxiDao, WeiboxinxiEntity> implements WeiboxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeiboxinxiEntity> page = this.selectPage(
                new Query<WeiboxinxiEntity>(params).getPage(),
                new EntityWrapper<WeiboxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeiboxinxiEntity> wrapper) {
		  Page<WeiboxinxiView> page =new Query<WeiboxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeiboxinxiVO> selectListVO(Wrapper<WeiboxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeiboxinxiVO selectVO(Wrapper<WeiboxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeiboxinxiView> selectListView(Wrapper<WeiboxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeiboxinxiView selectView(Wrapper<WeiboxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
