package lab_5.act2.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lab_5.act2.api.modelhelpers.SurveyItemResponse;
import lab_5.act2.services.SurveyService;

@RequestMapping("/SurveyItems")
@RestController
public class SurveyItemController {
	private SurveyService __SurveyService = SurveyService.getInstance();

	// Get all items
	@GetMapping
	public ResponseEntity<List<SurveyItemResponse>> returnSurveyItems() throws Throwable {
		return new ResponseEntity<List<SurveyItemResponse>>(
				SurveyItemResponse.convertSurveyItemsToResponses(__SurveyService.getSurveyItems()), HttpStatus.OK);
	}

	// get item by id
	@GetMapping("/{id}")
	public ResponseEntity<SurveyItemResponse> returnSurveyItem(@PathVariable String id) {
		return new ResponseEntity<SurveyItemResponse>(new SurveyItemResponse(__SurveyService.getSurveyItem(id)),
				HttpStatus.OK);
	}

	// create survey item - default
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SurveyItemResponse> createSurvey() {
		return new ResponseEntity<SurveyItemResponse>(new SurveyItemResponse(__SurveyService.createSurveyItem(4)),
				HttpStatus.CREATED);
	}

	// create survey item
	@RequestMapping(method = RequestMethod.POST, path = "/{questions}")
	public ResponseEntity<SurveyItemResponse> createSurvey(@PathVariable int questions) {
		return new ResponseEntity<SurveyItemResponse>(
				new SurveyItemResponse(__SurveyService.createSurveyItem(questions)), HttpStatus.CREATED);
	}
}