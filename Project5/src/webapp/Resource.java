package webapp;

public class Resource {
	private String name;
	private String content;
	
	public Resource(String name, String content) {
		this.name = name;
		this.content = content;
	}
	
	public Resource(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public String getContent() {
		return content;
	}
}
