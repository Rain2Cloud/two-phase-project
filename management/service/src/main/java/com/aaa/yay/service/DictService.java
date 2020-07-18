package com.aaa.yay.service;

import com.aaa.yay.base.BaseService;
import com.aaa.yay.base.ResultData;
import com.aaa.yay.mapper.DictMapper;
import com.aaa.yay.model.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

import static com.aaa.yay.status.OperationStatus.*;


/**
 * @Author 十八
 * @Date 2020/7/17 16:52
 * @Version 1.0
 */
@Service
public class DictService extends BaseService<Dict> {

         @Autowired
        private DictMapper dictMapper;


        /**
        * @Auther: czb
        * @Description:
         *新增字典信息
        * @Date: 2020/7/17 17:04
        * @param [dict]
        * @return com.aaa.yay.base.ResultData
        */
    public ResultData addDict(Dict dict){
            ResultData resultData = new ResultData();
            int addResult = dictMapper.insert(dict);
            if (addResult > 0){
                return  resultData.setCode(ADD_SUCCESS.getCode()).setMsg(ADD_SUCCESS.getMsg());
            }
            return  resultData.setCode(ADD_FAILED.getCode()).setMsg(ADD_FAILED.getMsg());
        }

        /**
        * @Auther: czb
        * @Description:
         *根据id批量删除
        * @Date: 2020/7/17 17:24
        * @param [ids]
        * @return com.aaa.yay.base.ResultData
        */
    public ResultData delDictsById(List<Long> ids){
        ResultData resultData = new ResultData();
        Example example = Example.builder(Dict.class).where(Sqls.custom().andIn("dictId",ids)).build();
        int i = dictMapper.deleteByExample(example);
                if (i >0){
                    return resultData.setCode(DEL_SUCCESS.getCode()).setMsg(DEL_SUCCESS.getMsg());
                }
                    return resultData.setCode(DEL_FAILED.getCode()).setMsg(DEL_FAILED.getMsg());
        }

        /**
        * @Auther: czb
        * @Description:
         * 根据id进行修改字典信息
        * @Date: 2020/7/17 18:33
        * @param [dict]
        * @return com.aaa.yay.base.ResultData
        */
        public ResultData updateDict(Dict dict) {
            ResultData resultData = new ResultData();
            int i = dictMapper.updateByPrimaryKeySelective(dict);
            if (i > 0) {
                return resultData.setCode(UPDATE_SUCCESS.getCode()).setMsg(UPDATE_SUCCESS.getMsg());
            }
            return resultData.setCode(UPDATE_FAILED.getCode()).setMsg(UPDATE_FAILED.getMsg());

        }

}
