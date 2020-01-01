package com.surviveenglish.util;

public enum Command {
	
	REMOVE_CLIENT(CommandType.TO_SERVER, "remove_client"),
	RECEIVE_CLIENT_LOGIN(CommandType.TO_SERVER, "receive_client_login"),
	CHECK_USER_DATA(CommandType.TO_SERVER, "check_user_data"),
	CLOSING_SERVER(CommandType.TO_CLIENT, "closing_server"),
	REQUEST_USER_DATA(CommandType.TO_CLIENT, "request_user_data"),
	ACCEPTED_USER_DATA(CommandType.TO_CLIENT, "accepted_user_data"),
	USER_DATA_INVALID(CommandType.TO_CLIENT, "user_data_invalid");
	
	private final String command;
	
	private final CommandType commandType;
	
	Command(CommandType commandType, String command) {
		
		this.commandType = commandType;
		this.command = command;
		
	}
	
	public String getCommand() {
		
		return "command:" + command;
		
	}
	
	public String getRawCommand() {
		
		return command;
		
	}
	
	public int length() {
		
		return command.length();
		
	}
	
	public CommandType getCommandType() {
		
		return commandType;
		
	}
	
	public enum CommandType {
		
		TO_CLIENT,
		TO_SERVER;
		
	}
	
}