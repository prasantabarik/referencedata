package com.example.referencedata.dao;

import com.example.referencedata.dao.entity.LogisticChannel;
import com.mongodb.reactivestreams.client.MongoCollection;

import io.micronaut.context.annotation.Value;

public class LogisticChannelClient extends BaseMongoClient<LogisticChannel> {

	@Value("${app.mongodb.db.name}")
	private String mangodb;

	@Value("${app.mongodb.db.collection.logisticChannel}")
	private String collectionName;

	private MongoCollection<LogisticChannel> collection;

	@Override
	public MongoCollection<LogisticChannel> getCollection() {
		if (collection == null) {
			collection = mongoClient.getDatabase(mangodb).getCollection(collectionName, LogisticChannel.class);
		}
		return collection;
	}
	
	protected String getCollectionName() {
		return collectionName;
	}
}
