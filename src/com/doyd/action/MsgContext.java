package com.doyd.action;

public class MsgContext {
	private boolean state;
	private String message;
	private int id;
	private Object info;
	
	public MsgContext(){
	}
	
	public MsgContext(boolean state){
		this.state = state;
	}
	
	public MsgContext(boolean state, String msg){
		this.state = state;
		this.message = (msg!=null?msg:"")+(state?"成功":"失败");
	}
	
	public MsgContext(boolean state, String msg, String desc){
		this.state = state;
		this.message = (msg!=null?msg:"")+(state?"成功":"失败")+(desc!=null?("，"+desc):"");
	}
	

	
	public boolean isState() {
		return state;
	}
	public MsgContext setState(boolean state) {
		this.state = state;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public MsgContext setMessage(String message) {
		this.message = message;
		return this;
	}
	public Object getInfo() {
		return info;
	}
	public MsgContext setInfo(Object info) {
		this.info = info;
		return this;
	}
	public int getId() {
		return id;
	}

	public MsgContext setId(int id) {
		this.id = id;
		return this;
	}

	public String toString(){
		String message = this.message==null?null:this.message.toString();
		String info = this.info==null?null:this.info.toString();
		StringBuffer json = new StringBuffer();
		json.append("{\"state\":").append(state).append(",");
		if(id!=0){
			json.append("\"id\":").append(id).append(",");
		}
		json.append("\"message\":\"").append(message).append("\",");
		if(info!=null && ((info.startsWith("{") && info.endsWith("}")) 
				||( info.startsWith("[") && info.endsWith("]"))) ){
			json.append("\"info\":").append(info);
		}else{
			if(info!=null){
				info = info.replace("\"", "\\\"");
				json.append("\"info\":\"").append(info).append("\"");
			}else{
				json.append("\"info\":null");
			}
		}
		json.append("}");
		return json.toString();
	}
}
