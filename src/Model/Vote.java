package Model;

public class Vote {
	private String Type;
	private int UserId;
	private int ChoiceId;
	
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getChoiceId() {
		return ChoiceId;
	}

	public void setChoiceId(int choiceId) {
		ChoiceId = choiceId;
	}

	public Vote(String type, int userId, int choiceId) {
		super();
		Type = type;
		UserId = userId;
		ChoiceId = choiceId;
	}
}
