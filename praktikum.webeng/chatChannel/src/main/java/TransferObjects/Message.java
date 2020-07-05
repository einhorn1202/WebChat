package TransferObjects;

import java.io.Serializable;

public class Message implements Serializable{
	private int messageID;
	private String value;
	private int messageChannelID;
	private String messageUsername;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	public Message(String value, int messageChannelID, String messageUsername) {
		super();
		this.value = value;
		this.messageChannelID = messageChannelID;
		this.messageUsername = messageUsername;
	}
	
	public Message(int messageID, String value, int messageChannelID, String messageUsername) {
		super();
		this.messageID = messageID;
		this.value = value;
		this.messageChannelID = messageChannelID;
		this.messageUsername = messageUsername;
	}

	/**
	 * @return the messageID
	 */
	public int getMessageID() {
		return messageID;
	}

	/**
	 * @param messageID the messageID to set
	 */
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the messageChannelID
	 */
	public int getMessageChannelID() {
		return messageChannelID;
	}

	/**
	 * @param messageChannelID the messageChannelID to set
	 */
	public void setMessageChannelID(int messageChannelID) {
		this.messageChannelID = messageChannelID;
	}

	/**
	 * @return the messageUserID
	 */
	public String getMessageUsername() {
		return messageUsername;
	}

	/**
	 * @param messageUserID the messageUserID to set
	 */
	public void setMessageUsername(String messageUsername) {
		this.messageUsername = messageUsername;
	}

}
