package com.aaa.yay.controller;

import com.aaa.yay.base.BaseController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.MappingProject;
import com.aaa.yay.service.MappingApi;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 十八
 * @Date 2020/7/22 21:08
 * @Version 1.0
 */
@RestController
@RequestMapping("/project")
public class MappingProjectController extends BaseController {
    @Autowired
    private MappingApi mappingApi;


        /**
        * @Auther: czb
        * @Description:
         * 测绘项目管理，项目名称模糊查询，类型 ，日期精确查
        * @Date: 2020/7/22 21:13
        * @param [mappingProject]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/projectSelect")
    public ResultData projectSelect(@RequestBody MappingProject mappingProject){
        return mappingApi.projectSelect(mappingProject);
    }


        /**
        * @Auther: czb
        * @Description:
         *通过字段查询所有的类型和开工日期。分组
        * @Date: 2020/7/22 21:14
        * @param [name]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/SelectGroupName")
    public ResultData  SelectGroupName(@RequestParam("name") String name){
        return mappingApi.SelectGroupName(name);
    }

    /**
    * @Auther: czb
    * @Description:
     * 通过id查询测绘工程的详细信息
    * @Date: 2020/7/22 21:16
    * @param [id]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/projectDetail")
   public ResultData projectDetail(@RequestParam("id") String id){
        return mappingApi.projectDetail(id);
    }

    /**
    * @Auther: czb
    * @Description:
     * 查询项目信息
    * @Date: 2020/7/22 21:19
    * @param [userId]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/allPro")
    public ResultData selectAllPro(@RequestParam("userId") Long userId) {
        List<MappingProject> manProjects = mappingApi.selectAllPros(userId);
        if (manProjects.size()>0){
            return super.selectSuccess(manProjects);
        }
        return super.selectFailed();
    }

   /**
   * @Auther: czb
   * @Description:
    * 根据主键查询项目信息
   * @Date: 2020/7/22 21:21
   * @param [id]
   * @return com.aaa.yay.base.ResultData
   */
    @GetMapping("/selectById")
    public ResultData selectProById(Long id){
        MappingProject manProject = mappingApi.selectById(id);
        if (!"".equals(manProject) && null != manProject){
            return super.selectSuccess(manProject);
        }
        return super.selectFailed();
    }


   /**
   * @Auther: czb
   * @Description:
    * 根据id修改项目信息
   * @Date: 2020/7/22 21:20
   * @param [manProject]
   * @return com.aaa.yay.base.ResultData
   */
    @PostMapping("/updateById")
    public ResultData updateById(@RequestBody MappingProject manProject){
        Integer i = mappingApi.updateById(manProject);
        if (null != i && i > 0){
            return super.updateSuccess();
        }
        return super.updateFailed();
    }

    /**
    * @Auther: czb
    * @Description:
     * 添加项目
    * @Date: 2020/7/23 8:47
    * @param [mappingProject]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/addProject")
    public  ResultData addProject(@RequestBody MappingProject mappingProject){
        return mappingApi.addProject(mappingProject);
    }


}
