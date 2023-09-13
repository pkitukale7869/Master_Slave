package com.project.dao;

public class Revoke {

	private String privilege;
	private String target;
	private String targetName;
	private String host;

	public Revoke(String privilege) {
		this.privilege = privilege;
	}

	public void from(String target) {
		this.target = target;
	}

	public void on(String targetName) {
		this.targetName = targetName;
	}

	public void withHost(String host) {
		this.host = host;
	}

	public String getFinalCommand() {
		StringBuilder command = new StringBuilder("REVOKE ").append(privilege);

		if (target != null) {
			command.append(" FROM ").append(target);
		}

		if (targetName != null) {
			command.append(" ON ").append(targetName);
		}

		if (host != null) {
			command.append(" @ ").append(host);
		}

		return command.toString();
	}

}
