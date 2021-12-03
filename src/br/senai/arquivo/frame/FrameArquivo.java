package br.senai.arquivo.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.arquivo.Arquivo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;

public class FrameArquivo extends JFrame {

	private JPanel contentPane;

	public FrameArquivo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 322);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblManipular = new JLabel("Manipula\u00E7\u00E3o de arquivo");
		lblManipular.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblManipular.setBounds(117, 11, 213, 32);
		contentPane.add(lblManipular);

		JLabel lblTexto = new JLabel("Texto");
		lblTexto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTexto.setBounds(10, 54, 46, 14);
		contentPane.add(lblTexto);

		JTextPane txtPaneTexto = new JTextPane();
		txtPaneTexto.setBounds(20, 75, 173, 155);
		contentPane.add(txtPaneTexto);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(203, 176, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.setBounds(203, 142, 89, 23);
		contentPane.add(btnGravar);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(203, 207, 89, 23);
		contentPane.add(btnSair);

		JLabel lblTextos = new JLabel("Textos Gravados");
		lblTextos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTextos.setBounds(309, 54, 173, 14);
		contentPane.add(lblTextos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(319, 75, 173, 155);
		contentPane.add(scrollPane);

		JTextPane txtPaneConteudo = new JTextPane();
		scrollPane.setViewportView(txtPaneConteudo);

		Arquivo objetoArquivo = new Arquivo();
		String caminho = "C:\\Users\\21276321.CFP127ALUNO\\Desktop\\teste\\aula.txt";

		btnGravar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String texto = objetoArquivo.ler(caminho) + txtPaneTexto.getText();

				objetoArquivo.escrever(caminho, texto);

				txtPaneConteudo.setText(objetoArquivo.ler(caminho));
				
				if(objetoArquivo.escrever(caminho, texto)) {
					JOptionPane.showMessageDialog(null, "Dado gravado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Falha ao gravar texto", "Falha", JOptionPane.ERROR_MESSAGE); 					
				}
			}
		});

		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtPaneTexto.setText("");
				txtPaneConteudo.setText("");

			}
		});

		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

	}
}
