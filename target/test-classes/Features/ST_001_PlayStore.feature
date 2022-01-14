#language: pt
#author: Victor Hugo Alves Eloi

# ST = suite de teste
@ST_001_PlayStore @End2End
Funcionalidade: Instalar o applicativo Gen.te Mobile

  Contexto: 
    Dado que o usuario acesse o aplicativo nativo da PlayStore

  # CT = cenario de teste
  @ST_001_CT_001_RealizarPesquisaEInstalarAplicativo
  Cenario: Pesquisar por aplicativo, instalar e abrir
    Quando eu preencher o campo de consulta com "Gente Mobile"
    E selecionar o retorno da pesquisa "Gen.te Mobile" 
    Entao a pagina do applicativo "Gen.te Mobile" aparece na tela
    Quando eu instalar o aplicativo
    Entao eu poderei clicar em abrir o app baixado
    
  @ST_001_CT_002_RealizarPesquisaEInstalarEDesinstalar
  Cenario: Pesquisar por aplicativo instalar e desinstalar
    Quando eu preencher o campo de consulta com "Gente Mobile"
    E selecionar o retorno da pesquisa "Gen.te Mobile" 
    Entao a pagina do applicativo "Gen.te Mobile" aparece na tela
    Quando eu instalar o aplicativo
    Entao eu poderei desinstalar o aplicativo
    E o botao instalar aparece novamente