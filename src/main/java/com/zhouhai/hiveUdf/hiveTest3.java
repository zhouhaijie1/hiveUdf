package com.zhouhai.hiveUdf;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import java.util.ArrayList;


/**
 * @author ZhouHaiJie
 * @date 2021/7/10
 * @time 14:24
 * desc:udt
 **/
public class hiveTest3 extends GenericUDTF {

//    这个初始化方法指定输出参数名称和参数类型
    @Override
    public StructObjectInspector initialize(StructObjectInspector argOIs) throws UDFArgumentException {

        //List集合，用于指定参数名称
        ArrayList<String> fieldNames = new ArrayList<String>();
        //用于指定输出参数的类型
        ArrayList<ObjectInspector> fieldOIs = new ArrayList<ObjectInspector>();//ObjectInspector 参数类型检查器

        fieldNames.add("event_name");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("event_json");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);

        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames, fieldOIs);
    }

    @Override
    public void process(Object[] objects) throws HiveException {

        //一进多出条数据

    }

    @Override
    public void close() throws HiveException {

    }
}
