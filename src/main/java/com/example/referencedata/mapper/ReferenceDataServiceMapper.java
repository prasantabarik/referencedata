package com.example.referencedata.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "jsr330", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReferenceDataServiceMapper {

	com.example.referencedata.domain.Deliverer mapperDelivererEntityToDomain(
			com.example.referencedata.dao.entity.Deliverer deliverer);

	com.example.referencedata.dao.entity.Deliverer mapperDelivererDomanToEntity(
			com.example.referencedata.domain.Deliverer delivererDomain);

	List<com.example.referencedata.domain.Deliverer> mapperDelivererEntityToDomain(
			List<com.example.referencedata.dao.entity.Deliverer> deliverer);

	List<com.example.referencedata.dao.entity.Deliverer> mapperDelivererDomanToEntity(
			List<com.example.referencedata.domain.Deliverer> delivererDomain);

	List<com.example.referencedata.domain.DeliveryChannel> mapperDeliveryChannelEntityToDomain(
			List<com.example.referencedata.dao.entity.DeliveryChannel> deliveryChannelEntity);

	List<com.example.referencedata.dao.entity.DeliveryChannel> mapperDeliveryChannelDomanToEntity(
			List<com.example.referencedata.domain.DeliveryChannel> deliveryChannelDomain);

	com.example.referencedata.domain.DeliveryStream mapperDeliveryStreamEntityToDomain(
			com.example.referencedata.dao.entity.DeliveryStream deliveryStreamEntity);

	com.example.referencedata.dao.entity.DeliveryStream mapperDeliveryStreamDomanToEntity(
			com.example.referencedata.domain.DeliveryStream deliveryStreamDomain);
	
	List<com.example.referencedata.domain.DeliveryStream> mapperDeliveryStreamEntityToDomain(
			List<com.example.referencedata.dao.entity.DeliveryStream> deliveryStreamEntity);

	List<com.example.referencedata.dao.entity.DeliveryStream> mapperDeliveryStreamDomanToEntity(
			List<com.example.referencedata.domain.DeliveryStream> deliveryStreamDomain);

	com.example.referencedata.domain.DeliveryChannel mapperDeliveryChannelEntityToDomain(
			com.example.referencedata.dao.entity.DeliveryChannel deliveryChannelEntity);

	com.example.referencedata.dao.entity.DeliveryChannel mapperDeliveryChannelDomanToEntity(
			com.example.referencedata.domain.DeliveryChannel deliveryChannelDomain);

	com.example.referencedata.domain.LogisticChannel mapperLogisticChannelEntityToDomain(
			com.example.referencedata.dao.entity.LogisticChannel logisticChannelEntity);

	com.example.referencedata.dao.entity.LogisticChannel mapperLogisticChannelDomanToEntity(
			com.example.referencedata.domain.LogisticChannel logisticChannelDomain);
	
	
	List<com.example.referencedata.domain.LogisticChannel> mapperLogisticChannelEntityToDomain(
			List<com.example.referencedata.dao.entity.LogisticChannel> logisticChannelEntity);

	List<com.example.referencedata.dao.entity.LogisticChannel> mapperLogisticChannelDomanToEntity(
			List<com.example.referencedata.domain.LogisticChannel> logisticChannelDomain);

}
