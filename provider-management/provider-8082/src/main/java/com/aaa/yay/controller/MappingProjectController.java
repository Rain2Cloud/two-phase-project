package com.aaa.yay.controller;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.CommonController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.MappingProject;
import com.aaa.yay.service.MappingProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

import static com.aaa.yay.status.OperationStatus.SELECT_DATA_BY_ID_SUCCESS;
import static com.aaa.yay.status.OperationStatus.SELECT_DATA_SUCCESS;

/**
 * @Author 十八
 * @Date 2020/7/22 20:38
 * @Version 1.0
 */
@RequestMapping("/project")
@RestController
public class MappingProjectController extends CommonController<MappingProject> {

    @Autowired
    private MappingProjectService mappingProjectService;


    /**
    * @Auther: czb
    * @Description:
     * 测绘项目管理，项目名称模糊查询，类型 ，日期精确查
    * @Date: 2020/7/22 20:49
    * @param [mappingProject]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/projectSelect")
    public ResultData projectSelect (@RequestBody MappingProject mappingProject){
        ResultData resultMap =mappingProjectService.projectSelect(mappingProject);
        if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.getCode())){
            return super.selectSuccess(resultMap.getData());
        }else{
            return super.selectFailed();
        }
    }
        /**
        * @Auther: czb
        * @Description:
         * 通过字段查询所有的类型和开工日期。分组
        * @Date: 2020/7/22 20:50
        * @param [name]
        * @return com.aaa.yay.base.ResultData
        */
    @PostMapping("/SelectGroupName")
    public ResultData SelectGroupName(@RequestParam("name") String name){
        Map<String, Object> resultMap = mappingProjectService.SelectGroupName(name);
        if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.selectSuccess(resultMap.get("data"));
        }else{
            return super.selectFailed();
        }
    }


    /**
    * @Auther: czb
    * @Description:
     * 通过id查询测绘工程的详细信息
    * @Date: 2020/7/22 20:55
    * @param [id]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/projectDetail")
    public ResultData projectDetail (@RequestParam("id") String id){
        Map<String,Object> resultMap = mappingProjectService.projectDetail(id);
        if (SELECT_DATA_BY_ID_SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.selectSuccess(resultMap.get("data"));
       }else{
           return super.selectFailed();
       }
    }


    /**
    * @Auther: czb
    * @Description:
     * 查询项目
    * @Date: 2020/7/22 20:57
    * @param [userId]
    * @return java.util.List<com.aaa.yay.model.MappingProject>
    */
    @PostMapping("/allPro")
    public List<MappingProject> selectAllPros(@RequestParam("userId") Long userId){
        try {
            List<MappingProject> manProjects = mappingProjectService.selectAllPros(userId);
            return manProjects;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
    * @Auther: czb
    * @Description:
     * 通过id查询项目
    * @Date: 2020/7/22 20:57
    * @param [id]
    * @return com.aaa.yay.model.MappingProject
    */
    @GetMapping("/selectById")
    public MappingProject selectById(@RequestParam("id") Long id){
        try {
            MappingProject manProject = mappingProjectService.selectById(id);
            if (!"".equals(manProject) && null != manProject){
                return manProject;
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


        /**
        * @Auther: czb
        * @Description:
         * 根据id修改项目
        * @Date: 2020/7/22 20:58
        * @param [manProject]
        * @return java.lang.Integer
        */
    @PostMapping("/updateById")
    public Integer updateById(@RequestBody MappingProject manProject){
        try {
            Integer integer = mappingProjectService.updateById(manProject);
            return integer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
    * @Auther: czb
    * @Description:
     * 添加项目
    * @Date: 2020/7/23 8:41
    * @param [mappingProject]
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/addProject")
    public ResultData addProject (@RequestBody MappingProject mappingProject){
        return mappingProjectService.addProject(mappingProject);
    }


    @Override
    public BaseService<MappingProject> getBaseService() {
        return mappingProjectService;
    }
}
