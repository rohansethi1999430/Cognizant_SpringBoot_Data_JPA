package com.cognizant.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.quiz.model.Attempt;

@Repository
public interface AttemptRepository  extends JpaRepository<Attempt, Integer> {

	@Query(value = "SELECT at FROM user u JOIN attempt at ON at.user = u JOIN attempt_question aq ON aq.attempt = at JOIN attempt_option ao ON ao.attemptQuestion = aq WHERE u.id = :userId AND at.id = :attemptId")
	public Attempt getAttemptDetails(@Param(value = "userId") int userId, @Param(value = "attemptId") int attempId);
}
