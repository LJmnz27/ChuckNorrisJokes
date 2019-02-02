package org.pursuit.notification_app_hw_jimenez_luis.model;

/**
 * No need for setters if you aren't going to use them.
 * I like your overridden toString method.
 */
public class Joke{
	private String iconUrl;
	private String id;
	private Object category;
	private String value;
	private String url;

	public void setIconUrl(String iconUrl){
		this.iconUrl = iconUrl;
	}

	public String getIconUrl(){
		return iconUrl;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCategory(Object category){
		this.category = category;
	}

	public Object getCategory(){
		return category;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Joke{" + 
			"icon_url = '" + iconUrl + '\'' + 
			",id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			",value = '" + value + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}
