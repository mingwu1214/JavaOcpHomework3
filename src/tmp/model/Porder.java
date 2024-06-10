package model;

import java.io.Serializable;

public class Porder implements Serializable {
	private Integer id;
	private String name;
	private Integer a;
	private Integer b;
	private Integer c;
	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Porder(String name, Integer a, Integer b, Integer c) {
		super();
		this.name = name;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getA() {
		return a;
	}
	public void setA(Integer a) {
		this.a = a;
	}
	public Integer getB() {
		return b;
	}
	public void setB(Integer b) {
		this.b = b;
	}
	public Integer getC() {
		return c;
	}
	public void setC(Integer c) {
		this.c = c;
	}
}
