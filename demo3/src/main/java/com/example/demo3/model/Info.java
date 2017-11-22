package com.example.demo3.model;

public class Info {
    private String name;
    private String tel;
    private String address;
    private String goods;
    private Integer count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public Info() {
        super();
    }

    public Info(String name, String tel, String address, String goods, Integer count) {
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.goods = goods;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", goods='" + goods + '\'' +
                ", count=" + count +
                '}';
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
