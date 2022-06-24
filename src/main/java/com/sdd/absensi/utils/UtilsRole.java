package com.sdd.absensi.utils;

public enum UtilsRole {

	ROLE_ADMIN("ROLE_ADMIN", "ADMIN")
	,ROLE_USER("ROLE_USER", "USER");
	
	private String text;
	private String value;

	private UtilsRole(String text, String value) {
		this.text = text;
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static String getCodeFromText(String text) {
		String value = "";
		for(UtilsRole utilsRole : UtilsRole.values()) {
			if(utilsRole.getText().contains(text)) {
				return utilsRole.getValue();
			}
		}
		return value;
	}
	
}
