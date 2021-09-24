package com.example.comunicacaofragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import java.lang.RuntimeException


/**
 * 7º No topo da classe, instanciar o EditText e o Button
 * 8º No método onCreateView() inicializar os objetos EditText e Button criados
 * 9º Implementar a interface View.OnClickListener para centralizar todos os eventos de cliques do usuário em um lugar só
 * 10º Criar a interface ICommunicator
 * 11º ======= IR PARA ICommunicator =======
 *
 *
 * 21º Criar listener (listenerFragment), um objeto do tipo da interface ICommunicator, pois será o elemento de interação entre o UpperFragment e a MainActivity
 * 22º Fazer override da função onAttach, que tem como parâmetro uma activity, no nosso caso a MainActivity.
 *
 (Essa função verificará se a activity recebida como contexto implementa a interface ICommunicator. Em caso negativo lançará uma RuntimeException, em caso positivo o listenerFragment receberá a activity. A partir daqui através desse listener será possível acessar as funções da MainActivity)
 *
 * 23º No tratamento de click do botão buttonSendText, chamar a função sendText da MainActivity passando como parâmetro o texto digitado no EditText editTypedText
 * 24º ======= IR PARA MainActivity =======
 *
 * */


class UpperFragment : Fragment(), View.OnClickListener {

    // Criando objetos de Views(visualizações) do fragment_upper.xml
    private lateinit var editTypedText: EditText
    private lateinit var buttonSendText: Button
    private lateinit var listenerFragment: ICommunicator


    override fun onAttach(context: Context) {
        super.onAttach(context)

        // verificando se o contexto recebido (a activity) implementou a interface ICommunicator
        when(context) {
            !is ICommunicator -> {
                // se não implementou ICommunicator lançará exceção
                throw RuntimeException("Interface ICommunicator não foi implementada em MainActivity")
            }
            else -> {
                // atribuindo a activity à variável que fará ligação entre este fragment e a activity
                listenerFragment = context
            }
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // criando uma variável que recebe o layout xml que representa esse fragment
        val view: View? = inflater.inflate(R.layout.fragment_upper, container, false)

        when (view) {
            null -> {
                throw NullPointerException("Layout de Fragment não encontrado.")
            }
            else -> {
                // inicializando views
                initViews(view)
                // centralizando listeners
                setListerners()
            }
        }

        return view
    }


    /**
     * Inicializa Views de fragment_upper.xml
     * */
    private fun initViews(v: View) {
        editTypedText = v.findViewById(R.id.edit_typed_text)
        buttonSendText = v.findViewById(R.id.button_send_text)
    }


    /**
     * Escuta os eventos de clique das Views que realizam alguma ação
     * */
    private fun setListerners() {
        buttonSendText.setOnClickListener(this)
    }


    /**
     * Tratamento de cliques
     * */
    override fun onClick(v: View) {
        when (v) {
            buttonSendText -> {
                listenerFragment.sendText(
                    editTypedText.text.toString()
                )
            }
        }
    }

}