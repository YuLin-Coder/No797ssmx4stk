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


import com.dao.DiscussweiboxinxiDao;
import com.entity.DiscussweiboxinxiEntity;
import com.service.DiscussweiboxinxiService;
import com.entity.vo.DiscussweiboxinxiVO;
import com.entity.view.DiscussweiboxinxiView;

@Service("discussweiboxinxiService")
public class DiscussweiboxinxiServiceImpl extends ServiceImpl<DiscussweiboxinxiDao, DiscussweiboxinxiEntity> implements DiscussweiboxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussweiboxinxiEntity> page = this.selectPage(
                new Query<DiscussweiboxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussweiboxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussweiboxinxiEntity> wrapper) {
		  Page<DiscussweiboxinxiView> page =new Query<DiscussweiboxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussweiboxinxiVO> selectListVO(Wrapper<DiscussweiboxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussweiboxinxiVO selectVO(Wrapper<DiscussweiboxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussweiboxinxiView> selectListView(Wrapper<DiscussweiboxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussweiboxinxiView selectView(Wrapper<DiscussweiboxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
