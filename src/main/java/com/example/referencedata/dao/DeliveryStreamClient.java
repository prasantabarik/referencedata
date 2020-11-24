package com.example.referencedata.dao;

import com.example.referencedata.dao.entity.DeliveryStream;
import com.mongodb.reactivestreams.client.MongoCollection;

import io.micronaut.context.annotation.Value;

public class DeliveryStreamClient extends BaseMongoClient<DeliveryStream> {
	
	@Value("${app.mongodb.db.name}")
	private String mangodb;

	@Value("${app.mongodb.db.collection.deliveryStream}")
	private String collectionName;

	private MongoCollection<DeliveryStream> collection;

	@Override
	public MongoCollection<DeliveryStream> getCollection() {
		if (collection == null) {
			collection = mongoClient.getDatabase(mangodb).getCollection(collectionName, DeliveryStream.class);
		}
		return collection;
	}
	
	protected String getCollectionName() {
		return collectionName;
	}

}
