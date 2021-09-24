package com.example.comunicacaofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment


/**
 * 0º ======= MainActivity =======
 * 1º Ao criar o projeto, já terá a MainActivity e seu layout xml
 * 2º Criar dois containers (FrameLayout) em activity_main.xml para abrigar os
 * fragments
 * 3º Criar duas classes fragments (UpperFragment e LowerFragment)
 * com seus respectivos layouts xml para serem inflados nos containers
 * 4º Adicionar um EditText e um Button no fragment_upper.xml e adicionar um TextView centralizado em fragment_lower.xml(ao clicar no botão o texto digitado será exibido em no TextView, essa será a comunicação entre os fragments)
 * 5º Adicionar os fragments nos containers da activity_main.xml através do
 * supportFragmentManager.beginTransaction() e commitar
 * 6º ======= IR PARA UpperFragment =======
 *
 *
 * 15º Implementar a interface ICommunicator e fazer override das funções da interface
 * 16º ======= IR PARA LowerFragment =======
 *
 *
 * 25º Dentro da função sendText, chamar a função setTextReceived (essa função é a que edita o TextView no LowerFragment) passando como parâmetro a string recebida
 * 26º PARABÉNS!!! Se você seguiu todos os passos até aqui, você conseguiu fazer uma comunicação simples unilateral entre dois fragments.
 *
 *
 * PRÓXIMO PASSO:
 * Você conseguiu entender tudo?
 * Não: volte a tente entender o passo a passo
 * Sim: Agora você que você entendeu uma comunicação unilateral, tente fazer uma comunicação bilateral, onde ambos os fragments possuem eventos de comunicação com outros fragments.
 *
 * DICAS:
 * Você pode centralizar todos as funções relacionadas a comunicação entre fragments na mesma interface, lembrando sempre de fazer os overrides aqui na MainActivity.
 * Um fragment só precisa ter um listener se ele for enviar alguma coisa para outro fragment, se ele for só receber, não precisa criar listener
 * Para deixar o código mais legível eu sempre crio as funções:
 * initViews() -> inicializo todos os elementos que vem do meu layout que precisarei usar no código
 * initFragments() -> inicializo as instâncias dos fragmentos
 * setFragment() -> serve basicamente para inflar um fragment em um container. Eu recebo ambos como parâmetros da função
 *
 * SE, E SOMENTE SE, eu precisasse limpar um container eu reiaria a função removeFragment recebendo um fragmento como parâmetro e dentro dela eu usaria a função remove() passando como parâmetro o fragment que desejo excluir.
 *
 * Centralizo as funcionalidades para não estar repetindo o mesmo código várias vezes.
 *
 * */


class MainActivity : AppCompatActivity(), ICommunicator {

    // Criando objetos para manipular fragments
    private lateinit var upperContainer: FrameLayout
    private lateinit var lowerContainer: FrameLayout

    private lateinit var upperFragment: UpperFragment
    private lateinit var lowerFragment: LowerFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializando de Views
        initViews()

        // Inicialização de fragments
        initFragments()

        // Adicionando fragments aos containers (frames laytous da activity_main.xml)
        setFragment(upperContainer, upperFragment)
        setFragment(lowerContainer, lowerFragment)
    }


    /**
     * Inicializa Views de activity_main.xml
     * */
    private fun initViews() {
        setContentView(R.layout.activity_main)
        upperContainer = findViewById(R.id.upper_container)
        lowerContainer = findViewById(R.id.lower_container)
    }


    /**
    * Inicializa Fragments
    * */
    private fun initFragments() {
        upperFragment = UpperFragment()
        lowerFragment = LowerFragment()
    }


    /**
     * Setar um fragmento em um container
     * */
    private fun setFragment(container: FrameLayout, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(container.id, fragment)
            .commit()
    }


    /**
     * Passa texto para setar TextView textReceived de LowerFragment
     * */
    override fun sendText(s: String) {
        lowerFragment.setTextReceived(s)
    }

}