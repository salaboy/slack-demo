package com.salaboy.slackdemo;

import com.palantir.roboslack.api.MessageRequest;
import com.palantir.roboslack.api.markdown.SlackMarkdown;
import com.palantir.roboslack.webhook.SlackWebHookService;
import com.palantir.roboslack.webhook.api.model.WebHookToken;
import com.palantir.roboslack.webhook.api.model.response.ResponseCode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "com.salaboy.slackdemo"})
public class SlackDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlackDemoApplication.class, args);
		SlackDemoApplication.doSomethingWithPalantirWebHooks();
	}


	public static void doSomethingWithPalantirWebHooks(){
		WebHookToken token = WebHookToken.fromString("https://hooks.slack.com/services/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");

		MessageRequest message = MessageRequest.builder()
				.username("activiti-cloud-bot")

				// SlackMarkdown string decoration is handled automatically in fields that require it,
				// so this is valid:
				.iconEmoji(SlackMarkdown.EMOJI.decorate("smile"))
				// and passing in the raw decorated string is valid:
				.iconEmoji(":smile:")
				// or lastly, just pass the undecorated string (also valid):
				.iconEmoji("smile")

				.text("The simplest message")
				.build();

		ResponseCode response = SlackWebHookService.with(token)
				.sendMessage(message);
	}





}
