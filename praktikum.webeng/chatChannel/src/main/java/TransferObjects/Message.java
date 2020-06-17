package TransferObjects;

public class Message {
	private int messageID;
	private String value;
	private int messageChannelID;
	private int messageUserID;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	public Message(String value, int messageChannelID, int messageUserID) {
		super();
		this.value = value;
		this.messageChannelID = messageChannelID;
		this.messageUserID = messageUserID;
	}
	
	public Message(int messageID, String value, int messageChannelID, int messageUserID) {
		super();
		this.messageID = messageID;
		this.value = value;
		this.messageChannelID = messageChannelID;
		this.messageUserID = messageUserID;
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
	public int getMessageUserID() {
		return messageUserID;
	}

	/**
	 * @param messageUserID the messageUserID to set
	 */
	public void setMessageUserID(int messageUserID) {
		this.messageUserID = messageUserID;
	}

}
