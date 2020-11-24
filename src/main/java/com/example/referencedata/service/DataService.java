package com.example.referencedata.service;

import java.util.List;

import javax.inject.Inject;

import com.example.referencedata.dao.DelivererClient;
import com.example.referencedata.dao.DeliveryChannelClient;
import com.example.referencedata.dao.DeliveryStreamClient;
import com.example.referencedata.dao.LogisticChannelClient;
import com.example.referencedata.dao.entity.Deliverer;
import com.example.referencedata.dao.entity.DeliveryChannel;
import com.example.referencedata.dao.entity.DeliveryStream;
import com.example.referencedata.dao.entity.LogisticChannel;
import com.example.referencedata.mapper.ReferenceDataServiceMapper;

public class DataService {

	@Inject
	private ReferenceDataServiceMapper referenceDataServiceMapper;

	@Inject
	DelivererClient delivererClient;

	@Inject
	DeliveryChannelClient deliveryChannelClient;

	@Inject
	DeliveryStreamClient deliveryStreamClient;

	@Inject
	LogisticChannelClient logisticChannelClient;

	public List<com.example.referencedata.domain.Deliverer> findDelivererByValue(String findByValue) {
		List<Deliverer> delivererEntityList = delivererClient.findByFilterValue("delivererNumber", findByValue)
				.blockingGet();
		return referenceDataServiceMapper.mapperDelivererEntityToDomain(delivererEntityList);
	}

	public List<com.example.referencedata.domain.Deliverer> findAllDeliverer() {
		List<Deliverer> delivererEntityList = delivererClient.findAll().blockingGet();
		return referenceDataServiceMapper.mapperDelivererEntityToDomain(delivererEntityList);
	}

	public List<com.example.referencedata.domain.DeliveryChannel> findAllDeliveryChannel() {
		List<DeliveryChannel> deliveryChannelEntityList = deliveryChannelClient.findAll().blockingGet();
		return referenceDataServiceMapper.mapperDeliveryChannelEntityToDomain(deliveryChannelEntityList);
	}

	public List<com.example.referencedata.domain.LogisticChannel> findLogisticChannel() {
		List<LogisticChannel> logisticChannelEntityList = logisticChannelClient.findAll().blockingGet();
		return referenceDataServiceMapper.mapperLogisticChannelEntityToDomain(logisticChannelEntityList);
	}

	public List<com.example.referencedata.domain.DeliveryStream> findDeliveryStream() {
		List<DeliveryStream> deliveryStreamEntityList = deliveryStreamClient.findAll().blockingGet();
		return referenceDataServiceMapper.mapperDeliveryStreamEntityToDomain(deliveryStreamEntityList);
	}

}
