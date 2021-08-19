package com.xu.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xu.model.cmn.Dict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DictService extends IService<Dict> {
	List<Dict> findChiData(Long id);
}
