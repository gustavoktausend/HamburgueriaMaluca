package com.aps.hamburgueriamaluca;

import com.aps.hamburgueriamaluca.graphics.KitchenInterface;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        KitchenInterface janela;
        janela = new KitchenInterface();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
