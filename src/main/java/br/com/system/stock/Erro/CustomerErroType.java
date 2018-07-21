/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.system.stock.Erro;

/**
 *
 * @author yallison.melo
 */
public class CustomerErroType {

    private String erroMessenge;

    public CustomerErroType(String erroMessenge) {
        this.erroMessenge = erroMessenge;
    }

    public String getErroMessenge() {
        return erroMessenge;
    }

    public void setErroMessenge(String erroMessenge) {
        this.erroMessenge = erroMessenge;
    }

}
