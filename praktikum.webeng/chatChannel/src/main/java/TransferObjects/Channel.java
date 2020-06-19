package TransferObjects;

import java.io.Serializable;
import java.util.List;

public class Channel implements Serializable{
	private int channelID;
	private String channelName;
	private String channelPic;
	private List<Message> messageList;
	private List<User> activeuserList;
	
	public Channel(String channelName, String channelPic, List<Message> messageList, List<User> activeuserList) {
		super();
		this.channelName = channelName;
		this.channelPic = channelPic;
		this.messageList = messageList;
		this.activeuserList = activeuserList;
	}
	
	public Channel(int channelID, String channelName, String channelPic, List<Message> messageList,
			List<User> activeuserList) {
		super();
		this.channelID = channelID;
		this.channelName = channelName;
		this.channelPic = channelPic;
		this.messageList = messageList;
		this.activeuserList = activeuserList;
	}

	public Channel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the channelID
	 */
	public int getChannelID() {
		return channelID;
	}

	/**
	 * @param channelID the channelID to set
	 */
	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}

	/**
	 * @return the channelName
	 */
	public String getChannelName() {
		return channelName;
	}

	/**
	 * @param channelName the channelName to set
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	/**
	 * @return the channelPic
	 */
	public String getChannelPic() {
		return channelPic;
	}

	/**
	 * @param channelPic the channelPic to set
	 */
	public void setChannelPic(String channelPic) {
		this.channelPic = channelPic;
	}

	/**
	 * @return the messageList
	 */
	public List<Message> getMessageList() {
		return messageList;
	}

	/**
	 * @param messageList the messageList to set
	 */
	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	/**
	 * @return the activeuserList
	 */
	public List<User> getActiveuserList() {
		return activeuserList;
	}

	/**
	 * @param activeuserList the activeuserList to set
	 */
	public void setActiveuserList(List<User> activeuserList) {
		this.activeuserList = activeuserList;
	}
	
	

}
