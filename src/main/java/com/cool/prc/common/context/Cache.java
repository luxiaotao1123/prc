package com.cool.prc.common.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * 缓存
 */
public class Cache {

	private Map<String,Object> caches=new ConcurrentHashMap<>();
	
	@SuppressWarnings("unchecked")
	public <T>T get(Class<T> prototype) {
		return (T) get(prototype.getName());
	}
	
	public Object get(String key) {
		return get(key,true);
	}
	
	@SuppressWarnings("unchecked")
	public <T>T get(String key,Supplier<T> func){
		if(!hasKey(key)) {
			put(key,func.get());
		}
		return (T)get(key);
	}
	
	public Object get(String key,boolean exist) {
		if(exist) {
			if(!hasKey(key)) {
				throw new RuntimeException(this+"-找不到缓存对象:"+key);
			}
		}
		return caches.get(key);
	}
	
	public void put(Object value) {
		String key=value.getClass().getName();
		put(key,value);
	}
	
	public void put(String key,Object value) {
		put(key, value,true);
	}
	
	public void put(String key,Object value,boolean exist) {
		if(exist) {
			if(hasKey(key)) {
				throw new RuntimeException(this+"-缓存"+key+"已存在");
			}
		}
		caches.put(key, value);
	}
	
	public boolean hasKey(Class<?> prototype) {
		return hasKey(prototype.getName());
	}
	
	public boolean hasKey(String key) {
		return caches.containsKey(key);
	}
	
}
