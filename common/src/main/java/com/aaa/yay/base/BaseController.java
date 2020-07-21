package com.aaa.yay.base;

import static com.aaa.yay.status.LoginStatus.*;
import static com.aaa.yay.status.OperationStatus.*;
import static com.aaa.yay.status.OperationStatus.SELECT_DATA_BY_ID_FAILED;

/**
 * @author yay
 * @description 统一controller
 * 也就是说所有的controller都需要继承这个controller，进行统一返回
 * code:200 msg:登录成功
 * code:400 msg:登录失败，系统异常
 * code:201 msg:用户已经存在
 * code:401 msg:用户不存在
 * code:402 msg:密码错误
 * code:405 msg:用户退出异常
 * @creatTime 2020年 07月08日 星期三 21:53:23
 */
public class BaseController {

    /**
     * 登录成功，使用系统消息
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/08 22:02
     */
    protected ResultData loginSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 登录成功，使用自定义消息
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/08 22:02
     */
    protected ResultData loginSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 登录成功，返回数据信息，使用系统消息
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/08 22:02
     */
    protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * 登录成功，返回数据信息，使用自定义消息
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/08 22:02
     */
    protected ResultData loginSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

//    /**
//     * 登录失败，返回系统消息!!!!!!!(多余  没有删除  注释了)
//     *
//     * @param
//     * @return com.aaa.yay.base.ResultData
//     * @throws
//     * @author yay
//     * @updateTime 2020/07/08 22:22
//     */
//    protected ResultData loginFailed() {
//        ResultData resultData = new ResultData();
//        resultData.setCode(LOGIN_FAILED.getCode());
//        resultData.setMsg(LOGIN_FAILED.getMsg());
//        return resultData;
//    }

    /**
     * 登录失败，返回系统消息，详细解释说明
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/08 22:22
     */
    protected ResultData loginFailed(String detail) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * 操作成功，返回系统消息
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/12 20:49
     */
    protected ResultData operationSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        return resultData;
    }

    /**
    * 操作成功，返回自定义消息
    * @author yay
    * @param
    * @updateTime 2020/07/16 20:13
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    protected ResultData operationSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 操作成功，返回数据，返回系统消息
     *
     * @param data
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/14 9:57
     */
    protected ResultData operationSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
    * 操作成功，返回数据，返回自定义消息
    * @author yay
    * @param data msg
    * @updateTime 2020/07/17 11:13
    * @throws
    * @return com.aaa.yay.base.ResultData
    */
    protected ResultData operationSuccess(Object data,String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * 操作失败，返回系统消息
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/12 20:52
     */
    protected ResultData operationFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        return resultData;
    }

    /**
     * 操作失败，返回自定义消息
     *
     * @param msg
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/14 9:59
     */
    protected ResultData operationFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 删除操作，返回系统消息
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/12 20:56
     */
    protected ResultData deleteOperation() {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_OPERATION.getCode());
        resultData.setMsg(DELETE_OPERATION.getMsg());
        return resultData;
    }

    /**
     * 修改操作，返回系统消息
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/12 20:57
     */
    protected ResultData updateOperation() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_OPERATION.getCode());
        resultData.setMsg(UPDATE_OPERATION.getMsg());
        return resultData;
    }


    /**
     * @Description: 超时退出
     * @Author: czb
     * @Date: 2020/7/18 16:00
     * @Param: []
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData loginTimeoutExit() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_TIMEOUT_EXIT.getCode());
        resultData.setMsg(LOGIN_TIMEOUT_EXIT.getMsg());
        return resultData;
    }

    /**
     * 新增操作，返回系统消息
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/12 21:00
     */
    protected ResultData insertOperation() {
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_OPERATION.getCode());
        resultData.setMsg(INSERT_OPERATION.getMsg());
        return resultData;
    }

    /**
     * 路由过滤成功，返回系统消息
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/12 21:04
     */
    protected ResultData zuulFilterSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 路由过滤失败，返回系统消息
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/12 21:06
     */
    protected ResultData zuulFilterFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_FAILED.getMsg());
        return resultData;
    }

    /**
     * token值存在，返回系统消息
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/12 21:08
     */
    protected ResultData zuulFilterTokenSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * token值不存在，返回系统消息
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/12 21:10
     */
    protected ResultData zuulFilterTokenFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_FAILED.getMsg());
        return resultData;
    }

    /**
     * request对象为null，返回系统消息
     *
     * @param
     * @return com.aaa.yay.base.ResultData
     * @throws
     * @author yay
     * @updateTime 2020/07/12 21:12
     */
    protected ResultData requestIsNull() {
        ResultData resultData = new ResultData();
        resultData.setCode(REQUEST_IS_NULL.getCode());
        resultData.setMsg(REQUEST_IS_NULL.getMsg());
        return resultData;
    }




    /**
     * @Description: 登录失败，使用系统消息
     * @Author: czb
     * @Date: 2020/7/1622:32
     * @Param: []
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData loginFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description: 添加数据成功，返回系统消息
     * @Author: czb
     * @Date: 2020/7/1623:18
     * @Param: []
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData addSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_SUCCESS.getCode());
        resultData.setMsg(ADD_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description: 添加数据成功，返回自定义消息
     * @Author: czb
     * @Date: 2020/7/1623:19
     * @Param: [msg]
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData addSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 添加数据失败，返回系统消息
     * @Author: czb
     * @Date: 2020/7/1623:21
     * @Param: []
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData addFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_FAILED.getCode());
        resultData.setMsg(ADD_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description: 添加数据失败，返回自定义消息
     * @Author: czb
     * @Date: 2020/7/1623:20
     * @Param: [msg]
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData addFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }


    /**
     * @Description: 删除数据成功，返回系统消息
     * @Author: czb
     * @Date: 2020/7/1623:23
     * @Param: []
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData deleteSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(DEL_SUCCESS.getCode());
        resultData.setMsg(DEL_SUCCESS.getMsg());
        return resultData;
    }


    /**
     * @Description: 删除数据成功，返回自定义消息
     * @Author: czb
     * @Date: 2020/7/1623:24
     * @Param: [msg]
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData deleteSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DEL_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 删除数据失败
     * @Author: czb
     * @Date: 2020/7/1623:25
     * @Param: []
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData deleteFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(DEL_FAILED.getCode());
        resultData.setMsg(DEL_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description: 删除数据失败，返回自定义数据
     * @Author: czb
     * @Date: 2020/7/1623:25
     * @Param: [msg]
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData deleteFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DEL_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }


    /**
     * @Description: 删除的数据不存在，删除失败
     * @Author: czb
     * @Date: 2020/7/1623:26
     * @Param: []
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData deleteDataNotExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(DEL_NOT_EXIT.getCode());
        resultData.setMsg(DEL_NOT_EXIT.getMsg());
        return resultData;
    }

    /**
     * @Description: 出现未知错误，请稍后再试！
     * @Author: czb
     * @Date: 2020/7/1623:27
     * @Param: []
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData deleteDataError(){
        ResultData resultData = new ResultData();
        resultData.setCode(DEL_ERROR.getCode());
        resultData.setMsg(DEL_ERROR.getMsg());
        return resultData;
    }

    /**
     * @Description: 修改数据成功
     * @Author: czb
     * @Date: 2020/7/1623:27
     * @Param: []
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData updateSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        return resultData;
    }


    /**
     * @Description: 修改数据成功，返回自定义消息
     * @Author: czb
     * @Date: 2020/7/1623:28
     * @Param: [msg]
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData updateSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 修改数据失败
     * @Author: czb
     * @Date: 2020/7/1623:28
     * @Param: []
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData updateFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        return resultData;
    }


    /**
     * @Description: 修改数据失败，返回自定义消息
     * @Author: czb
     * @Date: 2020/7/1623:29
     * @Param: [msg]
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData updateFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }


    /**
     * @Description: 要修改的数据已存在
     * @Author: czb
     * @Date: 2020/7/1623:30
     * @Param: []
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData updateDataExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_EXIST.getCode());
        resultData.setMsg(UPDATE_EXIST.getMsg());
        return resultData;
    }

    /**
     * @Description: 查询数据成功
     * @Author: czb
     * @Date: 2020/7/1623:31
     * @Param: [obj]
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData selectSuccess(Object obj){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_SUCCESS.getCode());
        resultData.setMsg(SELECT_DATA_SUCCESS.getMsg());
        resultData.setData(obj);
        return resultData;
    }


    /**
     * @Description: 查询数据成功，返回自定义消息
     * @Author: czb
     * @Date: 2020/7/1623:32
     * @Param: [obj, msg]
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData selectSuccess(Object obj,String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(obj);
        return resultData;
    }

    /**
     * @Description: 查询数据失败
     * @Author: czb
     * @Date: 2020/7/1623:32
     * @Param: []
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData selectFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_FAILED.getCode());
        resultData.setMsg(SELECT_DATA_FAILED.getMsg());
        return resultData;
    }


    /**
     * @Description: 查询数据失败，返回自定义消息
     * @Author: czb
     * @Date: 2020/7/1623:33
     * @Param: [msg]
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData selectFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 查询的数据不存在
     * @Author: czb
     * @Date: 2020/7/1623:34
     * @Param: []
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData selectDataNotExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_NOT_EXIST.getCode());
        resultData.setMsg(SELECT_DATA_NOT_EXIST.getMsg());
        return resultData;
    }

    /**
     * @Description: 查询的数据不存在，返回自定义消息
     * @Author: czb
     * @Date: 2020/7/1623:34
     * @Param: [msg]
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData selectDataNotExist(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_NOT_EXIST.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 根据ID查询数据成功
     * @Author: czb
     * @Date: 2020/7/1623:35
     * @Param: [obj]
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData selectByIdSuccess(Object obj){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_BY_ID_SUCCESS.getCode());
        resultData.setMsg(SELECT_DATA_BY_ID_SUCCESS.getMsg());
        resultData.setData(obj);
        return resultData;
    }

    /**
     * @Description: 根据ID查询数据成功，返回自定义消息
     * @Author: czb
     * @Date: 2020/7/1623:36
     * @Param: [obj,msg]
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData selectByIdSuccess(String msg,Object obj){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_BY_ID_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(obj);
        return resultData;
    }


    /**
     * @Description: 根据ID查询数据失败
     * @Author: czb
     * @Date: 2020/7/16 23:37
     * @Param: []
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData selectByIdFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_BY_ID_FAILED.getCode());
        resultData.setMsg(SELECT_DATA_BY_ID_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description: 根据ID查询数据失败，返回自定义消息
     * @Author: czb
     * @Date: 2020/7/1623:38
     * @Param: [msg]
     * @return: com.aaa.qy108.base.ResultData
     */
    protected ResultData selectByIdFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_BY_ID_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }





}
