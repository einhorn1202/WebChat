package BusinessLogicLayer;

import java.util.ArrayList;

import DataAccessLayer.ChannelDAO;
import DataAccessLayer.DAOFactory;
import DataAccessLayer.SQLiteChannelDAO;
import TransferObjects.Channel;
import TransferObjects.Message;
import TransferObjects.User;

public class ChannelManager  implements ChannelDAO{
	
	SQLiteChannelDAO dao;
	
	public ChannelManager() {
		dao = DAOFactory.getSQLiteChannelDAO();
	}

	@Override
	public Channel getChannel(int id) {
		// TODO Auto-generated method stub
		return dao.getChannel(id);
	}

	@Override
	public void updateChannel(Channel channel) {
		dao.updateChannel(channel);
	}

	@Override
	public void addChannel(Channel channel) {
		dao.addChannel(channel);
	}

	@Override
	public ArrayList<Channel> getAllChannels() {
		return dao.getAllChannels();
	}

	@Override
	public void deleteChannel(Channel channel) {
		dao.deleteChannel(channel);
	}

	@Override
	public void addUserToChannel(Channel channel, User user) {
		dao.addUserToChannel(channel, user);
	}

	@Override
	public void removeUserFromChannel(Channel channel, User user) {
		dao.removeUserFromChannel(channel, user);
		
	}

	@Override
	public void addMessageToChannel(Channel channel, User user, Message message) {
		dao.addMessageToChannel(channel, user, message);
	}

	@Override
	public void deleteMessageFromChannel(Message message) {
		dao.deleteMessageFromChannel(message);
	}

	@Override
	public ArrayList<User> getUsersOfChannel(int id) {
		return dao.getUsersOfChannel(id);
	}

	@Override
	public ArrayList<Message> getMessagesOfChannel(int id) {
		return dao.getMessagesOfChannel(id);
	}
}
