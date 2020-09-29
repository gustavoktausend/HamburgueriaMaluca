package com.aps.hamburgueriamaluca;

import com.aps.hamburgueriamaluca.graphics.InterfaceCozinha;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        InterfaceCozinha janela;
        janela = new InterfaceCozinha();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
