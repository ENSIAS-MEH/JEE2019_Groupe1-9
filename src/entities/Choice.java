package entities;



public class Choice {
	private int ChoiceId;
	private String Description;
	private int NumberOfVoters;
	private int PollId;
	
	public Choice(int choiceId, String description, int numberOfVoters, int pollId) {
		super();
		ChoiceId = choiceId;
		Description = description;
		NumberOfVoters = numberOfVoters;
		PollId = pollId;
	}
	
	public Choice() {
		// TODO Auto-generated constructor stub
	}

	public int getChoiceId() {
		return ChoiceId;
	}
	public void setChoiceId(int choiceId) {
		ChoiceId = choiceId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getNumberOfVoters() {
		return NumberOfVoters;
	}
	public void setNumberOfVoters(int numberOfVoters) {
		NumberOfVoters = numberOfVoters;
	}
	public int getPollId() {
		return PollId;
	}
	public void setPollId(int pollId) {
		PollId = pollId;
	}
}
