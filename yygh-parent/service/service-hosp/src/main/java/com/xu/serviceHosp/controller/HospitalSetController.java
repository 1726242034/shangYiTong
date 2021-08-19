package com.xu.serviceHosp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xu.common.MD5;
import com.xu.common.exception.YyghException;
import com.xu.common.result.Result;
import com.xu.model.hosp.HospitalSet;
import com.xu.serviceHosp.mapper.HospitalSetMapper;
import com.xu.vo.hosp.HospitalSetQueryVo;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * <p>
 * 医院设置表 前端控制器
 * </p>
 *
 * @author xuJunNan
 * @since 2021-07-08
 */
@Controller
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {

	@Autowired
	private HospitalSetMapper hospitalSetMapper;


	@ApiModelProperty(value = "获取所有医院设置 ")
	@RequestMapping("/findAll")
	@ResponseBody
	public Result<List<HospitalSet>> findAllController(){
		return Result.ok(hospitalSetMapper.selectList(null));
	}

	@ApiModelProperty(value = "逻辑删除医院设置")
	@RequestMapping("{id}")
	public Result deleteByIdController(@PathVariable Long id){

		int i = hospitalSetMapper.deleteById(id);
		if (i != 0) {
			return Result.ok();
		} else {
			return Result.fail();
		}
	}


	@ApiModelProperty(value = "条件查询分页返回")
	@PostMapping("/findPageHospSet/{current}/{limit}")
	@ResponseBody
	public Result findHospitalPage(@PathVariable(value = "current") Long current,	// 当前页数
								 @PathVariable(value = "limit") Long limit,	// 下一页
								 @RequestBody(required = false) HospitalSetQueryVo hospitalSetQueryVo){	// 查询条件 医院的名称、编号

		Page<HospitalSet> hospitalSetPage = new Page<>(current, limit);

		String hosname = hospitalSetQueryVo.getHosname();
		String hoscode = hospitalSetQueryVo.getHoscode();

		Page<HospitalSet> hospitalPage = hospitalSetMapper.selectPage(hospitalSetPage,
				new QueryWrapper<HospitalSet>().like("hosname", hosname).eq("hoscode", hoscode)
		);

		return Result.ok(hospitalPage.getRecords());	// 获取分页数据
	}


	@ApiModelProperty(value = "添加医院设置")
	@PostMapping("/saveHospitalSet")
	public Result saveHospitalSet(HospitalSet hospitalSet){
		hospitalSet.setStatus(1);

		hospitalSet.setSignKey(MD5.encrypt(System.currentTimeMillis() + "" + new Random().nextInt(100)));

		int insert = hospitalSetMapper.insert(hospitalSet);

		if (insert != 0){
			return Result.ok();
		}else {
			return Result.fail();
		}
	}


	@ApiModelProperty(value = "根据ID获取医院设置")
	@GetMapping("/getHostSet/{id}")
	@ResponseBody
	public Result getHostSet(@PathVariable Long id){
		return Result.ok(hospitalSetMapper.selectById(id));
	}

	@ApiModelProperty(value = "修改医院设置")
	@PostMapping("/updateHospitalSet")
	@ResponseBody
	public Result updateHospitalSet(HospitalSet hospitalSet){
		int i = hospitalSetMapper.updateById(hospitalSet);

		if (i != 0) {
			return Result.ok();
		}else {
			return Result.fail();
		}
	}

	@ApiModelProperty(value = "批量删除数据")
	@DeleteMapping("/batchRemove")
	public Result deleteHospital(List<Long> deleteList){
		int i = hospitalSetMapper.deleteBatchIds(deleteList);

		if (i != 0) {
			return Result.ok();
		}else {
			return Result.fail();
		}
	}

	@ApiModelProperty(value = "医院设置的锁定和解锁")
	@PutMapping("/lockHospitalSet/{id}/{status}")
	@ResponseBody
	public Result lockHospitalSet(@PathVariable(value = "id") Long id,
								  @PathVariable(value = "status") Integer status){

		try {
			int i = 10 / 0;
		}catch (java.lang.ArithmeticException e){
			throw new YyghException("失败了 零不能做除数", 200);
		}

		// 查找要修改的行
		HospitalSet hospitalSet = hospitalSetMapper.selectById(id);
		hospitalSet.setStatus(status);

		// 把更新过的对象刷新到数据库内
		hospitalSetMapper.updateById(hospitalSet);

		return Result.ok();

	}


}
















