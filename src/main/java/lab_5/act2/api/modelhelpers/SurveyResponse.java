package lab_5.act2.api.modelhelpers;

import java.util.ArrayList;
import java.util.List;

import lab_5.act2.model.Survey;
import lab_5.act2.model.SurveyItem;

public class SurveyResponse {
	private Survey __Survey;
	
	public SurveyResponse() {
		super();
	}

	public SurveyResponse(Survey Survey) {
		__Survey = Survey;
	}
	
	public int getSurveyID() {
		return __Survey.getSurveyID();
	}
	
	public void setSurveyId(int id) {
		__Survey.setSurveyId(id);
	}
	
	public List<SurveyItem> getSurveyItems() {
		return __Survey.getSurveyItems();
	}
	
	public void setSurveyItems(List<SurveyItem> titles) {
		__Survey.setSurveyItems(titles);
	}
	
	public static List<SurveyResponse> convertSurveysToResponses(List<Survey> Surveys) {
		List<SurveyResponse> SurveyResponses = new ArrayList<SurveyResponse>();
		
		if (Surveys != null ) {
			for (Survey a : Surveys) {
				SurveyResponses.add(new SurveyResponse(a));
			}
		}
		return SurveyResponses;
	}
	
	public String getSurveyState() {
		return __Survey.getState();
	}
}
