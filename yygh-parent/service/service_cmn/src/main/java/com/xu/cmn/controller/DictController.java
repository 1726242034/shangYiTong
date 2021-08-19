package com.xu.cmn.controller;

import com.xu.cmn.service.DictService;
import com.xu.common.result.Result;
import com.xu.model.cmn.Dict;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(description = "数据字典接口")
@RestController
@RequestMapping("/admin/cmn/dict")
//@CrossOrigin
public class DictController {

	@Autowired
	private DictService dictService;

//	根据数据的ID查询其子数据
	@GetMapping("/findChildData/{id}")
	public Result findChildData(@PathVariable Long id){
		List<Dict> list = dictService.findChiData(id);

		return Result.ok(list);
	}

}
