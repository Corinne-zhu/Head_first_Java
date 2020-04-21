package Chapter14_SerializeAndFile;

//card
public class QuizCard {
	private String question;
	private String answer;



	public QuizCard(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}


	public QuizCard() {
		super();
	}


	public String getQuestion() {
		return this.question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return this.answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}



}
