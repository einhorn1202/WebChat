package DataAccessLayer;

import java.util.ArrayList;

import TransferObjects.Channel;
import TransferObjects.Message;
import TransferObjects.User;

public interface ChannelDAO {
	public Channel getChannel(int id);
	public void updateChannel(Channel channel);
	public void addChannel(Channel channel);
	public ArrayList<Channel> getAllChannels();
	public void deleteChannel(Channel channel);
	public void addUserToChannel(Channel channel, User user);
	public void removeUserFromChannel(Channel channel, User user);
	public void addMessageToChannel(Channel channel,User user, String value);
	public void deleteMessageFromChannel(Message message);
	public ArrayList<User> getUsersOfChannel(int id);
	public ArrayList<Message> getMessagesOfChannel(int id);
	public void clearTableUserInChannel();
}
