package com.aps.hamburgueriamaluca.graphics;

import com.aps.hamburgueriamaluca.model.Table;
import com.aps.hamburgueriamaluca.network.AtorNetGames;

public class AtorJogador {

    protected Table table;
    protected AtorNetGames rede;
    protected KitchenInterface janela;
    protected String idUsuario;

    public AtorJogador (KitchenInterface jan){
        super();
        rede = new AtorNetGames(this);
        janela = jan;
        table = new Table();
//        mesa.iniciar();
    }

//    public int conectar() {
//        boolean conectado = mesa.verificarStatusConectado();
//        if (!conectado){
//            String servidor = this.obterDadosConexao();
//            boolean exito = rede.conectar(servidor, idUsuario);
//            if (exito){
//                mesa.definirStausConexao(true);
//                return 0;
//            }else{
//                return 2;
//            }
//        }else{
//            return 1;
//        }
//    }

    public KitchenInterface informarJanela() {
        return janela;
    }
//
//    public String obterDadosConexao() {
//        idUsuario = janela.obterIdJogador();
//        String servidor = janela.obterIdServidor();
//        return servidor;
//    }

//    public int desconectar() {
//        boolean conectado = mesa.verificarStatusConectado();
//        if (conectado){
//            boolean exito = rede.desconectar();
//            if (exito){
//                mesa.definirStausConexao(false);
//                return 3;
//            }else{
//                return 5;
//            }
//        }else{
//            return 4;
//        }
//    }

//    public int iniciarPartida() {
//        boolean conectado = false;
//        boolean interromper = false;
//        boolean emAndamento = mesa.informarEmAndamento();
//        if (emAndamento){
//            interromper = this.avaliarInterrupcao();
//        }else{
//            conectado = mesa.verificarStatusConectado();
//        }
//        if (interromper || ((!emAndamento) && conectado)){
//            rede.iniciarPartida();
//            return 6;
//        }
//        if (!conectado) {
//            return 7;
//        }
//        return 13;
//    }

    public boolean avaliarInterrupcao() {
        return true;
    }

    public int obterTipoJogada(int resultado){
        switch(resultado){
            case 10:
                return 3;
            case 14:
                return 2;
            case 15:
                return 1;
            case 16:
                return 4;
            default:
                return 0;
        }
    }

//    public int click(int linha, int coluna) {
//        int resultado = 0;
//        resultado = mesa.click(linha, coluna);
//        int tpJogada = obterTipoJogada(resultado);
//        if ((resultado == 10) || (resultado == 9) || (resultado == 14) || (resultado == 15) || (resultado == 16)){
//            this.enviarJogada(linha, coluna, tpJogada);
//        }
//        return resultado;
//    }

//    public void enviarJogada(int linha, int coluna, int tpJogada) {
//        Lance lance = mesa.informarJogada(linha, coluna, tpJogada);
//        rede.enviarJogada(lance);
//    }

//    public ImagemDeTabuleiro informarEstado() {
//        ImagemDeTabuleiro estado = tab.informarEstado();
//        return estado;
//    }

    public void tratarIniciarPartida(Integer posicao) {

    }

//    public void receberJogada(Lance jogada) {
//        tab.receberJogada(jogada);
//        janela.exibirEstado();
//    }
}
