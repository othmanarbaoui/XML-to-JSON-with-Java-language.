import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XmlToJsonView extends JFrame {
    JTextPane xmlText, jsonText;
    JButton convertir;
    XmlToJsonModel model;
    public void convertirFun(String xmlStr){
        if ( !xmlStr.startsWith("<")){
            JOptionPane.showMessageDialog(this , "balise de début introuvable" , "erreur", JOptionPane.ERROR_MESSAGE);
        }else{
            model =new XmlToJsonModel(xmlStr);
            String json = model.convertir();
            if (json.equals("-1")){
                JOptionPane.showMessageDialog(this , "La syntaxe XML n'est pas valide." , "erreur", JOptionPane.ERROR_MESSAGE);
            }else {
                jsonText.setText(json);
            }
        }
    }

    public XmlToJsonView() {
        xmlText = new JTextPane();
        jsonText = new JTextPane();
        convertir = new JButton("convertir");
        convertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String xmlStr = xmlText.getText();
                convertirFun(xmlStr);
            }
        });
        JScrollPane xmlScroll = new JScrollPane(xmlText);
        JScrollPane jsonScroll = new JScrollPane(jsonText);

        xmlScroll.setPreferredSize(new Dimension(300, 400));
        jsonScroll.setPreferredSize(new Dimension(300, 400));

        setTitle("Convertisseur XML en JSON");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon =  new ImageIcon("C:\\Users\\othman\\Downloads\\icon.png");
        setIconImage(icon.getImage());
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(xmlScroll);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(convertir);
        add(buttonPanel);

        add(jsonScroll);

        setVisible(true);
    }
}


