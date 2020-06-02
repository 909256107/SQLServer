package com.dfq.putao.domain;

/**
 * @author Mr Duan
 * @create 2020-06-02 16:44
 */
public class Putao {
    private Integer id;
    private  Integer pid;
    private  String name;
    private String project;

    @Override
    public String toString() {
        return "Putao{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", project='" + project + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
