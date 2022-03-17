class Media {
	private final String name;
	Media (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
class Book extends Media {
	Book( String name) {
		super(name);
	}
}
class Video extends Media {
	Video(String name) {
		super(name);
	}
}


