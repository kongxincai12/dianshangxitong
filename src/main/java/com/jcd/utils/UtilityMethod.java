package com.jcd.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import javax.servlet.http.HttpServletResponse;



public class UtilityMethod {
    public static <T,V> List<T> findObjFromList(List<T> list,String methodName,V value) {

        Predicate predicate = new Predicate() {

            @Override
            public boolean evaluate(Object obj) {
                // TODO Auto-generated method stub
                try {
                    Method method = obj.getClass().getMethod(methodName);
                    @SuppressWarnings("unchecked")
                    V keyName = (V) method.invoke(obj);
                    return keyName.equals(value);
                }
                catch (Exception e) {
                    return false;
                }
            }
        };

        System.out.println("baseMethod"+value);

        List<T> result = (List<T>) CollectionUtils.select( list, predicate);
        return result;

    }
    public static String GetUUID(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

    public static void doRequest(HttpServletResponse response,JSONObject Request,int code,boolean status,String message) throws IOException {

        Request.put("code", code);
        Request.put("status", status);
        Request.put("message", message);
        response.getWriter().print(Request);

    }

}
