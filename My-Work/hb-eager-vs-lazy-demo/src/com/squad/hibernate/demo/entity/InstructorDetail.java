package com.squad.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChanel;
	
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy="instructorDetail", cascade=CascadeType.ALL)
	private Instructor instructor;

	public InstructorDetail() {

	}

	public InstructorDetail(String youtubeChanel, String hobby) {
		this.youtubeChanel = youtubeChanel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChanel() {
		return youtubeChanel;
	}

	public void setYoutubeChanel(String youtubeChanel) {
		this.youtubeChanel = youtubeChanel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChanel=" + youtubeChanel + ", hobby=" + hobby + "]";
	}
	
	
	
	
	
	

}
