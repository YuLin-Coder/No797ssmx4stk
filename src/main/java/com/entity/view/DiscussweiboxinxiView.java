package com.entity.view;

import com.entity.DiscussweiboxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 微博信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-24 20:24:34
 */
@TableName("discussweiboxinxi")
public class DiscussweiboxinxiView  extends DiscussweiboxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussweiboxinxiView(){
	}
 
 	public DiscussweiboxinxiView(DiscussweiboxinxiEntity discussweiboxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussweiboxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
