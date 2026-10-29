/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author enzog
 */
public class Conecta_DAO {
     public static  void carregaDriver(){
       try { // Conecttando o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver carregado com sucesso!");




       } catch (Exception ex) { // Erro driver não encontrado
            System.out.println("Driver nao pode ser carregado!");
        }

    }
    
}
