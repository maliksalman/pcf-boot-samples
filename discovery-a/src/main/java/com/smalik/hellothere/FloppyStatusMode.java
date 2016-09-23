package com.smalik.hellothere;

import org.springframework.stereotype.Component;

@Component
public class FloppyStatusMode {

	private boolean enabled;
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
