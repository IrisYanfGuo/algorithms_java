package socialNetworks;



public class Message {

	private String content;
	private String author;
	private int smallAge; // age limit,the smallest age
	private int largeAge; // the biggest age
	public int privacy; // 0 is public, 1friends ,2 friends of friends

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(String content, String author, int smallAge, int largeAge, int privacy) {
		// TODO Auto-generated constructor stub
		this.content = content;
		this.author = author;
		this.largeAge = largeAge;
		this.smallAge = smallAge;
		this.privacy = privacy;
	}

	@Override
	public String toString() {
		String s = "-------------author: "+author+"-----------\n"
				+content+"\n"+
				"----------------------------------------\n\n";
		return s;
				

	}

	public String getAuthor() {
		return author;
	}

	public void setName(String name) {
		author = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content1) {
		content = content1;
	}

	public void setSmallAge(int sage) {
		smallAge = sage;
	}

	private int getLargeAge() {
		return largeAge;

	}

	public void setLargeAge(int lage) {
		smallAge = lage;
	}

	public int getSmallAge() {
		return smallAge;
	}
	
	public void print() {
		System.out.println(toString());
	}

}
