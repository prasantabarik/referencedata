package com.example.referencedata.dao;

import java.util.List;

import javax.inject.Inject;

import com.mongodb.client.model.Filters;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;

import io.micronaut.context.annotation.Value;
import io.reactivex.Flowable;
import io.reactivex.Single;

public abstract class BaseMongoClient<T> {
	
	@Inject
	MongoClient mongoClient;
	
	@Value("${app.mongodb.db.name}")
    private String mangodb;
	
	public abstract MongoCollection<T> getCollection();
	
	protected abstract String getCollectionName();
    
	public Single<List<T>> findAll() {
		return Flowable.fromPublisher(getCollection().find()).toList();
	}

	public Single<List<T>> findByFilterValue(final String fieldName, final String filterValue) {
		return Flowable.fromPublisher(getCollection().find(Filters.eq(fieldName, filterValue))).toList();
	}

}
