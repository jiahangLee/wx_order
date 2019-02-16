package com.jiahanglee.journey.utils;

import com.jiahanglee.journey.vo.ResultVo;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 17:06
 * @Description: //TODO
 * @version: V1.0
 */
public class ResultVoUtil {

    public static ResultVo success(Object object){

        ResultVo resultVo = new ResultVo();
        resultVo.setData(object);
        resultVo.setMsg("成功");
        resultVo.setCode(0);
        return resultVo;
    }

    public static ResultVo success(){
        return success(null);
    }

    public static ResultVo error(Integer code,String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
