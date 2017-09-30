package model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private String sex;

    public User(int id_, String name_, String sex_) {
        id = id_;
        name = name_;
        sex = sex_;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
