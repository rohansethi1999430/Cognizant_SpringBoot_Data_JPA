package com.cognizant.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "attempt_option")
public class AttemptOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ao_id")
	int id;

	@ManyToOne
	@JoinColumn(name = "ao_op_id")
	Options option;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ao_aq_id")
	AttemptQuestion attemptQuestion;

	@Column(name = "ao_selected", columnDefinition = "BIT")
	boolean selected;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Options getOption() {
		return option;
	}

	public void setOption(Options option) {
		this.option = option;
	}

	public AttemptQuestion getAttemptQuestion() {
		return attemptQuestion;
	}

	public void setAttemptQuestion(AttemptQuestion attemptQuestion) {
		this.attemptQuestion = attemptQuestion;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "AttemptOption [id=" + id + ", attemptQuestion=" + attemptQuestion + ", selected=" + selected + "]";
	}
}
