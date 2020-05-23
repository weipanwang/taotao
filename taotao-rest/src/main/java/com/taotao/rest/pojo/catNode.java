/**
 * 
 */
package com.taotao.rest.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 盼望
 * @date 2019年6月22日下午12:15:39
 */
public class catNode {
	@JsonProperty("u")
	private String url;
	
	@JsonProperty("n")
	private String name;
	
	@JsonProperty("i")
	private List items;
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the items
	 */
	public List getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(List items) {
		this.items = items;
	}
	
	

}
