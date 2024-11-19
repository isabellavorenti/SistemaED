package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CursoController;
import controller.DisciplinaController;
import java.awt.SystemColor;

public class Tela extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCursoId;
	private JTextField tfCursoNome;
	private JTextField tfCursoArea;
	private JTextField tfDisciplinaCod;
	private JTextField tfDisciplinaNome;
	private JTextField tfDisciplinaHoras;
	private JTextField tfDisciplinaCodCurso;
	private JTextField tfProfessorCPF;
	private JTextField tfProfessorNome;
	private JTextField tfProfessorArea;
	private JTextField tfProfessorPontos;
	private JTextField tfInscricaoCPF;
	private JTextField tfInscricaoCodDisciplina;
	private JTextField tfInscricaoCodProcesso;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() {
		setTitle("Gestão de Processos Seletivos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 604, 420);
		contentPane.add(tabbedPane);
		
		JPanel tabCurso = new JPanel();
		tabCurso.setBackground(new Color(255, 255, 153));
		tabbedPane.addTab("Curso", null, tabCurso, "Cadastro de cursos");
		tabCurso.setLayout(null);
		
		JLabel lblCursoId = new JLabel("Código:");
		lblCursoId.setBounds(10, 56, 59, 24);
		lblCursoId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabCurso.add(lblCursoId);
		
		JLabel lblCursoNome = new JLabel("Nome:");
		lblCursoNome.setBounds(10, 87, 59, 24);
		lblCursoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabCurso.add(lblCursoNome);
		
		JLabel lblCursoArea = new JLabel("Área do conhecimento:");
		lblCursoArea.setBounds(10, 116, 146, 31);
		lblCursoArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabCurso.add(lblCursoArea);
		
		tfCursoId = new JTextField();
		tfCursoId.setBounds(71, 58, 166, 20);
		tfCursoId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabCurso.add(tfCursoId);
		tfCursoId.setColumns(10);
		
		tfCursoNome = new JTextField();
		tfCursoNome.setBounds(71, 89, 298, 20);
		tfCursoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabCurso.add(tfCursoNome);
		tfCursoNome.setColumns(10);
		
		tfCursoArea = new JTextField();
		tfCursoArea.setBounds(166, 121, 203, 20);
		tfCursoArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabCurso.add(tfCursoArea);
		tfCursoArea.setColumns(10);
		
		JButton btnCursoCadastrar = new JButton("Cadastrar");
		btnCursoCadastrar.setBounds(395, 158, 95, 24);
		tabCurso.add(btnCursoCadastrar);
		
		JScrollPane scrollPaneCurso = new JScrollPane();
		scrollPaneCurso.setBounds(10, 193, 579, 188);
		tabCurso.add(scrollPaneCurso);
		
		JTextArea taCurso = new JTextArea();
		scrollPaneCurso.setViewportView(taCurso);
		
		JScrollBar scrollBarCurso = new JScrollBar();
		scrollPaneCurso.setRowHeaderView(scrollBarCurso);
		
		JButton btnCursoBuscar = new JButton("Buscar");
		btnCursoBuscar.setForeground(new Color(0, 0, 0));
		btnCursoBuscar.setBounds(262, 56, 95, 24);
		tabCurso.add(btnCursoBuscar);
		
		JLabel lblCursoTitulo = new JLabel("Cadastro de curso");
		lblCursoTitulo.setBackground(new Color(255, 255, 255));
		lblCursoTitulo.setForeground(new Color(0, 0, 0));
		lblCursoTitulo.setBounds(223, 11, 153, 24);
		lblCursoTitulo.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 18));
		tabCurso.add(lblCursoTitulo);
		
		JButton btnCursoDeletar = new JButton("Excluir");
		btnCursoDeletar.setBounds(500, 159, 89, 23);
		btnCursoDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tabCurso.add(btnCursoDeletar);
		
		JPanel tabDisciplina = new JPanel();
		tabDisciplina.setBackground(new Color(255, 255, 153));
		tabbedPane.addTab("Disciplina", null, tabDisciplina, "Cadastro de disciplinas");
		tabDisciplina.setLayout(null);
		
		JLabel lblDisciplinaId = new JLabel("Código:");
		lblDisciplinaId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaId.setBounds(10, 60, 59, 24);
		tabDisciplina.add(lblDisciplinaId);
		
		JLabel lblDisciplinaNome = new JLabel("Nome:");
		lblDisciplinaNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaNome.setBounds(10, 95, 59, 24);
		tabDisciplina.add(lblDisciplinaNome);
		
		JLabel lblDisciplinaDia = new JLabel("Dia:");
		lblDisciplinaDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaDia.setBounds(311, 96, 61, 23);
		tabDisciplina.add(lblDisciplinaDia);
		
		JLabel lblDisciplinaQtdeHoras = new JLabel("Horas ministradas:");
		lblDisciplinaQtdeHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaQtdeHoras.setBounds(10, 127, 121, 23);
		tabDisciplina.add(lblDisciplinaQtdeHoras);
		
		JLabel lblDisciplinaCodCurso = new JLabel("Código do curso:");
		lblDisciplinaCodCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisciplinaCodCurso.setBounds(311, 126, 111, 24);
		tabDisciplina.add(lblDisciplinaCodCurso);
		
		tfDisciplinaCod = new JTextField();
		tfDisciplinaCod.setBounds(67, 64, 214, 20);
		tabDisciplina.add(tfDisciplinaCod);
		tfDisciplinaCod.setColumns(10);
		
		tfDisciplinaNome = new JTextField();
		tfDisciplinaNome.setBounds(67, 96, 214, 20);
		tabDisciplina.add(tfDisciplinaNome);
		tfDisciplinaNome.setColumns(10);
		
		tfDisciplinaHoras = new JTextField();
		tfDisciplinaHoras.setBounds(132, 130, 86, 20);
		tabDisciplina.add(tfDisciplinaHoras);
		tfDisciplinaHoras.setColumns(10);
		
		tfDisciplinaCodCurso = new JTextField();
		tfDisciplinaCodCurso.setBounds(432, 130, 86, 20);
		tabDisciplina.add(tfDisciplinaCodCurso);
		tfDisciplinaCodCurso.setColumns(10);
		
		JComboBox boxDisciplinaDiasSemana = new JComboBox();
		boxDisciplinaDiasSemana.setModel(new DefaultComboBoxModel(new String[] {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"}));
		boxDisciplinaDiasSemana.setBounds(350, 98, 168, 22);
		tabDisciplina.add(boxDisciplinaDiasSemana);
		
		JButton btnDisciplinaCadastrar = new JButton("Cadastrar");
		btnDisciplinaCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDisciplinaCadastrar.setBounds(393, 176, 95, 23);
		tabDisciplina.add(btnDisciplinaCadastrar);
		
		JButton btnDisciplinaBuscar = new JButton("Buscar");
		btnDisciplinaBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDisciplinaBuscar.setBounds(311, 63, 89, 23);
		tabDisciplina.add(btnDisciplinaBuscar);
		
		JLabel lblDisciplinaTitulo = new JLabel("Cadastro de disciplina");
		lblDisciplinaTitulo.setForeground(new Color(0, 0, 0));
		lblDisciplinaTitulo.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 18));
		lblDisciplinaTitulo.setBounds(208, 11, 182, 24);
		tabDisciplina.add(lblDisciplinaTitulo);
		
		JButton btnDisciplinaExcluir = new JButton("Excluir");
		btnDisciplinaExcluir.setBounds(498, 176, 89, 23);
		tabDisciplina.add(btnDisciplinaExcluir);
		
		JButton btnDisciplinaAtualizar = new JButton("Atualizar");
		btnDisciplinaAtualizar.setBounds(294, 176, 89, 23);
		tabDisciplina.add(btnDisciplinaAtualizar);
		
		JTextArea taDisciplina = new JTextArea();
		taDisciplina.setBounds(27, 210, 560, 171);
		tabDisciplina.add(taDisciplina);
		
		JScrollBar scrollBarCurso_1 = new JScrollBar();
		scrollBarCurso_1.setBounds(10, 210, 17, 171);
		tabDisciplina.add(scrollBarCurso_1);
		
		JPanel tabProfessor = new JPanel();
		tabProfessor.setBackground(new Color(255, 255, 153));
		tabbedPane.addTab("Professor", null, tabProfessor, "Cadastro de professores");
		tabProfessor.setLayout(null);
		
		JLabel lblProfessorCpf = new JLabel("CPF:");
		lblProfessorCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorCpf.setBounds(285, 101, 36, 14);
		tabProfessor.add(lblProfessorCpf);
		
		JLabel lblProfessorNome = new JLabel("Nome:");
		lblProfessorNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorNome.setBounds(10, 70, 46, 14);
		tabProfessor.add(lblProfessorNome);
		
		JLabel lblProfessorArea = new JLabel("Área de Inscrição:");
		lblProfessorArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorArea.setBounds(10, 97, 117, 22);
		tabProfessor.add(lblProfessorArea);
		
		JLabel lblProfessorPontos = new JLabel("Pontuação:");
		lblProfessorPontos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorPontos.setBounds(10, 130, 81, 22);
		tabProfessor.add(lblProfessorPontos);
		
		tfProfessorCPF = new JTextField();
		tfProfessorCPF.setBounds(325, 100, 158, 20);
		tabProfessor.add(tfProfessorCPF);
		tfProfessorCPF.setColumns(10);
		
		tfProfessorNome = new JTextField();
		tfProfessorNome.setBounds(66, 69, 523, 20);
		tabProfessor.add(tfProfessorNome);
		tfProfessorNome.setColumns(10);
		
		tfProfessorArea = new JTextField();
		tfProfessorArea.setBounds(134, 100, 140, 20);
		tabProfessor.add(tfProfessorArea);
		tfProfessorArea.setColumns(10);
		
		tfProfessorPontos = new JTextField();
		tfProfessorPontos.setBounds(95, 133, 179, 20);
		tabProfessor.add(tfProfessorPontos);
		tfProfessorPontos.setColumns(10);
		
		JButton btnProfessorCadastrar = new JButton("Cadastrar");
		btnProfessorCadastrar.setBounds(378, 174, 105, 23);
		tabProfessor.add(btnProfessorCadastrar);
		
		JButton btnProfessorBuscar = new JButton("Buscar");
		btnProfessorBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProfessorBuscar.setBounds(500, 99, 89, 23);
		tabProfessor.add(btnProfessorBuscar);
		
		JLabel lblDisciplinaTitulo_1 = new JLabel("Cadastro de professor");
		lblDisciplinaTitulo_1.setForeground(new Color(0, 0, 0));
		lblDisciplinaTitulo_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 18));
		lblDisciplinaTitulo_1.setBounds(208, 11, 183, 24);
		tabProfessor.add(lblDisciplinaTitulo_1);
		
		JButton btnProfessorExcluir = new JButton("Excluir");
		btnProfessorExcluir.setBounds(500, 174, 89, 23);
		tabProfessor.add(btnProfessorExcluir);
		
		JButton btnProfessorAtualizar = new JButton("Atualizar");
		btnProfessorAtualizar.setBounds(270, 174, 89, 23);
		tabProfessor.add(btnProfessorAtualizar);
		
		JTextArea taProfessor = new JTextArea();
		taProfessor.setBounds(29, 208, 560, 173);
		tabProfessor.add(taProfessor);
		
		JScrollBar scrollBarCurso_2 = new JScrollBar();
		scrollBarCurso_2.setBounds(12, 208, 17, 173);
		tabProfessor.add(scrollBarCurso_2);
		
		JPanel tabInscricao = new JPanel();
		tabInscricao.setBackground(new Color(255, 255, 153));
		tabbedPane.addTab("Inscrição", null, tabInscricao, "Inscrição de docentes");
		tabInscricao.setLayout(null);
		
		JLabel lblInscricao = new JLabel("Inscrição de docentes");
		lblInscricao.setBackground(new Color(0, 0, 0));
		lblInscricao.setForeground(new Color(0, 0, 0));
		lblInscricao.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 18));
		lblInscricao.setBounds(208, 11, 182, 24);
		tabInscricao.add(lblInscricao);
		
		JLabel lblInscricaoCPF = new JLabel("CPF do docente:");
		lblInscricaoCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInscricaoCPF.setBounds(10, 63, 109, 24);
		tabInscricao.add(lblInscricaoCPF);
		
		JLabel lblCdigoDaDisciplina = new JLabel("Código da disciplina:");
		lblCdigoDaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigoDaDisciplina.setBounds(10, 94, 133, 32);
		tabInscricao.add(lblCdigoDaDisciplina);
		
		JLabel lblCdigoDoProcesso = new JLabel("Código do processo:");
		lblCdigoDoProcesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigoDoProcesso.setBounds(10, 127, 133, 32);
		tabInscricao.add(lblCdigoDoProcesso);
		
		tfInscricaoCPF = new JTextField();
		tfInscricaoCPF.setBounds(129, 67, 157, 20);
		tabInscricao.add(tfInscricaoCPF);
		tfInscricaoCPF.setColumns(10);
		
		tfInscricaoCodDisciplina = new JTextField();
		tfInscricaoCodDisciplina.setBounds(153, 102, 133, 20);
		tabInscricao.add(tfInscricaoCodDisciplina);
		tfInscricaoCodDisciplina.setColumns(10);
		
		tfInscricaoCodProcesso = new JTextField();
		tfInscricaoCodProcesso.setBounds(153, 135, 133, 20);
		tabInscricao.add(tfInscricaoCodProcesso);
		tfInscricaoCodProcesso.setColumns(10);
		
		JButton btnInscricaoCadastrar = new JButton("Cadastrar");
		btnInscricaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInscricaoCadastrar.setForeground(new Color(0, 0, 0));
		btnInscricaoCadastrar.setBackground(new Color(255, 255, 255));
		btnInscricaoCadastrar.setBounds(393, 174, 96, 23);
		tabInscricao.add(btnInscricaoCadastrar);
		
		JButton btnInscricaoBuscar = new JButton("Buscar");
		btnInscricaoBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInscricaoBuscar.setBounds(309, 66, 89, 23);
		tabInscricao.add(btnInscricaoBuscar);
		
		JButton btnInscricaoExcluir = new JButton("Excluir");
		btnInscricaoExcluir.setBounds(500, 174, 89, 23);
		tabInscricao.add(btnInscricaoExcluir);
		
		JButton btnInscricaoAtualizar = new JButton("Atualizar");
		btnInscricaoAtualizar.setBounds(294, 174, 89, 23);
		tabInscricao.add(btnInscricaoAtualizar);
		
		JTextArea taInscricao = new JTextArea();
		taInscricao.setBounds(27, 208, 560, 173);
		tabInscricao.add(taInscricao);
		
		JScrollBar scrollBarCurso_2_1 = new JScrollBar();
		scrollBarCurso_2_1.setBounds(10, 208, 17, 173);
		tabInscricao.add(scrollBarCurso_2_1);
		
		CursoController cCont = new CursoController(tfCursoId, tfCursoNome, tfCursoArea, taCurso);
		
		JButton btnCursoAtualizar = new JButton("Atualizar");
		btnCursoAtualizar.setBounds(290, 158, 95, 24);
		tabCurso.add(btnCursoAtualizar);
		DisciplinaController dCont = new DisciplinaController(tfDisciplinaCod, tfDisciplinaNome, tfDisciplinaHoras, boxDisciplinaDiasSemana, tfDisciplinaCodCurso, taDisciplina);
		
		btnCursoCadastrar.addActionListener(cCont);
		btnCursoBuscar.addActionListener(cCont);
		btnDisciplinaCadastrar.addActionListener(dCont);
		btnDisciplinaBuscar.addActionListener(dCont);
	}
}
