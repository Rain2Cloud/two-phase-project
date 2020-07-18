package com.aaa.yay.Controller;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.CommonController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.Dict;
import com.aaa.yay.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 十八
 * @Date 2020/7/17 21:13
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/dict")
public class DictController extends CommonController<Dict> {
        @Autowired
        private DictService dictService;

    @Override
    public BaseService<Dict> getBaseService() {
        return dictService;
    }


    /**
    * @Auther: czb
    * @Description:
     * 新增字典信息
    * @Date: 2020/7/17 21:22
    * @param [dict]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/addDict")
    public ResultData addDict(@RequestBody Dict dict){
        return dictService.addDict(dict);
    }

    /**
    * @Auther: czb
    * @Description:
     * 删除字典信息(根据主键)
    * @Date: 2020/7/17 21:27
    * @param [ids]
    * @return com.aaa.yay.base.ResultData
    */
    @DeleteMapping("/delDictsById")
    public ResultData delDictsById(@RequestBody List<Long> ids){
        return dictService.delDictsById(ids);
    }
    /**
    * @Auther: czb
    * @Description:
     *修改字典信息
    * @Date: 2020/7/17 21:32
    * @param [dict]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/updateDict")
    public ResultData updateDict(Dict dict){
        return dictService.updateDict(dict);
    }

        /**
        * @Auther: czb
        * @Description:
         * 查询全部字典信息分页
        * @Date: 2020/7/17 22:04
        * @param [pageNo, pageSize]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/selectAllDictByPage")
    public ResultData selectAllDictByPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){

        List<Dict>  dictList =  getBaseService().selectByFileds(pageNo,pageSize,null, null, null, (String[]) null);
        if ( dictList.size()> 0 ){
            return super.operationSuccess(dictList,"查询成功");
        }
        return super.operationFailed("查询失败");

    }

}
