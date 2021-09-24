package com.example.comunicacaofragments


/**
 * 12º Essa interface centralizará todas as funções que os componentes dos fragments utilizarão para fazer as comunicações
 * (nesse caso, como há somente um Button para realizar evento, aqui só terá a função enviarTexto(), que recebe uma string como parâmetro. Essa string é o texto que o botão captará do EditText e enviará para a MainActivity para que ela possa enviar para LowerFragment para que ela realize a alteração do texto do TextView -> text_received)
 * 13º A MainActivity implementará essa interface
 * 14º ======= IR PARA MainActivity =======
 * */


interface ICommunicator {

    fun sendText(s: String)

}