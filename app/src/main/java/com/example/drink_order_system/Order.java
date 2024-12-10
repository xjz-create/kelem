package com.example.drink_order_system;
import java.util.ArrayList;

public class Order {
	private String order_number;
	private String time;
	private String takeAway;
	private String cost;
	private Flavor flavor;  // 关联的 Flavor 对象
	private Drinks drink;
	Order(String info)
	{
		String[] info_list = info.split(",");
		order_number = info_list[0];
		time = info_list[1];
		takeAway = info_list[2];
		cost = info_list[3];
		this.flavor = flavor; // 初始化 flavor
		this.drink = drink;
	}

	public String getOrder_number() {
		return order_number;
	}

	public String getTime() {
		return time;
	}

	public String getTakeAway() {
		return takeAway;
	}

	public String getCost() {
		return cost;
	}

	public Flavor getFlavor() {
		return flavor; // 新增方法，获取 flavor 信息
	}
	public Drinks getDrink() {
		return drink; // 新增方法，获取 flavor 信息
	}

}
