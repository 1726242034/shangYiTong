package com.xu.cmn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xu.cmn.mapper.DictMapper;
import com.xu.cmn.service.DictService;
import com.xu.model.cmn.Dict;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

	@Override
	public List<Dict> findChiData(Long id) {

//		用户输入的id的子目录
		List<Dict> dictList = baseMapper.selectList(new QueryWrapper<Dict>().eq("parent_id", id));

//		写hashChildren
		for (Dict dict : dictList) {
//			如果没有子数据 就写成false 有子数据就为true（判断数据的父id是否等于当前对象的id，等于就表示当前对象存在子数据 否则不存在）
			boolean children = baseMapper.selectCount(new QueryWrapper<Dict>().eq("parent_id", dict.getId())) > 0 ? true : false;
			dict.setHasChildren(children);
		}
		return dictList;
	}

}
