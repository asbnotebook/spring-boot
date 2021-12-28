package com.asb.example;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.internal.command.CommandFactory;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TaxCalculatorService {

	@Value("${kie.containerId}")
	private String containerId;

	@Value("${kie.server.user}")
	private String user;

	@Value("${kie.server.pwd}")
	private String password;

	@Value("${kie.server.url}")
	private String url;

	private String outIdentifier = "response";

	public IncomeDetails calculateIncomeTax(IncomeDetails incomeObj) {

		IncomeDetails response = null;

		KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(url, user, password, 60000);
		config.setMarshallingFormat(MarshallingFormat.JSON);

		RuleServicesClient client = KieServicesFactory.newKieServicesClient(config)
				.getServicesClient(RuleServicesClient.class);

		BatchExecutionCommand batchExecutionCommand = batchCommand(incomeObj);
		ServiceResponse<ExecutionResults> result = client.executeCommandsWithResults(containerId,
				batchExecutionCommand);

		if (result.getType() == ServiceResponse.ResponseType.SUCCESS) {
			response = (IncomeDetails) result.getResult().getValue(outIdentifier);
		} else {
			System.out.println("Something went wrong!!");
		}
		return response;
	}

	private BatchExecutionCommand batchCommand(IncomeDetails incomeObj) {
		List<Command<?>> cmds = buildCommands(incomeObj);
		return CommandFactory.newBatchExecution(cmds);
	}

	private List<Command<?>> buildCommands(IncomeDetails incomeObj) {
		List<Command<?>> cmds = new ArrayList<>();
		KieCommands commands = KieServices.Factory.get().getCommands();
		cmds.add(commands.newInsert(incomeObj, outIdentifier));
		cmds.add(commands.newFireAllRules());
		return cmds;
	}
}