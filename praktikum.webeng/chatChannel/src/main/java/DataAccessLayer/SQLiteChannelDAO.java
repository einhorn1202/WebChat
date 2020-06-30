package DataAccessLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import TransferObjects.*;


public class SQLiteChannelDAO extends SQLiteDAO implements ChannelDAO{
	
	private static final String getChannelStatement = "SELECT CHANNELNAME, CHANNEL_PIC FROM USER WHERE CHANNEL_ID = ?";
	private static final String addChannelStatement = "INSERT INTO CHANNEL (CHANNELNAME,CHANNEL_PIC) VALUES (?,?)";
	private static final String deleteChannelStatement = "DELETE FROM CHANNEL WHERE CHANNEL_ID = ?";
	private static final String updateChannelStatement = "UPDATE CHANNEL SET CHANNELNAME = ? , CHANNEL_PIC = ? WHERE CHANNEL_ID = ?";
	private static final String getMessageListStatement = "SELECT MESSAGE_ID, VALUE, CHANNEL_ID , USER_ID FROM MESSAGE WHERE CHANNEL_ID = ?";
	private static final String getUserListStatement = "SELECT CHANNEL_ID , USER_ID FROM USER_IN_CHANNEL WHERE CHANNEL_ID = ?";
	private static final String addUserToChannelStatement = "INSERT INTO USER_IN_CHANNEL (CHANNEL_ID,USER_ID) VALUES (?,?)";
	private static final String removeUserFromChannelStatement = "DELETE FROM USER_IN_CHANNEL WHERE CHANNEL_ID = ? AND USER_ID = ?";
	private static final String addMessageToChannelStatement = "INSERT INTO Message (VALUE,CHANNEL_ID,USER_ID) VALUES (?,?,?)";
	private static final String deleteMessageFromChannelStatement = "DELETE FROM MESSAGE WHERE MESSAGE_ID = ?";
	private static final String getAllChannelsStatement = "SELECT * FROM CHANNEL";
	
	public SQLiteChannelDAO() {
		super();
		
	}

	@Override
	public Channel getChannel(int id) {
		PreparedStatement stmt;
		Channel channel = null;
		try {
			stmt = getConnection().prepareStatement(getChannelStatement);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				channel = new Channel(id,rs.getString("CHANNELNAME"),rs.getString("CHANNEL_PIC"),getMessagesOfChannel(channel.getChannelID()),getUsersOfChannel(channel.getChannelID()));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return channel;
	}
	
	@Override
	public void addChannel(Channel channel) {
		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement(addChannelStatement, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,channel.getChannelName());
			stmt.setString(2,channel.getChannelPic());
			stmt.executeUpdate();
			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                channel.setChannelID(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating Channel failed, no ID obtained.");
	            }
	        }
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteChannel(Channel channel) {
		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement(deleteChannelStatement);
			stmt.setInt(1,channel.getChannelID());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateChannel(Channel channel) {
		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement(updateChannelStatement);
			stmt.setString(1,channel.getChannelName());
			stmt.setString(2,channel.getChannelPic());
			stmt.setInt(3,channel.getChannelID());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addUserToChannel(Channel channel, User user) {
		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement(addUserToChannelStatement);
			stmt.setInt(1,channel.getChannelID());
			stmt.setInt(2,user.getUserID());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeUserFromChannel(Channel channel, User user) {
		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement(removeUserFromChannelStatement);
			stmt.setInt(1,channel.getChannelID());
			stmt.setInt(2,user.getUserID());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addMessageToChannel(Channel channel, User user, Message message) {
		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement(addMessageToChannelStatement, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,message.getValue());
			stmt.setInt(2,channel.getChannelID());
			stmt.setInt(3,user.getUserID());
            stmt.executeUpdate();
			stmt.close();
			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                message.setMessageID(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating Message failed, no ID obtained.");
	            }
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMessageFromChannel(Message message) {
		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement(deleteMessageFromChannelStatement);
			stmt.setInt(1,message.getMessageID());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Message> getMessagesOfChannel(int id){
		PreparedStatement stmt;
		ArrayList<Message> messageList = new ArrayList<Message>();
		try {
			stmt = getConnection().prepareStatement(getMessageListStatement);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				messageList.add(new Message(rs.getInt("MESSAGE_ID"), rs.getString("VALUE"), rs.getInt("CHANNEL_ID"), rs.getInt("USER_ID")));	
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
	}
	
	@Override
	public ArrayList<User> getUsersOfChannel(int id){
		PreparedStatement stmt;
		ArrayList<User> userList = new ArrayList<User>();
		try {
			stmt = getConnection().prepareStatement(getUserListStatement);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				userList.add(new User(rs.getInt("USER_ID"), rs.getString("USERNAME"),rs.getString("PASSWORD"), rs.getString("PROFILE_PIC"), rs.getString("COLOR")));	
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public ArrayList<Channel> getAllChannels() {
		PreparedStatement stmt;
		ArrayList<Channel> channelList = new ArrayList<Channel>();
		try {
			stmt = getConnection().prepareStatement(getAllChannelsStatement);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				channelList.add(new Channel(rs.getInt("CHANNEL_ID"), rs.getString("CHANNELNAME"),rs.getString("CHANNEL_PIC"),getMessagesOfChannel(rs.getInt("CHANNEL_ID")),getUsersOfChannel(rs.getInt("CHANNEL_ID"))));	
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return channelList;
	}
}
