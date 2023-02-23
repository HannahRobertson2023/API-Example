package lab_5.act2.model;

import java.util.ArrayList;
import java.util.List;

public class Survey {
	public Survey() {
		
	}
	public Survey(int id, List<SurveyItem> titles) {
		__id = id;
		__SurveyItems = titles;
		__state = "Created";
	}
	
	public String getState() {
		return __state;
	}
	
	public void setState(String state) {
		__state = state;
	}
	
	public int getSurveyID() {
		return __id;
	}
	public List<SurveyItem> getSurveyItems() {
		return __SurveyItems;
	}
	
	public void setSurveyId(int id) {
		__id = id;
	}
	public void setSurveyItems(List<SurveyItem> titles) {
		__SurveyItems = titles;
	}
	public void addSurveyItem(SurveyItem si) {
		__state = "Completed";
		__SurveyItems.add(si);
	}
	public boolean removeSurveyItem(SurveyItem b) {
		return __SurveyItems.remove(b);
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof Survey)) return false;
		Survey a = (Survey) obj;
		
		boolean rval = a.getSurveyID() == this.getSurveyID();
		
		if (rval && (rval = (a.getSurveyItems() != null && a.getSurveyItems().size() == this.getSurveyItems().size()))) {
			for (int i = 0; rval && i < this.getSurveyItems().size(); i++) {
				rval = a.getSurveyItems().get(i).equals(this.getSurveyItems().get(i));
			}
		}
		return rval;
	}

	private int    __id;
	private List<SurveyItem> __SurveyItems = new ArrayList<SurveyItem>();
	private String __state;
}
