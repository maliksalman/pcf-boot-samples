package com.smalik.sample.learnmvc;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Bean {

	@NotNull
	@Size(min=2, max=30)
	private String name;

	@NotNull
	@Min(5)
	private int val;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
}
