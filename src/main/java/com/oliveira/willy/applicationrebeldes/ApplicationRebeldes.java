package com.oliveira.willy.applicationrebeldes;

import com.oliveira.willy.applicationrebeldes.controller.InteligenciaCentral;
import com.oliveira.willy.applicationrebeldes.view.InteligenciaCentralView;
import com.oliveira.willy.applicationrebeldes.view.RebeldeView;

public class ApplicationRebeldes {
    public static void main(String[] args) {
        InteligenciaCentral inteligenciaCentral = new InteligenciaCentral();
        RebeldeView rebeldeView = new RebeldeView();
        InteligenciaCentralView inteligenciaCentralView = new InteligenciaCentralView(inteligenciaCentral, rebeldeView);
        inteligenciaCentralView.exibirMenu();
    }
}
