package lab_5.act2.api.modelhelpers;

import java.util.ArrayList;
import java.util.List;

import lab_5.act2.model.SurveyItem;

public class SurveyItemResponse {
	private SurveyItem __SurveyItem;
	
	public SurveyItemResponse() {
		super();
	}

	public SurveyItemResponse(SurveyItem SurveyItem) {
		__SurveyItem = SurveyItem;
	}
	
	public String getQuestion() {
		return __SurveyItem.getQuestion();
	}

	public int getAnswer() {
		return __SurveyItem.getAnswer();
	}

	public String getId() {
		return __SurveyItem.getId();
	}
	
	public void setId(String id) {
		__SurveyItem.setId(id);
	}

	public List<Integer> getOptions() {
		return __SurveyItem.getOptions();
	}
	
	public static List<SurveyItemResponse> convertSurveyItemsToResponses(List<SurveyItem> SurveyItems) {
		List<SurveyItemResponse> SurveyItemResponses = new ArrayList<SurveyItemResponse>();
		
		System.out.println(SurveyItems);
		
		if (SurveyItems != null ) {
			for (SurveyItem b : SurveyItems) {
				SurveyItemResponses.add(new SurveyItemResponse(b));
				
			}
		}
		return SurveyItemResponses;
	}
}
