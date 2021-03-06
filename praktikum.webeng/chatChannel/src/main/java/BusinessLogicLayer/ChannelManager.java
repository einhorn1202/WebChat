package BusinessLogicLayer;

import java.util.ArrayList;
import java.util.*;
import DataAccessLayer.ChannelDAO;
import DataAccessLayer.DAOFactory;
import DataAccessLayer.SQLiteChannelDAO;
import TransferObjects.Channel;
import TransferObjects.Message;
import TransferObjects.User;

public class ChannelManager{
	
	ChannelDAO dao;
	
	public ChannelManager() {
		dao = DAOFactory.getChannelDAO();
	}


	public Channel getChannel(int id) {
		// TODO Auto-generated method stub
		return dao.getChannel(id);
	}


	public void updateChannel(Channel channel) {
		dao.updateChannel(channel);
	}


	public void addChannel(Channel channel) {
		dao.addChannel(channel);
	}


	public ArrayList<Channel> getAllChannels() {
		return dao.getAllChannels();
	}

	public void deleteChannel(Channel channel) {
		dao.deleteChannel(channel);
	}


	public void addUserToChannel(Channel channel, User user) {
		dao.addUserToChannel(channel, user);
	}


	public void removeUserFromChannel(Channel channel, User user) {
		dao.removeUserFromChannel(channel, user);
		
	}


	public void addMessageToChannel(Channel channel, User user, String value) {
		dao.addMessageToChannel(channel, user, value);
	}

	public void deleteMessageFromChannel(Message message) {
		dao.deleteMessageFromChannel(message);
	}


	public ArrayList<User> getUsersOfChannel(int id) {
		return dao.getUsersOfChannel(id);
	}


	public ArrayList<Message> getMessagesOfChannel(int id) {
		return dao.getMessagesOfChannel(id);
	}
	
	public Boolean isChannelNameValid(Channel newChannel) {
		if(newChannel.getChannelName().compareTo("") != 0) {
			for(Channel oldChannel : dao.getAllChannels()) {
				if(oldChannel.getChannelName().compareTo(newChannel.getChannelName()) == 0) {
					return false;
				}
			}
		}
		else return false;
		return true;
	} 
		
	public ArrayList<Channel> searchChannel(String searchChannelName) {
		ArrayList<Channel> searchChannelList = new ArrayList<Channel>();
        for(Channel channel : dao.getAllChannels()) {
            if(channel.getChannelName().contains(searchChannelName)) {
                searchChannelList.add(channel);
            }
        }
        return searchChannelList;
    }
	
	public void clearTableUserInChannel() {
		dao.clearTableUserInChannel();
	}
}