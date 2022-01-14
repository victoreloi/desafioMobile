package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import stepsDefinitions.Hooks;
import utils.Utils;

public class PlayStorePage {
	
	private AppiumDriver<WebElement> driver;

	public PlayStorePage() {
		this.driver = Hooks.getDriver();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// String de validacoes
	String versaoApp = "2021.12.27.2";
	String dataVersaoApp = "Dec 28, 2021";
	
	// Text area inicial
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Search for apps & games']")
	private MobileElement textAreaPesquisa;
		
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.EditText")
	private MobileElement textFieldPesquisa;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Install']")
	private MobileElement btnInstalar;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Open']")
	private MobileElement btnOpen;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Uninstall']")
	private MobileElement btnUninstall;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]")
	private MobileElement btnUninstallConfirmWindow;
	
	@AndroidFindBy(accessibility = "More results for About this app")
	private MobileElement sobreOAplicativo;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]")
	private MobileElement labelVersion;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]")
	private MobileElement labelUpdateOn;
	
	public void validarCampoPesquisaExiste() {
		assertTrue(textAreaPesquisa.isDisplayed());
	}
	
	public void preencherCampoPesquisaEPesquisar(String pesquisa) {
		textAreaPesquisa.click();
		textFieldPesquisa.sendKeys(pesquisa);
	}
	
	public void localizarAplicativoEClicar(String nomeApp) {
		MobileElement aplicativo = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='" + nomeApp +"']"));
		aplicativo.click();
	}
	
	public void validarAplicativo(String nomeApp) {
		MobileElement aplicativo = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='" + nomeApp +"']"));
		aplicativo.isDisplayed();
	}
	
	public void realizarInstalacao() {
		
		try {
			
			btnInstalar.click();
			
			WebDriverWait wait = new WebDriverWait(driver, 10);

			wait.until(new ExpectedCondition<Boolean>() {
				 
			    public Boolean apply(WebDriver driver) {
			        String clickable = btnOpen.getAttribute("clickable");
			        System.out.println(clickable);
			        if(clickable.equals("true")) 
			            return true;
			        else
			            return false;
			       
			    }
			});
			
		} catch (Exception e) {
			validarSeAplicativoEstaInstalado();
		}
	}
	
	public void validarSeAplicativoEstaInstalado() {
		Utils.esperarElemento(btnOpen);
		Utils.esperarElemento(btnUninstall);
		assertTrue(btnOpen.isDisplayed());
		assertTrue(btnUninstall.isDisplayed());
	}
	
	public void clicarAbrirAplicativo() {
		btnOpen.click();
	}
	
	public void desinstalarAplicativoPelaLoja() {
		btnUninstall.click();
		btnUninstallConfirmWindow.click();
	}	
	
	public void validarSeAplicativoEstaDesinstalado() {
		Utils.esperarElemento(btnInstalar);
		assertTrue(btnInstalar.isDisplayed());
	}
	
	public void navegarAteSobreOAplicativo() {
		sobreOAplicativo.click();
	}
	
	public void validarUltimaVersaoAplicativo() {
		
		assertTrue(labelVersion.getText().contains(versaoApp));
		assertTrue(labelUpdateOn.getText().contains(dataVersaoApp));
	}

}
