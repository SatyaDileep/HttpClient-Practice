package com.satyadileep.practice.model;

/**
 * Created by Dillugadu on 16-02-2017.
 */
public class ResponsePojo {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String id;
    private String name;

    public ResponsePojo(){

    }

    public ResponsePojo(String name, String id) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ResponsePojo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
