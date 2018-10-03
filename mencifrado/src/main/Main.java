/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import view.view;
import modelo.modelo;
import controller.controller;

/**
 *
 * @author Dani
 */
public class Main {
 private static view view;
    private static modelo modelo;
    private static controller controller;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        view = new view();
        modelo = new modelo();
        controller = new controller(view,modelo);
    }
    
}
