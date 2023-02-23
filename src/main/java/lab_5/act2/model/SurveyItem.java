package lab_5.act2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SurveyItem {
	private String[] ops = { "*", "/", "+", "-" };
	private String question;
	private int answer;
	private List<Integer> options;
	private String id;

	
	public SurveyItem(int optNum, String id) {
		Random rand = new Random();
		int op = rand.nextInt(100) % ops.length;
		int n1 = rand.nextInt(20);
		int n2 = rand.nextInt(20) + 1;

		question = "What is " + n1 + " " + ops[op] + " " + n2 + "?";

		if (op == 0) {
			answer = n1 * n2;
		} else if (op == 1) {
			answer = n1 / n2;
		} else if (op == 2) {
			answer = n1 + n2;
		} else {
			answer = n1 - n2;
		}

		options = new ArrayList<Integer>();
		options.add(answer);
		for (int i = 0; i < optNum - 1; i++) {
			options.add(rand.nextInt(50));
		}
		Collections.shuffle(options);
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public int getAnswer() {
		return answer;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public List<Integer> getOptions() {
		return options;
	}
}
