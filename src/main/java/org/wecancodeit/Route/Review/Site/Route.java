package org.wecancodeit.Route.Review.Site;

public class Route {

	private Long id;
	private String name;
	private String img;
	private String description;
	private String grade;

	public Route(long id, String name, String img, String grade, String description) {
		this.id = id;
		this.name = name;
		this.img = img;
		this.grade = grade;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getImg() {
		return img;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public String getDescription() {
		return description;
	}
}
