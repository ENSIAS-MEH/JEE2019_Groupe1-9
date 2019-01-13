package Model;

public class Poll {
	private int PollId;
	private String Description;
	private int Duration;
	private String Category;
	private int UserId;
	
	public Poll(int pollId, String description, int duration, String category, int userId) {
		super();
		PollId = pollId;
		Description = description;
		Duration = duration;
		Category = category;
		UserId = userId;
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
}
