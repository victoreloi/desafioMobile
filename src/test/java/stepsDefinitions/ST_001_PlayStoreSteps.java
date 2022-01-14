package stepsDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.PlayStorePage;

public class ST_001_PlayStoreSteps {

	protected WebDriver driver;
	
	PlayStorePage psp = new PlayStorePage();

	// ST_001_CT_001_RealizarPesquisaEInstalarAplicativo

	@Dado("que o usuario acesse o aplicativo nativo da PlayStore")
	public void queOUsuarioAcesseOAplicativoNativoDaPlayStore() {
		psp.validarCampoPesquisaExiste();
	}

	@Quando("eu preencher o campo de consulta com {string}")
	public void euPreencherOCampoDeConsultaComEClicarSobreALupa(String pesquisa) {
		psp.preencherCampoPesquisaEPesquisar(pesquisa);
	}
	
	@E("selecionar o retorno da pesquisa {string}")
	public void selecionarORetornoDaPesquisaGenTeMobile(String nomeApp) {
		psp.localizarAplicativoEClicar(nomeApp);
	}

	@Entao("a pagina do applicativo {string} aparece na tela")
	public void aPaginaDoApplicativoApareceNaTela(String nomeApp) {
		psp.validarAplicativo(nomeApp);
	}

	@Quando("eu instalar o aplicativo")
	public void euClicarSobreOBotao() {
		psp.realizarInstalacao();
	}

	@Entao("eu poderei clicar em abrir o app baixado")
	public void euPodereiClicarEmAbrirOAppBaixado() {
		psp.clicarAbrirAplicativo();
	}
	
	// ST_001_CT_002_RealizarPesquisaEInstalarEDesinstalar
	
	@Entao("eu poderei desinstalar o aplicativo")
	public void euPodereiDesinstalarOAplicativo() {
		psp.desinstalarAplicativoPelaLoja();
	}
	
	@Entao("o botao instalar aparece novamente")
	public void oBotaoInstalarApareceNovamente() {
		psp.validarSeAplicativoEstaDesinstalado();
	}

}
