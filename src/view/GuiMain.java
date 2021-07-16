package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ProdutoDao;
import model.Produto;
import viewController.TableProdutoModel;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class GuiMain extends JFrame {

	private JPanel contentPane;
	private JTable tableListaProduto;
	private TableProdutoModel produtoModel = new TableProdutoModel();
	private ProdutoDao daoProduto = new ProdutoDao();
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain frame = new GuiMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiMain() {
		setTitle("C\u00E1lculo de Impostos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 414, 154);
		contentPane.add(scrollPane);
		
		tableListaProduto = new JTable();
		tableListaProduto.setModel(produtoModel);
		daoProduto.getAll();
		scrollPane.setViewportView(tableListaProduto);
		
		JLabel lblListaProduto = new JLabel("Lista de produtos");
		lblListaProduto.setBounds(10, 37, 414, 14);
		contentPane.add(lblListaProduto);
		
		lblNewLabel = new JLabel("Impostos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 0, 414, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Produto produtoSelecionado = produtoModel.getProduto(tableListaProduto.getSelectedRow());
				Double imposto = produtoSelecionado.calcularImpostos();
				JOptionPane.showMessageDialog(btnCalcular, "Imposto a pagar é de R$ " + imposto, "Mensagem", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCalcular.setBounds(166, 227, 104, 23);
		contentPane.add(btnCalcular);
	}
}
