package com.example.referencedata.controller;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.referencedata.domain.Deliverer;
import com.example.referencedata.service.DataService;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller("/referencedata")
@Validated
public class ReferenceDataController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReferenceDataController.class);

	@Inject
	DataService referenceDataService;

	@Get(value = "/deliverer/{delivererNumber}")
	@Operation(description = "Retrieves Deliverer for a given DelivererNumber", summary = "Retrieves Deliverer for a given DelivererNumber")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Deliverer.class)))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error : {\"errors\":[{\"code\":\"TECHNICAL_ERROR\",\"message\":\"Unable to process request.\"}]}", content = @Content(schema = @Schema(implementation = String.class)))
			 })
	public List<Deliverer> getDeliverer(@PathVariable("delivererNumber") String delivererNumber) {
		return referenceDataService.findDelivererByValue(delivererNumber);
	}

	@Get(value = "/deliverer")
	@Operation(description = "Retrieves All Deliverer", summary = "Retrieves All Deliverer")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Deliverer.class)))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error : {\"errors\":[{\"code\":\"TECHNICAL_ERROR\",\"message\":\"Unable to process request.\"}]}", content = @Content(schema = @Schema(implementation = String.class)))
			 })
	public List<Deliverer> findAllDeliverer() {
		return referenceDataService.findAllDeliverer();
	}

	@Get(value = "/deliveryChannel")
	@Operation(description = "Retrieves All Delivery Channel", summary = "Retrieves All Delivery Channel")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation =  com.example.referencedata.domain.DeliveryChannel.class)))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error : {\"errors\":[{\"code\":\"TECHNICAL_ERROR\",\"message\":\"Unable to process request.\"}]}", content = @Content(schema = @Schema(implementation = String.class))) })
	public List<com.example.referencedata.domain.DeliveryChannel> findAllDeliveryChannel() {
		List<com.example.referencedata.domain.DeliveryChannel> deliveryChannelList = referenceDataService
				.findAllDeliveryChannel();
		LOGGER.info(" Response Received : " + deliveryChannelList);
		return deliveryChannelList;
	}

	@Get(value = "/deliveryStream")
	@Operation(description = "Retrieves All Delivery Stream", summary = "Retrieves All Delivery Stream")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = com.example.referencedata.domain.DeliveryStream.class)))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error : {\"errors\":[{\"code\":\"TECHNICAL_ERROR\",\"message\":\"Unable to process request.\"}]}", content = @Content(schema = @Schema(implementation = String.class))) })
	public List<com.example.referencedata.domain.DeliveryStream> findAllDeliveryStream() {
		List<com.example.referencedata.domain.DeliveryStream> deliveryStreamList = referenceDataService
				.findDeliveryStream();
		LOGGER.info(" Response Received : " + deliveryStreamList);
		return deliveryStreamList;
	}

	@Get(value = "/logisticChannel")
	@Operation(description = "Retrieves All Logistic Channel", summary = "Retrieves All Logistic Channel")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = com.example.referencedata.domain.LogisticChannel.class)))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error : {\"errors\":[{\"code\":\"TECHNICAL_ERROR\",\"message\":\"Unable to process request.\"}]}", content = @Content(schema = @Schema(implementation = String.class))) })
	public List<com.example.referencedata.domain.LogisticChannel> findAllLogisticChannel() {
		List<com.example.referencedata.domain.LogisticChannel> logisticChannelList = referenceDataService
				.findLogisticChannel();
		LOGGER.info(" Response Received : " + logisticChannelList);
		return logisticChannelList;
	}
	
	
	@Get(value = "/deliveryMomement/findBy")
	@Operation(description = "Retrieves Delivery Momement for the Given Criteria", summary = "Retrieves Delivery Momement for the Given Criteria")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = com.example.referencedata.dao.entity.DeliveryMoment.class)))),
			@ApiResponse(responseCode = "500", description = "Internal Server Error : {\"errors\":[{\"code\":\"TECHNICAL_ERROR\",\"message\":\"Unable to process request.\"}]}", content = @Content(schema = @Schema(implementation = String.class))) })
	public List<com.example.referencedata.dao.entity.DeliveryMoment> findDeliveryMomement(@QueryValue(value = "storeNumber") int storeNumber,@QueryValue(value = "streamNumber") @Nullable String streamNumber,@QueryValue(value = "delivererNumber") @Nullable String delivererNumber) {
		List<com.example.referencedata.dao.entity.DeliveryMoment> deliveryMomentlList = referenceDataService
				.findDeliveryMomment(storeNumber,streamNumber,delivererNumber);
		LOGGER.info(" Response Received : " + deliveryMomentlList);
		return deliveryMomentlList;
	}

}
