package com.intro.beans;

import org.springframework.stereotype.Component;

@Component
public class Dept {
    private String deptName;

    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}