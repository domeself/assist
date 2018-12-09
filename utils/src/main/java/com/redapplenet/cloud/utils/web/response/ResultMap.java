package com.redapplenet.cloud.utils.web.response;

import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR liuqn
 * @DATE 2018/12/4 15:12
 * @VERSION v1.0
 * @DESCRIPTION TODO
 */

public class ResultMap extends ResultResponse<Map> {
    private Map data;
    public ResultMap() {
        this("0", "success");
        this.data = new HashMap();
    }
    public ResultMap(String code, String message) {
        setCode(code);
        setMessage(message);
    }

    public void putData(String key,Object obj){
        if(data!=null){
            this.data.put(key,obj);
        }
    }
    public Object getDate(String key){
        if(data==null){
            return null;
        }
        return this.data.get(key);
    }

}
