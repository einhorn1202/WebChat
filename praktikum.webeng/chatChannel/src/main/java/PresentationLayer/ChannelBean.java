package PresentationLayer;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import BusinessLogicLayer.ChannelManager;
import TransferObjects.Channel;

@Named
@RequestScoped
public class ChannelBean {
	
	ChannelManager channelManager;
	private Channel channel;
	private ArrayList<Channel> channelList;
	
	@PostConstruct
	public void init() {
		if(channelManager == null) {
			channelManager = new ChannelManager();
		}
		if(channel == null) {
			channel = new Channel();
			channelList = channelManager.getAllChannels();
		}
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
	
	

}
