package com.vamsi.sbapp.dao;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeeTestDao {
	
	ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>(16, 0.75f, 16);
	public void addToMap() {
		concurrentHashMap.entrySet()
        .stream()
        .sorted(Entry.comparingByValue())
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1,  e2) -> e1, LinkedHashMap::new));

	}
}
