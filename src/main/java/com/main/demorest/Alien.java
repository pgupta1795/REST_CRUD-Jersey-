package com.main.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {

	protected int ID_1;
	protected String name;
	protected int points;
	protected String hobby;

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getId() {
		return ID_1;
	}

	public void setId(int ID_1) {
		this.ID_1 = ID_1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
