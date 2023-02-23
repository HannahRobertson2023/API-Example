package lab_5.act2.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lab_5.act2.api.modelhelpers.SurveyInstanceResponse;
import lab_5.act2.api.modelhelpers.SurveyItemResponse;
import lab_5.act2.api.modelhelpers.SurveyResponse;
import lab_5.act2.services.SurveyService;

@RequestMapping("/Surveys")
@RestController
public class SurveyController {
	private SurveyService __SurveyService = SurveyService.getInstance();

	// get all surveys
	@GetMapping
	public ResponseEntity<List<SurveyResponse>> returnSurveys() {
		return new ResponseEntity<List<SurveyResponse>>(
				SurveyResponse.convertSurveysToResponses(__SurveyService.getSurveys()), HttpStatus.OK);
	}

	// get survey by ID
	@GetMapping("/{id}")
	public ResponseEntity<SurveyResponse> returnSurvey(@PathVariable Integer id) {
		return new ResponseEntity<SurveyResponse>(new SurveyResponse(__SurveyService.getSurvey(id)), HttpStatus.OK);
	}

	// create survey
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SurveyResponse> createSurvey() {
		return new ResponseEntity<SurveyResponse>(new SurveyResponse(__SurveyService.createSurvey()),
				HttpStatus.CREATED);
	}

	// delete survey
	@DeleteMapping("/{id}")
	public ResponseEntity<SurveyResponse> deleteSurvey(@PathVariable Integer id) {
		return new ResponseEntity<SurveyResponse>(new SurveyResponse(__SurveyService.deleteSurvey(id)),
				HttpStatus.OK);
	}

	// add survey item to survey
	@PatchMapping("/{id}/{sid}")
	public ResponseEntity<SurveyResponse> modifySurvey(@PathVariable Integer id, @PathVariable String sid) {
		return new ResponseEntity<SurveyResponse>(new SurveyResponse(__SurveyService.modifySurvey(id, sid)),
				HttpStatus.OK);
	}

	// Get all survey Instances
	@GetMapping("/Instances")
	public ResponseEntity<List<SurveyInstanceResponse>> getInstances() {
		return new ResponseEntity<List<SurveyInstanceResponse>>(
				SurveyInstanceResponse.convertSurveyInstancesToResponses(__SurveyService.getSurveyInstances()),
				HttpStatus.OK);
	}

	// Get all survey Instances
	@GetMapping("/Instances/retreive/{InstanceID}")
	public ResponseEntity<SurveyInstanceResponse> getInstance(@PathVariable String InstanceID) {
		return new ResponseEntity<SurveyInstanceResponse>(
				new SurveyInstanceResponse(__SurveyService.getSurveyInstance(InstanceID)), HttpStatus.OK);
	}

	// Get survey Instances by state
	@PatchMapping("/Instances/{state}")
	public ResponseEntity<List<SurveyInstanceResponse>> getInstances(@PathVariable String state) {
		return new ResponseEntity<List<SurveyInstanceResponse>>(
				SurveyInstanceResponse.convertSurveyInstancesToResponses(__SurveyService.getSurveyInstances(state)),
				HttpStatus.OK);
	}

	// create survey instance from specific survey
	@RequestMapping(method = RequestMethod.POST, path = "/Instances/create/{id}")
	public ResponseEntity<SurveyInstanceResponse> createSurveyInstance(@PathVariable Integer id) {
		return new ResponseEntity<SurveyInstanceResponse>(
				new SurveyInstanceResponse(__SurveyService.createSurveyInstance(id)), HttpStatus.CREATED);
	}

	// answer survey item question in instance
	@PatchMapping("/Instances/{implid}/{sid}/{answer}")
	public ResponseEntity<SurveyInstanceResponse> modifySurvey(@PathVariable String implid, @PathVariable String sid,
			@PathVariable Integer answer) {
		return new ResponseEntity<SurveyInstanceResponse>(
				new SurveyInstanceResponse(__SurveyService.answerSurveyItem(implid, sid, answer)), HttpStatus.OK);
	}

	// Super secret developer shortcut! So i don't have to create everything to test
	@GetMapping(path = "/Setup")
	public ResponseEntity<SurveyItemResponse> setup() {
		for (int i = 0; i < 4; i++) {
			__SurveyService.createSurvey();
		}
		for (int i = 0; i < 4; i++) {
			__SurveyService.createSurveyItem(4 + i);
		}
		for (int i = 0; i < 4; i++) {
			__SurveyService.modifySurvey(1, "SI" + i);
		}
		__SurveyService.createSurveyInstance(1);
		return new ResponseEntity<SurveyItemResponse>(new SurveyItemResponse(__SurveyService.createSurveyItem(4)),
				HttpStatus.CREATED);
	}
}
