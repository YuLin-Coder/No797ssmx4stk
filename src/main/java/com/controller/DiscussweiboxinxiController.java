package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussweiboxinxiEntity;
import com.entity.view.DiscussweiboxinxiView;

import com.service.DiscussweiboxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 微博信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-24 20:24:34
 */
@RestController
@RequestMapping("/discussweiboxinxi")
public class DiscussweiboxinxiController {
    @Autowired
    private DiscussweiboxinxiService discussweiboxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussweiboxinxiEntity discussweiboxinxi, 
		HttpServletRequest request){

        EntityWrapper<DiscussweiboxinxiEntity> ew = new EntityWrapper<DiscussweiboxinxiEntity>();
		PageUtils page = discussweiboxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussweiboxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussweiboxinxiEntity discussweiboxinxi, HttpServletRequest request){
        EntityWrapper<DiscussweiboxinxiEntity> ew = new EntityWrapper<DiscussweiboxinxiEntity>();
		PageUtils page = discussweiboxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussweiboxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussweiboxinxiEntity discussweiboxinxi){
       	EntityWrapper<DiscussweiboxinxiEntity> ew = new EntityWrapper<DiscussweiboxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussweiboxinxi, "discussweiboxinxi")); 
        return R.ok().put("data", discussweiboxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussweiboxinxiEntity discussweiboxinxi){
        EntityWrapper< DiscussweiboxinxiEntity> ew = new EntityWrapper< DiscussweiboxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussweiboxinxi, "discussweiboxinxi")); 
		DiscussweiboxinxiView discussweiboxinxiView =  discussweiboxinxiService.selectView(ew);
		return R.ok("查询微博信息评论表成功").put("data", discussweiboxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussweiboxinxiEntity discussweiboxinxi = discussweiboxinxiService.selectById(id);
        return R.ok().put("data", discussweiboxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussweiboxinxiEntity discussweiboxinxi = discussweiboxinxiService.selectById(id);
        return R.ok().put("data", discussweiboxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussweiboxinxiEntity discussweiboxinxi, HttpServletRequest request){
    	discussweiboxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussweiboxinxi);

        discussweiboxinxiService.insert(discussweiboxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussweiboxinxiEntity discussweiboxinxi, HttpServletRequest request){
    	discussweiboxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussweiboxinxi);

        discussweiboxinxiService.insert(discussweiboxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussweiboxinxiEntity discussweiboxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussweiboxinxi);
        discussweiboxinxiService.updateById(discussweiboxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussweiboxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussweiboxinxiEntity> wrapper = new EntityWrapper<DiscussweiboxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussweiboxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
