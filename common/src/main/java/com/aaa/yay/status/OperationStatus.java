package com.aaa.yay.status;

/**
 * @Author yay
 * @Description 操作状态码
 * @CreatTime 2020年 07月12日 星期日 19:21:16
 */
public enum OperationStatus {

    SUCCESS("1","操作成功"),
    FAILED("2", "操作失败"),
    DELETE_OPERATION("3", "删除操作"),
    UPDATE_OPERATION("4", "修改操作"),
    INSERT_OPERATION("5", "新增操作"),
    ZUUL_FILTER_SUCCESS("6", "路由过滤成功"),
    ZUUL_FILTER_FAILED("7", "路由过滤失败"),
    ZUUL_FILTER_TOKEN_SUCCESS("8", "token值存在"),
    ZUUL_FILTER_TOKEN_FAILED("9", "token值不存在"),
    REQUEST_IS_NULL("10", "request对象为null"),
    ADD_SUCCESS("11","添加数据成功"),
    ADD_FAILED("12","添加数据失败"),
    ADD_ERROR("13","系统异常！"),
    DEL_SUCCESS("14","删除成功"),
    DEL_FAILED("15","删除失败"),
    DEL_NOT_EXIT("16","请选中数据，稍后重试！！！"),
    DEL_ERROR("17","操作异常"),
    UPDATE_SUCCESS("18", "修改数据成功"),
    UPDATE_FAILED("19", "修改数据失败"),
    UPDATE_EXIST("20","该数据已存在，请修改后重试！"),
    UPDATE_NULL("21","传入数据为空"),
    SELECT_DATA_SUCCESS("22", "查询数据成功"),
    SELECT_DATA_FAILED("23", "查询数据失败"),
    SELECT_DATA_NOT_EXIST("24","数据不存在！"),
    SELECT_DATA_BY_ID_SUCCESS("25","根据ID查询数据成功！"),
    SELECT_DATA_BY_ID_FAILED("26","根据ID查询数据失败！");
    
    /**
    * 
    * @author yay
    * @param code msg
    * @updateTime 2020/07/12 20:01 
    * @throws 
    * @return 
    */
    OperationStatus(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
}
