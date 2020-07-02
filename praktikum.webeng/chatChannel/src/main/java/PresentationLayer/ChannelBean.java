package PresentationLayer;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.*;

import BusinessLogicLayer.ChannelManager;
import TransferObjects.*;


@Named
@RequestScoped
public class ChannelBean {
	
	private ChannelManager channelManager;
	private Channel channel;
	private ArrayList<Channel> channelList;
	private ArrayList<User> userList;
	
	@Inject
	User user;
	
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
	
	public String joinChannel(Channel currentChannel) {
		this.channel = currentChannel;
		channelManager.addUserToChannel(channel, user);
		return "joinChannelSuccess";
	}

}
