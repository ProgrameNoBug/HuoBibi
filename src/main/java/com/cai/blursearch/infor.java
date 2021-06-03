package com.cai.blursearch;

public class infor {
	private String id;
	private String name;
	private double price;
	private String url;
	private String pic;
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public double getprice() {
        return price;
    }

    public void setprice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getpic() {
        return pic;
    }

    public void setpic(String pic) {
        this.pic = pic;
    }
    
    public infor(String id, String name, double price, String url, String pic) {
    	super();
    	this.id = id;
    	this.name = name;
    	this.price = price;
    	this.url = url;
    	this.pic = pic;
    }


}
