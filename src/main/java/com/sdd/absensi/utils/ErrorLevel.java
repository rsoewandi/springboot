package com.sdd.absensi.utils;

public enum ErrorLevel {

	ERROR("ERROR", 400)
	,INFO("INFO",200)
	,WARN("WARN",300);
	

	private String text;
	private int value;

	private ErrorLevel(String text, int value) {
		this.text = text;
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public static int getCodeFromText(String text) {
		int value = 0;
		for(ErrorLevel errorLevel : ErrorLevel.values()) {
			if(errorLevel.getText().contains(text)) {
				return errorLevel.getValue();
			}
		}
		return value;
	}
}
