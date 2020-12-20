package views.conta;
import java.awt.BorderLayout;
import java.awt.Color;
    
import javax.swing.JFrame;

import views.templates.Painel;
import views.templates.Menu;
    
   
public class TelaPrincipalConta  extends JFrame {
    public TelaPrincipalConta(){
        organizarLayout();
        
        setTitle("Contas");
                
        //Tamanho da tela
        setSize(500, 600);
                
        //Aplicação abre no centro da tela
        setLocationRelativeTo(null);
        
        //Para finalizar a aplicação
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Fica Visível
        setVisible(true);
    }

    private void organizarLayout() {
        setLayout(new BorderLayout());
        
        Painel painelFuncionario= new Painel("Gerenciador de Contas");
        add(painelFuncionario, BorderLayout.NORTH);
        
        Menu menu = new Menu("conta","conta");
        add(menu, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        new TelaPrincipalConta();
    }
}