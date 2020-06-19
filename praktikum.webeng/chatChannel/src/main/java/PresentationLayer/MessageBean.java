package PresentationLayer;

import javax.annotation.PostConstruct;

import BusinessLogicLayer.ChannelManager;
import BusinessLogicLayer.MessageManager;
import TransferObjects.Channel;
import TransferObjects.Message;

public class MessageBean {
	
	private Message message;
	MessageManager messageManager;
	
	public MessageBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		if(messageManager == null) {
			messageManager = new MessageManager();
		}
		if(message == null) {
			message = new Message();
		}
	}
	
	/*
	 * ACTION-METHODEN DER BEAN
	 */

}
