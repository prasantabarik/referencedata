package com.example.referencedata.dao;

import javax.inject.Singleton;

import com.example.referencedata.dao.entity.Deliverer;
import com.mongodb.reactivestreams.client.MongoCollection;

import io.micronaut.context.annotation.Value;

@Singleton
public class DelivererClient extends BaseMongoClient<Deliverer> {

	@Value("${app.mongodb.db.name}")
	private String mangodb;

	@Value("${app.mongodb.db.collection.deliverer}")
	private String collectionName;

	protected String getCollectionName() {
		return collectionName;
	}

	private MongoCollection<Deliverer> collection;

	@Override
	public MongoCollection<Deliverer> getCollection() {
		if (collection == null) {
			collection = mongoClient.getDatabase(mangodb).getCollection(collectionName, Deliverer.class);
		}
		return collection;
	}
}
