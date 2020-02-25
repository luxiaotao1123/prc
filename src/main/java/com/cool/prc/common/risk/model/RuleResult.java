package com.cool.prc.common.risk.model;

public class RuleResult {

	private boolean accept;
	
	private String value;

	public static  RuleResult accept(String value) {
		return new RuleResult(true, value);
	}
	
	public static RuleResult refuse(String value) {
		return new RuleResult(false, value);
	}
	
	public RuleResult() {
		super();
	}

	public RuleResult(boolean accept, String value) {
		super();
		this.accept = accept;
		this.value = value;
	}

	public static RuleResult result(boolean accept, String value) {
		return new RuleResult(accept, value);
	}
	
	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "RuleReuslt [accept=" + accept + ", value=" + value + "]";
	}
	
	
}
