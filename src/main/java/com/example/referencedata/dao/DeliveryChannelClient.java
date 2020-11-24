package com.example.referencedata.dao;

import com.example.referencedata.dao.entity.DeliveryChannel;
import com.mongodb.reactivestreams.client.MongoCollection;

import io.micronaut.context.annotation.Value;

public class DeliveryChannelClient extends BaseMongoClient<DeliveryChannel>{
	
	@Value("${app.mongodb.db.name}")
	private String mangodb;

	@Value("${app.mongodb.db.collection.deliveryChannel}")
	private String collectionName;

	private MongoCollection<DeliveryChannel> collection;

	@Override
	public MongoCollection<DeliveryChannel> getCollection() {
		if (collection == null) {
			collection = mongoClient.getDatabase(mangodb).getCollection(collectionName, DeliveryChannel.class);
		}
		return collection;
	}
	
	protected String getCollectionName() {
		return collectionName;
	}

}
