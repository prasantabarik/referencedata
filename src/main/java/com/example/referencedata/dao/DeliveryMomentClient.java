package com.example.referencedata.dao;

import com.example.referencedata.dao.entity.DeliveryMoment;
import com.mongodb.reactivestreams.client.MongoCollection;

import io.micronaut.context.annotation.Value;

public class DeliveryMomentClient extends BaseMongoClient<DeliveryMoment>{

	@Value("${app.mongodb.db.name}")
	private String mangodb;

	@Value("${app.mongodb.db.collection.deliveryMoment}")
	private String collectionName;

	private MongoCollection<DeliveryMoment> collection;

	@Override
	public MongoCollection<DeliveryMoment> getCollection() {
		if (collection == null) {
			collection = mongoClient.getDatabase(mangodb).getCollection(collectionName, DeliveryMoment.class);
		}
		return collection;
	}
	
	protected String getCollectionName() {
		return collectionName;
	}

}
