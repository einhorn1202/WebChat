package PresentationLayer;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.*;

import BusinessLogicLayer.ChannelManager;
import TransferObjects.*;
import PresentationLayer.*;


@Named
@ApplicationScoped
public class ChannelBean {
	
	private ChannelManager channelManager;
	private Channel channel;
	private ArrayList<Channel> channelList;
	private ArrayList<User> userList;
	private String valueOfMessage;
	
	//private ArrayList<Channel> searchChannelList;
	
	@Inject
	UserBean userBean;
	
	@PostConstruct
	public void init() {
		if(channelManager == null) {
			channelManager = new ChannelManager();
		}
		if(channel == null) {
			channel = new Channel();
		}
		if(channelManager != null)
			channelList = channelManager.getAllChannels();
	}
	
	@PreDestroy
	public void destroy() {
		if(channelManager != null)
		  channelManager.clearTableUserInChannel();
	}
	
	public String getValueOfMessage() {
		return valueOfMessage;
	}

	public void setValueOfMessage(String valueOfMessage) {
		this.valueOfMessage = valueOfMessage;
	}
	
	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public ArrayList<Channel> getChannelList() {
		return channelList;
	}

	public void setChannelList(ArrayList<Channel> channelList) {
		this.channelList = channelList;
	}
	
	/*
	 * ACTION-METHODEN DER BEAN
	 */
	
	public String addChannel() {
		if(channelManager.isChannelNameValid(channel)) {
			channel.setActiveuserList(new ArrayList<User>());
			channel.setMessageList(new ArrayList<Message>());
			channelManager.addChannel(channel);
			return "addChannelSuccess";
		}
		else return "addChannelFailure";
	}
	
	public String joinChannel(Channel channel, User user) {
		channelManager.addUserToChannel(channel, user);
		this.channel = channelManager.getChannel(channel.getChannelID());
		return "joinChannelSuccess";
	}
	
	public String leaveChannel(User user) {
		channelManager.removeUserFromChannel(channel, user);
		this.channel = channelManager.getChannel(channel.getChannelID());
		return "leaveChannelSuccess";
	}
	
	/*
     * Suchfilter-Methoden 
     */
    private String searchChannelName = "";

    public void setSearchChannelName(String searchChannelName) {
        this.searchChannelName = searchChannelName;
    }

    public String getSearchChannelName() {
        return searchChannelName;
    }

    public void searchChannelNameList() {
        if(searchChannelName.length() > 0)
        	channelList = channelManager.searchChannel(searchChannelName);
        else
        	channelList = channelManager.getAllChannels();
    }
    
    public String sendMessage(User user) {
    	channelManager.addMessageToChannel(channel, user, valueOfMessage);
    	this.channel = channelManager.getChannel(channel.getChannelID());
    	return "";
    }

}
