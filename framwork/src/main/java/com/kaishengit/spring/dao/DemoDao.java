package com.kaishengit.spring.dao;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class DemoDao {
    private Integer port;
    private String name;
    private List<String> list;
    private Set<String> set;
    private Map<String,Object> map;
    private Properties prop;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }
}
