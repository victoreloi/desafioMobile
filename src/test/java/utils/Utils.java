package utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import stepsDefinitions.Hooks;

public class Utils {
	
	// --- Metodos de espera
	public static void esperarElemento(WebElement elemento) {
	
		WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(elemento));
	}

	public static void esperarPagina(int tempo) {
		Hooks.getDriver().manage().timeouts().implicitlyWait(tempo, TimeUnit.SECONDS);
	}
	
	// --- Evidencias

	public static File gerarScreenshot(Scenario cenario) {

		final byte[] screenshot = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.BYTES);
		cenario.attach(screenshot, "image/png", "screenshot");
		File imagem = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem,
					(new File("./target/screenshots", cenario.getName() + "-" + cenario.getStatus() + ".png")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imagem;
	}
}
