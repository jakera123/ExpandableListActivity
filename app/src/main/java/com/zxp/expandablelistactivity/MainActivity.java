package com.zxp.expandablelistactivity;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ExpandableListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //存放一级条目
        List<Map<String,String>> groups=new ArrayList<Map<String,String>>();
        Map<String,String> group1=new HashMap<String,String>();
        group1.put("group","group1");
        Map<String,String> group2=new HashMap<String,String>();
        group2.put("group","group2");
        groups.add(group1);
        groups.add(group2);
        //定义一个List，该List对象为第一个一级条目提供二级条目的数据
        List<Map<String,String>> child1=new ArrayList<Map<String,String>>();
        Map<String,String> child1Data1=new HashMap<String,String>();
        child1Data1.put("child","child1Data1");
        Map<String,String> child1Data2=new HashMap<String,String>();
        child1Data2.put("child","child1Data2");
        child1.add(child1Data1);
        child1.add(child1Data2);
        //定义一个List，该List对象为第二个一级条目提供二级条目的数据
        List<Map<String,String>> child2=new ArrayList<Map<String,String>>();
        Map<String,String> child2Data=new HashMap<String,String>();
        child2Data.put("child","child2Data");
        child2.add(child2Data);
        List<List<Map<String,String>>> childs=new ArrayList<List<Map<String,String>>>();
        childs.add(child1);
        childs.add(child2);
        //1、context  2、一级条目的数据 3、用来设置一级条目样式的布局文件4、指定一有条目的KEY
        //5、指定一级条目数据显示控件的ID 6、指定二级条目的数目 7、用来设置二级条目的样式的布局文件
        //8、指定二级条目数据的Key   9、指定二级条目数据显示控件的ID
        SimpleExpandableListAdapter sela=new SimpleExpandableListAdapter(this,groups,R.layout.group,new String[]{"group"},new int[]{R.id.groupTo},childs,R.layout.child,new String[]{"child"},new int[]{R.id.childTo});
        setListAdapter(sela);

    }
}
