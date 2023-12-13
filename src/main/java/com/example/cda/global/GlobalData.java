package com.example.cda.global;

import java.util.ArrayList;
import java.util.List;

import com.example.cda.model.Products;

public class GlobalData {
	public static List<Products> cart;
	
	static {
		cart = new ArrayList<Products>();
	}
}
