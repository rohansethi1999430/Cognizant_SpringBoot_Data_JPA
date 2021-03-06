package com.cognizant.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.quiz.model.Attempt;
import com.cognizant.quiz.model.AttemptOption;
import com.cognizant.quiz.model.AttemptQuestion;
import com.cognizant.quiz.model.Options;
import com.cognizant.quiz.service.AttemptService;

@SpringBootApplication
public class Handson1QuizApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(Handson1QuizApplication.class);

	public static AttemptService attemptService;

	private static void testGetAttemptDetails() {

		LOGGER.info("----Start----");
		Attempt attempt = attemptService.getAttemptDetails(1, 1);

		for (AttemptQuestion attemptQuestion : attempt.getAttemptQuestionList()) {
			LOGGER.debug("{}", attemptQuestion.getQuestion().getText());
			int i = 1;
			for (AttemptOption attemptOption : attemptQuestion.getAttemptOptionList()) {
				Options option = attemptOption.getOption();
				LOGGER.debug("{}) {} {} {}", i, String.format("%-10s", option.getText()),
						String.format("%-7.1f", option.getScore()), attemptOption.isSelected());
				i++;
			}
		}
		LOGGER.info("----End----");
	}

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Handson1QuizApplication.class, args);

		attemptService = context.getBean(AttemptService.class);

		testGetAttemptDetails();
	}
}
