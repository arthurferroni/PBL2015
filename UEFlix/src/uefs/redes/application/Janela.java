/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uefs.redes.application;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import uefs.redes.model.MovieInformation;

/**
 *
 * @author Arthur
 */
public class Janela extends javax.swing.JFrame {

   // private JFrame frame = new JFrame();
    private JButton button = new JButton();
    private JButton historico = new JButton("Historico");
    private JButton sair = new JButton("Sair");
    private JButton search = new JButton("Search");

    private JTextField searchField = new JTextField();

    private JPanel gPanel = new JPanel();
    private JPanel gPanelCenter = new JPanel(new FlowLayout());
    private JScrollPane gPanelScroll = new JScrollPane();
    private JPanel gPanelNorth = new JPanel();
    private int h = 0;

    public Janela() {
        super("Primeira");

        Container gContainer = getContentPane();
        BorderLayout border = new BorderLayout();
        searchField.setMinimumSize(new Dimension(60, 200));
        searchField.setPreferredSize(new Dimension(200, 30));
        gPanelScroll.setPreferredSize(new Dimension(400, 258));
        searchField.setText("o");
        gPanelNorth.add(historico);
        gPanelNorth.add(sair);
        // esp
        JPanel esc = new JPanel();
        esc.setSize(new Dimension(30, 30));
        JPanel esc2 = new JPanel();
        esc2.setSize(new Dimension(30, 30));

        gPanelNorth.add(esc);
        gPanelNorth.add(esc2);

        gPanelNorth.add(searchField);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                System.out.print("aqui");

            }
        });
        gPanelNorth.add(search);

        gContainer.add(BorderLayout.NORTH, gPanelNorth);
        gContainer.add(BorderLayout.SOUTH, new JButton("2"));

        for (int i = 0; i < 210; i++) {
            h = i;
            JButton a1 = new JButton("-" + i);

            a1.addActionListener(new MyEvent(new MovieInformation("title" + i, "dsadas", 1, "asdada")));

            gPanelScroll.add(a1);
        }

        gPanelCenter.add(gPanelScroll);
        gContainer.add(BorderLayout.CENTER, gPanelCenter);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(new Dimension(662, 458));
        setVisible(true);
        setResizable(false);
        setPreferredSize(new Dimension(662, 458));
        //frame.getContentPane().add(button);
    }

    public static void main(String[] args) {
        new Janela();
    }
}

class MyEvent implements ActionListener {

    private MovieInformation mov;

    public MyEvent(MovieInformation xs) {
        mov = xs;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.print(e.getID() + mov.getName_file());

    }

}
