package com.example.referencedata.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.bson.conversions.Bson;

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

	public Single<List<T>> findByFilterValue(final String fieldName, final Object filterValue) {
		return Flowable.fromPublisher(getCollection().find(Filters.eq(fieldName, filterValue))).toList();
	}
	
	
	public Single<List<T>> filterNameValueMap(final Map<String,Object> filterNameValueMap) {
		List<Bson> filterList = new ArrayList<Bson>();
		filterNameValueMap.forEach((k, v) -> filterList.add(Filters.eq(k, v)));
		return Flowable.fromPublisher(getCollection().find(Filters.and(filterList))).toList();
	}

}
