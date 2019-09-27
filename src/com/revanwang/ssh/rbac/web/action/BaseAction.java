package com.revanwang.ssh.rbac.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class BaseAction  extends ActionSupport implements Preparable {

    protected final String LIST = "list";

    protected void ActionContextPut(String name, Object value) {
        ActionContext.getContext().put(name, value);
    }

    /**
     * 会拦截所有的方法
     * 会在所有action执行前执行
     */
    @Override
    public void prepare() throws Exception {

    }
}
