package entities;

public class _number_of_voters {
public _poll poll;
public int number;
public _poll getPoll() {
	return poll;
}
public void setPoll(_poll poll) {
	this.poll = poll;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public _number_of_voters(_poll poll, int number) {
	super();
	this.poll = poll;
	this.number = number;
}
	
public _number_of_voters() {
	
}
}
