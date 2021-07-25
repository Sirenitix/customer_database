package com.suleevn.springboot.web.model;

import javax.validation.constraints.Size;

public class Todo {
    public int id;
    private String user;
    
    @Size(min=1, message="Enter at least 1 Characters...")
    private String desc;

    private String cnumber;


    public Todo() {
    		super();
    }
    
    public Todo(int id, String user, String desc, String cnumber) {
        super();
        this.id = id;
        this.user = user;
        this.desc = desc;
        this.cnumber = cnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) { this.cnumber = cnumber; }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Todo other = (Todo) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo [id=%s, user=%s, desc=%s, cnumber=%s]", id,
                user, desc, cnumber);
    }


}