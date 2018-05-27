package com.qiwenfei.note.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * 2018-05-27
 * sunshine
 *
 * BOSS---PM----STAFF
 * PM接收到需求后他本身不实现需求；先权衡（策略模式）、在调用相应的人员实现（代理模式）
 * 委派模型：静态代理与策略结合的一种特例
 *
 */
public class PM implements Employee{

    private Map<String,Employee> hander = new HashMap<String,Employee>();
    private  String commond  ;
    public  PM(String commond){//策略模式
        hander.put("MD5",new StaffA());
        hander.put("LOGIN",new StaffB());
        this.commond = commond;
    }

    @Override
    public void work() {
        System.out.println("接收到需求，现在安排人处理");
        Employee employee = hander.get(commond);
        employee.work();
    }

}
