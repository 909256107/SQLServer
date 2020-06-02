package com.dfq.putao.domain;

/**
 * @author Mr Duan
 * @create 2020-06-02 16:44
 */
public class PutaoCharacter {
    private Integer id;
    private  Integer pid;
    private String color;
    private String froms;
    private  String status;

    @Override
    public String toString() {
        return "PutaoCharacter{" +
                "id=" + id +
                ", pid=" + pid +
                ", color='" + color + '\'' +
                ", froms='" + froms + '\'' +
                ", status='" + status + '\'' +
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFroms() {
        return froms;
    }

    public void setFroms(String froms) {
        this.froms = froms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
