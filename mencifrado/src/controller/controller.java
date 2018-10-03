package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
import modelo.modelo;
import view.view;

public class controller implements ActionListener
{
    private final modelo modelo;
    private final view view;

    public controller(view view, modelo modelo)    
    {
        this.view = view;
        this.modelo = modelo;
        view.jmi_abrir.addActionListener(this);
        view.jmi_guardar.addActionListener(this);
        view.jmi_cimen.addActionListener(this);
        view.jmi_desmen.addActionListener(this);
        initView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==view.jmi_abrir){
            JFileChooser file=new JFileChooser(); 
            file.showOpenDialog(null); 
            modelo.readFile(modelo.getPath()); 
            view.jta_texto.setText(modelo.getMessage()); 
        }else if(e.getSource()==view.jmi_guardar){
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(null);
            modelo.setPath(""+file.getSelectedFile());
            modelo.setMessage(view.jta_texto.getText());
            modelo.writeFile(modelo.getPath(), modelo.getMessage());
        }else if(e.getSource()==view.jmi_cimen){
            JFileChooser file=new JFileChooser(); 
            file.showSaveDialog(null);
            modelo.setPath(""+file.getSelectedFile());
            modelo.setMessage(view.jta_texto.getText());
            modelo.writeFileEncrypted(modelo.getPath(), modelo.getMessage());
        }else if(e.getSource()==view.jmi_desmen){
            JFileChooser file=new JFileChooser(); 
            file.showOpenDialog(null);
            modelo.readFileDecrypted(modelo.getPath());
            view.jta_texto.setText(modelo.getMessage()); //muestra el contenido en el JTextArea
        }
    }
    private void initView() 
    {
        view.setTitle("Archivo!");
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}