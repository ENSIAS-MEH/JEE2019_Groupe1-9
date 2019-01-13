package entities;

public class Poll {
	private int PollId;
	private String Description;
	private int Duration;
	private String Category;
	private int UserId;
	private String Type;
	
	public Poll(int pollId, String description, int duration, String category, int userId, String type) {
		super();
		PollId = pollId;
		Description = description;
		Duration = duration;
		Category = category;
		UserId = userId;
		Type=type;
	}
	public Poll() {
		// TODO Auto-generated constructor stub
	}
	public int getPollId() {
		return PollId;
	}
	public void setPollId(int pollId) {
		PollId = pollId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		Duration = duration;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
}
