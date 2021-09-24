package com.example.comunicacaofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * 17º No topo da classe, instanciar o TextView (textReceived)
 * 18º No método onCreateView() inicializar o objeto TextView criado
 * 19º Criar função setTextReceived para alterar o texto do TextView textReceived
 * 20º ======= IR PARA UpperFragment =======
 *
 * */


class LowerFragment : Fragment() {

    // Criando objetos de Views(visualizações) do fragment_lower.xml
    private lateinit var textReceived: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // criando uma variável que recebe o layout xml que representa esse fragment
        val view: View? = inflater.inflate(R.layout.fragment_lower, container, false)

        when (view) {
            null -> {
                throw NullPointerException("Layout de Fragment não encontrado.")
            }
            else -> {
                // inicializando views
                initViews(view)
            }
        }

        return view
    }


    /**
     * Inicializa Views de fragment_lower.xml
     * */
    private fun initViews(v: View) {
        textReceived = v.findViewById(R.id.text_received)
    }


    /**
     * Atualiza texto do TextViewtext Received
     * */
    fun setTextReceived(s: String) {
        textReceived.text = s
    }
}