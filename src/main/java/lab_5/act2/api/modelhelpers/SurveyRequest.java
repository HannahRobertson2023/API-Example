package lab_5.act2.api.modelhelpers;

import java.util.List;

import lab_5.act2.model.SurveyItem;

public class SurveyRequest {
	public SurveyRequest() {		
	}
	public SurveyRequest(int id, List<SurveyItem> questions) {
		__id = id;
		__SurveyItems = questions;
	}
	public int getId() {
		return __id;
	}
	public List<SurveyItem> getSurveyItems() {
		return __SurveyItems;
	}
	
	public void setId(int id) {
		__id = id;
	}
	public void setSurveyItems(List<SurveyItem> questions) {
		__SurveyItems = questions;
	}
	
	private int __id;
	private List<SurveyItem> __SurveyItems;
}
