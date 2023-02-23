package lab_5.act2.api.modelhelpers;

import java.util.ArrayList;
import java.util.List;

import lab_5.act2.model.SurveyInstance;

public class SurveyInstanceResponse {
	private SurveyInstance __SurveyInstance;
	
	public SurveyInstanceResponse() {
		super();
	}

	public SurveyInstanceResponse(SurveyInstance SurveyInstance) {
		__SurveyInstance = SurveyInstance;
	}
	
	public static List<SurveyInstanceResponse> convertSurveyInstancesToResponses(List<SurveyInstance> SurveyInstances) {
		List<SurveyInstanceResponse> SurveyInstanceResponses = new ArrayList<SurveyInstanceResponse>();
		
		if (SurveyInstances != null ) {
			for (SurveyInstance b : SurveyInstances) {
				SurveyInstanceResponses.add(new SurveyInstanceResponse(b));
			}
		}
		return SurveyInstanceResponses;
	}
	
	public SurveyInstance getSurveyInstance() {
		return __SurveyInstance;
	}
}
