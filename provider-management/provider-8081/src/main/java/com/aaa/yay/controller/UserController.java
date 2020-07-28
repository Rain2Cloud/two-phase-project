package com.aaa.yay.controller;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.CommonController;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.model.User;
import com.aaa.yay.service.UserService;
import com.aaa.yay.utils.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.yay.status.OperationStatus.*;

/**
 * @Author 十八
 * @Date 2020/7/16 15:04
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController extends CommonController<User> {
        @Autowired
        private UserService userService;

        /**
        * @Auther: czb
        * @Description:
         * 增加用户
        * @Date: 2020/7/16 20:32
        * @param [user]
        * @return com.aaa.yay.base.ResultData
        */
       @PostMapping("/addUser")
      public ResultData addUser(@RequestBody User user) {
          return userService.addUser(user);


       }

       /**
       * @Auther: czb
       * @Description:
        * 批量删除用户
       * @Date: 2020/7/16 21:23
       * @param [ids]
       * @return com.aaa.yay.base.ResultData
       */
       @DeleteMapping("/delUser")
       public ResultData delUser(@RequestBody List<Long> ids){
           return  userService.delUser(ids);
       }

       /**
       * @Auther: czb
       * @Description:
        * 修改用户信息
       * @Date: 2020/7/16 21:26
       * @param [user]
       * @return com.aaa.yay.base.ResultData
       */
        @PostMapping("/updateUser")
        public ResultData updateUser(@RequestBody User user){
           return userService.updateUser(user);
        }

//    /**
//     * @Auther: yay
//     * @Description:
//     *Excle导出用户信息
//     * @Date: 2020/7/16 22:36
//     * @param [response]
//     * @return void
//     */
//    @GetMapping("/exportExcle")
//    public void exportExcle(HttpServletResponse response){
//        Map<String, Object> map = userService.selectAll();
//        if (SELECT_DATA_SUCCESS.getCode().equals(map.get("code"))){
//            List<User> users = (List<User>) map.get("data");
//            //不为空，开始进行导出
//            if (null != users && !users.isEmpty()){
//                //list存放表格数据
//                List<List<String>> excelData = new ArrayList<List<String>>();
//                if(null != users){
//                    //表格头
//                    List<String> headList = new ArrayList<String>();
//                    headList.add("用户ID");
//                    headList.add("用户名");
//                    headList.add("部门ID");
//                    headList.add("邮箱");
//                    headList.add("联系电话");
//                    headList.add("状态");
//                    headList.add("创建时间");
//                    headList.add("修改时间");
//                    headList.add("最近访问时间");
//                    headList.add("性别");
//                    headList.add("描述");
//                    headList.add("用户类型");
//                    //把表头放入表格数据中
//                    excelData.add(headList);
//                    //遍历表格数据并放入excelData
//                    for (User user : users) {
//                        List<String> list = new ArrayList<String>();
//                        list.add(String.valueOf(user.getId()));
//                        list.add(String.valueOf(user.getUsername()));
//                        list.add(String.valueOf(user.getDeptId()));
//                        list.add(String.valueOf(user.getEmail()));
//                        list.add(String.valueOf(user.getMobile()));
//                        if ("0".equals(user.getStatus())){
//                            list.add("锁定");
//                        }else if ("1".equals(user.getStatus())){
//                            list.add("有效");
//                        }
//                        list.add(String.valueOf(user.getCreateTime()));
//                        list.add(String.valueOf(user.getModifyTime()));
//                        list.add(String.valueOf(user.getLastLoginTime()));
//                        if ("0".equals(user.getSsex())){
//                            list.add("男");
//                        }else if ("1".equals(user.getSsex())){
//                            list.add("女");
//                        }else if ("2".equals(user.getSsex())){
//                            list.add("保密");
//                        }
//                        list.add(String.valueOf(user.getDescription()));
//                        if ("0".equals(user.getType())){
//                            list.add("单位用户");
//                        }else if ("1".equals(user.getType())){
//                            list.add("审核用户");
//                        }else if ("2".equals(user.getType())){
//                            list.add("管理员");
//                        }
//                        //把数据放入excelData
//                        excelData.add(list);
//                    }
//
//                }
//                String sheetName = "用户信息";
//                String fileName = "用户信息表";
//                try {
//                    ExcelUtil.exportExcel(response, excelData, sheetName, fileName, 12);
//                } catch (IOException e) {
//                    log.error("用户信息数据导出失败！");
//                }
//
//            }
//        }else{
//            log.error("用户管理中的导出数据出错！");
//        }
//    }



    /**
    * @Auther: czb
    * @Description:
     *
    * @Date: 2020/7/17 9:34
    * @param []
    * @return com.aaa.yay.base.ResultData
    */
    @PostMapping("/selectAll")
    public ResultData selectAll(User user){
        ResultData resultData = userService.selectAll(user);
        return resultData;
    }


            /**
            * @Auther: czb
            * @Description:
             * 带条件的查询全部用户（分页）
            * @Date: 2020/7/17 10:45
            * @param [pageNo, pageSize]
            * @return com.aaa.yay.base.ResultData
            */
            @PostMapping("/selectAllUserPage")
            public ResultData selectAllUserPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
             List<User> userList =  getBaseService().selectByFileds(pageNo,pageSize,null, null, null, (String[]) null);
                if (userList.size()>0){
                    return super.operationSuccess(userList,"查询成功");
                }
             return super.operationFailed("查询失败");
            }


    /**
    * @Auther: czb
    * @Description: 带条件查询用户信息
    * @Date: 2020/7/20 20:55
    * @param [map]
    * @return com.aaa.yay.base.ResultData
    */
     @PostMapping("/selectUserAll")
     public ResultData selectUserAll(HashMap map){
        Map<String, Object> userAll = userService.selectUserAll(map);
        if (SELECT_DATA_SUCCESS.getCode().equals(userAll.get("code"))){
            return super.selectSuccess(userAll);
        }else if (SELECT_DATA_FAILED.getCode().equals(userAll.get("code"))){
            return super.selectFailed();
        }else{
            return super.selectFailed(SELECT_DATA_NOT_EXIST.getMsg());
        }
    }





    @Override
    public BaseService<User> getBaseService() {
        return userService;
    }

}
