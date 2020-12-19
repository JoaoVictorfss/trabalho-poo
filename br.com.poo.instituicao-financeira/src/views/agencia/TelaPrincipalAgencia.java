package views.agencia;

    import java.awt.BorderLayout;
    import java.awt.Color;
    
    import javax.swing.JFrame;

import views.templates.Menu;
import views.templates.Painel;
public class TelaPrincipalAgencia extends JFrame {
    public TelaPrincipalAgencia(){
        organizarLayout();
        
        setTitle("Agencias");
                
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
        
        Painel painelAgencia = new Painel("Gerenciador de agencias");
        add(painelAgencia, BorderLayout.NORTH);
        
        Menu menu = new Menu("Salvar agencia(s)");
        add(menu, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        new TelaPrincipalAgencia();
    }
}