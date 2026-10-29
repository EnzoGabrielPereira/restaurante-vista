
package Controller;

import View.Caixa_GUI;
import static View.Caixa_GUI.codcomanda2;
import static View.Caixa_GUI.mesa2_txt;
import static View.Caixa_GUI.status2_txt;
import static View.Caixa_GUI.tab_caixa;
import static View.Caixa_GUI.tab_caixa2;
import static View.Caixa_GUI.total_txt;
import View.Cardapio_GUI;
import static View.Cardapio_GUI.codcomanda_txt;
import static View.Cardapio_GUI.codprato_txt;
import static View.Cardapio_GUI.nomeprato_txt;
import static View.Cardapio_GUI.obs_txt;
import static View.Cardapio_GUI.preco_txt;
import static View.Cardapio_GUI.quant_txt;
import View.Comanda_GUI;
import static View.Comanda_GUI.nummesa_txt;
import static View.Comanda_GUI.status_txt;
import View.Menu_GUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Funcoes_DAO {
    public static int nummesa;
    public static String status;
    public static String url = "jdbc:mysql://localhost:3306/vista_restaurante"; // enderço do BD
    public static String username = "root";        //nome de um usuário de seu BD
    public static String password = "SUA_SENHA_AQUI";  // senha do BD
    
    
    public static void cadastrarComanda() {
      //Inicio
      
      nummesa = Integer.parseInt(nummesa_txt.getText());
      status = status_txt.getText(); 

       Controller.Conecta_DAO.carregaDriver();
       
      try {  
            Connection con = null;
            
    try {
    con = (Connection) DriverManager.getConnection(url, username, password);
    } catch (SQLException ex) {

    Logger.getLogger(Comanda_GUI.class.getName()).log(Level.SEVERE, null, ex);

            
                   }

            // Recebendo os dados a serem inseridos na tabela
            String sql = "INSERT INTO comanda(num_mesa,status) values('"+nummesa+"','"+status+"')";
     
            try { // Tratamento de Erros para inserção

                // Criando varialvel que executara a inserção
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

  JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                nummesa_txt.setText("");
                status_txt.setText("");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            nummesa_txt.setText("");
        }

       
      
      //Fim
  }
    
public static void consultarPedido (){
      
      //Incio
      
      try{   
  //Iniciando o possivel tratamento de erros
            //Declarando a variavel código

            int codigo = Integer.valueOf(codprato_txt.getText());

            Controller.Conecta_DAO.carregaDriver();


            try {// Tratamento de erro para a conexao
                // Declarando  a variavel de conexão con
                // e estabelendo a conexão
                Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(Cardapio_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Declarando uma string com o comando mySQL para consulta


                String sql = "SELECT nom_prato, prec_prato FROM cardapio where id_cardapio = "+codigo;



                // Criando variavel que executara o comando da string sql
                Statement stm = (Statement) con.createStatement();
                try//Tratamento de erro da consulta
                { //Criando variavel que exibira os resultados
                    //Executando o comando da string sql na variavel rs
                    ResultSet rs = stm.executeQuery(sql);

                    int i=0; // Variavel utilizada para saber se ha dados cadastrados

                    while (rs.next()) {  // Criando variaveis que receberão os valores do banco de dados
                        String nome_prato = rs.getString("nom_prato");
                        String preco_prato = rs.getString("prec_prato");

                        i++;

                        nomeprato_txt.setText(String.valueOf(nome_prato));
                        preco_txt.setText(String.valueOf(preco_prato));

                    }

                    if(i==0){ // Verificando se ha dados cadastrados atraves da variavel i

                        JOptionPane.showMessageDialog(null,"Dado não cadastrado","Resultado",-1);

                    }

                } catch (Exception ex) { // Consulta mal sucedida
                    JOptionPane.showMessageDialog(null,"\nErro ao consultar!","ERRO",0);
                }

            } catch (SQLException ex) {
                // Conexão com servidor mal sucedida
                JOptionPane.showMessageDialog(null,"Erro ao conectar com o servidor","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Código fora do formato
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            codprato_txt.setText("");
        }
      
      
      //Fim
      
      
  }
  
public static int codprato;
public static String nomeprato;
public static double preco;
public static int codcomanda;
public static String obs;
public static int quant;

public static void adicionarPedido() {
      //Inicio
      
      codprato = Integer.parseInt(codprato_txt.getText()); 
      quant = Integer.parseInt(quant_txt.getText());   
      nomeprato = nomeprato_txt.getText();
      codcomanda = Integer.parseInt(codcomanda_txt.getText());
      obs = obs_txt.getText();
      preco = Double.parseDouble(preco_txt.getText());
      

       Controller.Conecta_DAO.carregaDriver();
       
      try { 
            Connection con = null;
    try {
    con = DriverManager.getConnection(url, username, password);
    } catch (SQLException ex) {

    Logger.getLogger(Cardapio_GUI.class.getName()).log(Level.SEVERE, null, ex);
                   }

            // Recebendo os dados a serem inseridos na tabela
            String sql = "INSERT INTO pedido(prato,quantidade,observacao,valor,id_comanda,id_cardapio) values('"+nomeprato+"','"+quant+"','"+obs+"','"+preco+"','"+codcomanda+"','"+codprato+"')";
     
            
            try { // Tratamento de Erros para inserção

                // Criando varialvel que executara a inserção
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

  JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                codcomanda_txt.setText("");
                codprato_txt.setText("");
                quant_txt.setText("");
                nomeprato_txt.setText("");
                preco_txt.setText("");
                obs_txt.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            codcomanda_txt.setText("");
        }

       
      
      //Fim
  }



public static void selecionar(){
      
      //Incio
      
      try{   
  //Iniciando o possivel tratamento de erros
            //Declarando a variavel código

            int codigo = Integer.valueOf(codcomanda2.getText());

            Controller.Conecta_DAO.carregaDriver();


            try {// Tratamento de erro para a conexao
                // Declarando  a variavel de conexão con
                // e estabelendo a conexão
                Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(Caixa_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Declarando uma string com o comando mySQL para consulta


                String sql = "SELECT status, num_mesa FROM comanda where id_comanda = "+codigo;



                // Criando variavel que executara o comando da string sql
                Statement stm = (Statement) con.createStatement();
                try//Tratamento de erro da consulta
                { //Criando variavel que exibira os resultados
                    //Executando o comando da string sql na variavel rs
                    ResultSet rs = stm.executeQuery(sql);

                    int i=0; // Variavel utilizada para saber se ha dados cadastrados

                    while (rs.next()) {  // Criando variaveis que receberão os valores do banco de dados
                        String status2 = rs.getString("status");
                        String mesa = rs.getString("num_mesa");

                        i++;

                        status2_txt.setText(String.valueOf(status2));
                        mesa2_txt.setText(String.valueOf(mesa));

                    }

                    if(i==0){ // Verificando se ha dados cadastrados atraves da variavel i

                        JOptionPane.showMessageDialog(null,"Dado não cadastrado","Resultado",-1);

                    }

                } catch (Exception ex) { // Consulta mal sucedida
                    JOptionPane.showMessageDialog(null,"\nErro ao consultar!","ERRO",0);
                }

            } catch (SQLException ex) {
                // Conexão com servidor mal sucedida
                JOptionPane.showMessageDialog(null,"Erro ao conectar com o servidor","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Código fora do formato
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            codcomanda2.setText("");
        }
      
      
      //Fim
      
      
  }

public static int comanda2;
public static String status2;
public static int mesa2;
public static void alterar(){
      
      //Inicio
      comanda2 = Integer.parseInt(codcomanda2.getText()); 
      mesa2 = Integer.parseInt(mesa2_txt.getText());   
      status2 = status2_txt.getText();      
      
      int codigo = Integer.parseInt(codcomanda2.getText());
      
       Controller.Conecta_DAO.carregaDriver();
       
      try {     
            Connection con = null;
      try {
            con = DriverManager.getConnection(url, username, password);
      }catch (SQLException ex) {
            Logger.getLogger(Caixa_GUI.class.getName()).log(Level.SEVERE, null, ex);
      }
            String sql = "UPDATE comanda SET num_mesa='"+mesa2+"',status='"+status2+"' WHERE id_comanda="+codigo;
            
     
            try { 
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

                JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);

                codcomanda2.setText("");
                mesa2_txt.setText("");
                status2_txt.setText("");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException e){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            codcomanda2.setText("");
        }    

      
      
      //Fim
      
  }
public static void excluir(){
      
      //Inicio
      
      Controller.Conecta_DAO.carregaDriver();


        int codigo = Integer.valueOf(codcomanda2.getText()); // Recebendo o código

                

        try {// Tratamento de erro para a conexao
            // Declarando  a variavel de conexão con
            // e estabelendo a conexão
            Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(Caixa_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
           

            // Criando String com comando SQL para exclusão
            String sql = "DELETE FROM pedido WHERE id_comanda = "+codigo;
            String sqll = "DELETE FROM COMANDA WHERE id_comanda = "+codigo;

            try // Tratamento de erros para exclusão
            {// Criando Variavel para executar a ação
                PreparedStatement excluir = (PreparedStatement) con.prepareStatement(sql);
                excluir.execute();// Executando a exclusão

                PreparedStatement excluir1 = (PreparedStatement) con.prepareStatement(sqll);
                excluir1.execute();// Executando a exclusão
                
                JOptionPane.showMessageDialog(null,"\nExclusão realizada com sucesso!!!\n","",-1);
                codcomanda2.setText("");
                mesa2_txt.setText("");
                status2_txt.setText("");
                total_txt.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na exclusão!","ERRO!",0);
            }

        } catch(NumberFormatException erro){ // Codigo digitado com caracteres não numericos
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            codcomanda2.setText("");

        }

      
      
      //Fim
  }

public static void excluir2(){
      
      //Inicio
      
      Controller.Conecta_DAO.carregaDriver();


        int codigo = Integer.valueOf(codcomanda2.getText()); // Recebendo o código

                

        try {// Tratamento de erro para a conexao
            // Declarando  a variavel de conexão con
            // e estabelendo a conexão
            Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(Caixa_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
           

            // Criando String com comando SQL para exclusão
            String sql = "DELETE FROM comanda WHERE id_comanda = "+codigo;

            try // Tratamento de erros para exclusão
            {// Criando Variavel para executar a ação
                PreparedStatement excluir = (PreparedStatement) con.prepareStatement(sql);
                excluir.execute();// Executando a exclusão

                JOptionPane.showMessageDialog(null,"\nExclusão realizada com sucesso!!!\n","",-1);
                codcomanda2.setText("");
                mesa2_txt.setText("");
                status2_txt.setText("");
                total_txt.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na exclusão!","ERRO!",0);
            }

        } catch(NumberFormatException erro){ // Codigo digitado com caracteres não numericos
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            codcomanda2.setText("");

        }

      
      
      //Fim
  }

public static void valor(){
    
    double total =0;
    
    String cod = codcomanda2.getText();
    
    int cod1 = Integer.parseInt(cod);
    
    
    for(int c = 0; c < tab_caixa2.getRowCount(); c++){
        
    if(cod1 == Integer.parseInt(tab_caixa.getValueAt(c,0).toString())){
        
        int id = Integer.parseInt(tab_caixa2.getValueAt(c,0).toString());
        double preco = Double.parseDouble(tab_caixa2.getValueAt(c, 2).toString());
        int qtd = Integer.parseInt(tab_caixa2.getValueAt(c, 1).toString());
        
        
        double mult = (preco * qtd);
        
        total = total + mult;
    }
    }
    View.Caixa_GUI.total_txt.setText(String.format("%.2f", total));
    
    
}


}

