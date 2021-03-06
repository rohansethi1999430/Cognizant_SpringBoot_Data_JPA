package com.cognizant.quiz.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "attempt_question")
public class AttemptQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aq_id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aq_at_id")
	private Attempt attempt;

	@ManyToOne
	@JoinColumn(name = "aq_qt_id")
	private Question question;

	@OneToMany(mappedBy = "attemptQuestion", fetch = FetchType.EAGER)
	private List<AttemptOption> attemptOptionList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Attempt getAttempt() {
		return attempt;
	}

	public void setAttempt(Attempt attempt) {
		this.attempt = attempt;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<AttemptOption> getAttemptOptionList() {
		return attemptOptionList;
	}

	public void setAttemptOptionList(List<AttemptOption> attemptOptionList) {
		this.attemptOptionList = attemptOptionList;
	}

	@Override
	public String toString() {
		return "AttemptQuestion [id=" + id + ", attempt=" + attempt + ", question=" + question + "]";
	}
}
