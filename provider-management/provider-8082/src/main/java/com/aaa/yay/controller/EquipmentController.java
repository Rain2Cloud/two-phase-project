package com.aaa.yay.controller;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.CommonController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.Equipment;
import com.aaa.yay.service.EquipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author 十八
 * @Date 2020/7/20 22:24
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/equipment")
public class EquipmentController extends CommonController<Equipment> {

   @Autowired
   private EquipmentService equipmentService;
    @Override
    public BaseService<Equipment> getBaseService() {
        return equipmentService;
    }

    /**
    * @Auther: czb
    * @Description:
     * 分页查询设备信息
    * @Date: 2020/7/20 22:39
    * @param [equipment, pageNo, pageSize]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/selectAllEquipment")
    public ResultData selectAllEquipment(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
       List <Equipment> equipmentList = getBaseService().selectByFileds(pageNo, pageSize, null, null, null, (String[]) null);
        if (equipmentList.size() > 0 ){
            return  operationSuccess(equipmentList,"查询成功");
        }else {
            return operationFailed("查询失败");
        }


    }


}
