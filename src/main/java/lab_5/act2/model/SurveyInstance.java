package lab_5.act2.model;

import java.util.ArrayList;
import java.util.List;

import lab_5.act2.model.exceptions.SurveyItemEntityNotFoundException;

public class SurveyInstance {
	private Survey Survey;
	private String id;
	private String state;
	private List<Boolean> correct;
	private List<String> answered;
	private List<Integer> answers;

	
	public SurveyInstance(Survey Survey, String id) {
		if (Survey.getState().equals("Completed")) {
			correct = new ArrayList<Boolean>();
			answered = new ArrayList<String>();
			answers = new ArrayList<Integer>();
			this.Survey = Survey;
			this.id = id;
			state = "Created";
		}
		else {
			throw new SurveyItemEntityNotFoundException("No Completed Survey Found with ID  " + Survey.getSurveyID());
		}
	}
	
	public Survey getSurvey() {
		return Survey;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String s) {
		id = s;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String s) {
		state = s;
	}
	
	public boolean inputAnswer(SurveyItem si, int ans) throws SurveyItemEntityNotFoundException {
		if (Survey.getSurveyItems().contains(si) && !answered.contains(si.getId()) && !state.equals("Completed")) {
			answers.add(ans);
			correct.add(si.getAnswer() == ans);
			if (state == "Created") {
				state = "InProgress";
			}
			else if (correct.size() == Survey.getSurveyItems().size()) {
				state = "Complete";
			}
			return si.getAnswer() == ans;
		}
		else {
			throw new SurveyItemEntityNotFoundException("Survey does not contain unanswered Survey Item " + si.getId());
		}
	}
	
	public List<Boolean> getCorrect() {
		return correct;
	}
	
	public List<SurveyItem> getQuestions() {
		return Survey.getSurveyItems();
	}
	
	public List<Integer> getAnswers() {
		return answers;
	}
}