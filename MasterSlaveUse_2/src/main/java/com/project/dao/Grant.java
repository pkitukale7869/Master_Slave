package com.project.dao;

public class Grant {

	private String privilege;
	private String target;
	private String targetName;
	private String host;

	public Grant(String privilege) {
	        this.privilege = privilege;
	    }

	public void on(String target) {
		this.target = target;
	}

	public void to(String targetName) {
		this.targetName = targetName;
	}

	public void withHost(String host) {
		this.host = host;
	}

	public String getFinalCommand() {
		StringBuilder command = new StringBuilder("GRANT ").append(privilege);

		if (target != null) {
			command.append(" ON ").append(target);
		}

		if (targetName != null) {
			command.append(" TO ").append(targetName);
		}

		if (host != null) {
			command.append(" @ ").append(host);
		}

		return command.toString();
	}

}
