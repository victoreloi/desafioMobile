package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "pretty",
		features = "classpath:Features",
		glue = "stepsDefinitions",
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		dryRun = false,
		tags = "@ST_001_CT_001_RealizarPesquisaEInstalarAplicativo"
		)

public class ST_001_CT_001_RealizarPesquisaEInstalarAplicativoTest {

}