package com.zhouhai.hiveUdf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.regex.Pattern;

/**
 * @author ZhouHaiJie
 * @date 2021/7/9
 * @time 22:28
 * 测试udf
 **/
public class hiveTest1 extends UDF {

    //重写父类方法
    public Integer evaluate(String str){

        //正则匹配
        String p ="[A-Z]{14,15}";

        //开始匹配
        boolean isFlag = Pattern.compile(p).matcher(str).find();
        //开始做判断
        if (isFlag){
            return 1;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {

        String str = "HHHHHHHHHHHHHJK";
        hiveTest1 hiveTest1 = new hiveTest1();
        System.out.println(hiveTest1.evaluate(str));
    }
}
