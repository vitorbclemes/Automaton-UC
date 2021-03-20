package frontEnd;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import data.*;
import system.Controller;

public class Main {
	
	public static Controller controller = new Controller();
	private static Scanner s = new Scanner(System.in);
	private static Random r = new Random();
	
	//Declarando testes
	static Student s1; 
	static Student s2;
	static Student s3;
	static Student s4;
	static Student s5;
	
	static Subject sb1;
	static Subject sb2;
	static Subject sb3;
	static Subject sb4;
	static Subject sb5;
	static Subject sb6;
	static Subject sb7;
	
	static Node n1;
	static Node n2;
	static Node n3;
	static Node n4;
	static Node n5;
	
	static ArrayList<Subject> sl1;
	static ArrayList<Subject> sle1;
	static ArrayList<Subject> sle2;
	static ArrayList<Subject> sle3;
	static ArrayList<Student> std;
	static ArrayList<Node> nodes;
	
	
	
	public static void main(String args[]) {
		//Instanciando testes
		
		//Alunos
		s1 = new Student(1,1,"Joao",r.nextInt(),new ArrayList<Subject>());
		s2 = new Student(2,2,"Pedro",r.nextInt(),new ArrayList<Subject>());
		s3 = new Student(3,3,"Paulo",r.nextInt(),new ArrayList<Subject>());
		s4 = new Student(4,4,"Ana",r.nextInt(),new ArrayList<Subject>());
		s5 = new Student(5,5,"Maria",r.nextInt(),new ArrayList<Subject>());
		
		//Assuntos
		sb1 = new Subject(1,"Numeros",true);
		sb2 = new Subject(2,"Soma e diferenca",true);
		sb3 = new Subject(3,"Multiplicacao",true);
		sb4 = new Subject(4,"Divisao",true);
		sb5 = new Subject(5,"Portenciacao",true);
		sb6 = new Subject(6,"Aprofundamento em Divisao:Fracoes",false);
		sb7 = new Subject(7,"Aprofundamento em Potenciacao : P.Negativas",false);
		
		//Lista de Assuntos
		sl1 = new ArrayList<Subject>(); // todo os assuntos
		sl1.add(sb1);
		sl1.add(sb2);
		sl1.add(sb3);
		sl1.add(sb4);
		sl1.add(sb5);

		
		sle1 = new ArrayList<Subject>(); // requerido para nivel 2
		sle1.add(sb1);
		sle1.add(sb2);
		
		sle2 = new ArrayList<Subject>();
		sle2.add(sb3);
		sle2.add(sb4);  // requerido para nivel 3
		
		sle3 = new ArrayList<Subject>(); // Opicionais para nivel 2
		sl1.forEach(value->{
			sle3.add(value);
		});
		sle3.add(sb6);
		sle3.add(sb7);
		
		
		// Lista de alunos
		std = new ArrayList<Student>();
		std.add(s1);
		std.add(s2);
		std.add(s3);
		std.add(s4);
		std.add(s5);
		controller.setStudents(std);

		
		n1 = new Node(0,null,sl1);
		n2 = new Node(1,sb1,sl1);
		n3 = new Node(2,sb2,sl1);
		n4 = new Node(3,sb3,sl1);
		n5 = new Node(4,sb4,sl1);
		
		nodes = new ArrayList<Node>();
		nodes.add(n1);
		nodes.add(n2);
		nodes.add(n3);
		nodes.add(n4);
		nodes.add(n5);
		controller.setNodes(nodes);
		
		s1.setNivel(n1);
		s2.setNivel(n1);
		s3.setNivel(n1);
		s4.setNivel(n1);
		s5.setNivel(n1);
	
		int option = -1;
		while(option!= 0) {
			
			renderInitialScreen();
		
			option = s.nextInt();	
			switch(option) {
				case 0:
					break;
				case 1:
					System.out.println("Digite o id do Aluno e sua senha.");
					int id = s.nextInt();
					int password = s.nextInt();
					
					while(controller.handleLoggin(id, password)!= null) {
						renderLoggedScreen();
						int op = -1;
						op = s.nextInt();
						if(op == 0)
								break;
						if(op == 1)
								handleLoggedFunctions(1,id);
						if(op == 2)
								handleLoggedFunctions(2,id);
						if(op == 3)
								handleLoggedFunctions(3,id);
						if(op == 4)
								handleLoggedFunctions(4,id);
						}
					break;		
				case 2:
					int op = -1;
					while(op!=0) {
						renderUnlloggedScreen();
						op = s.nextInt();
						if(op == 0 ) {
							break;
						}
						else if(op == 1)
								handleUnlloggedFunctions(1);
						else if(op == 2)
								handleUnlloggedFunctions(2);
						else if(op == 3)
								handleUnlloggedFunctions(3);
					}
					break;
			}	
		}
	}
	
	public static void renderInitialScreen() {
		System.out.println("Bem vindo ao sistema de estudo!");
		System.out.println("Para acesso individual do aluno,digite 1.");
		System.out.println("Para acessar informacoes gerais,digite 2.");
		System.out.println("Para desligar o sistema, digite 0.");
	}
	
	public static void renderLoggedScreen() {
		System.out.println("01 - Trazer informações do aluno.");
		System.out.println("02 - Exibir assuntos ja estudados");
		System.out.println("03 - Exibir assuntos disponiveis.");
		System.out.println("04 - Estudar assunto.");
		System.out.println("00 - Fazer logout.");
	}
	
	public static void renderUnlloggedScreen() {
		System.out.println("01 - Exibir nomes de todos os alunos.");
		System.out.println("02- Exibir assuntos disponíveis.");
		System.out.println("03- Exibir assuntos requeridas para níveis");
		System.out.println("00 - Retornar para tela inicial.");
	}
	
	public static void handleLoggedFunctions(int operation,int studentId){
		if(operation == 1) {
			System.out.println(controller.getStudent(studentId).toString());
			System.out.println();
		}
		if(operation == 2) {
			System.out.println("Assuntos estudados : ");
			controller.getStudent(studentId).getSubjectsDone().forEach(subject->{
				System.out.println(subject.getLabel());
			});
			System.out.println();
		}
		if(operation == 3) {
			System.out.println("Assuntos Disponiveis : ");
			controller.getStudent(studentId).getNivel().getSubjectsAvailable().forEach(subject->{
				System.out.println(subject.toString());
			});
			System.out.println();
		}
		if(operation == 4) {
			
			System.out.println("Escolha o id do Assunto : ");
			int subjectId = s.nextInt();
			
			if(controller.tryNewStudy(studentId, subjectId)) {
				if(controller.tryUpgradeStudentNode(studentId,subjectId)) {
					System.out.println("O aluno mudou de nivel.");
				}
			}else {
				System.out.println("Nao foi possivel encontrar o Assunto");
			}
		}
	}
	
	public static void handleUnlloggedFunctions(int operation) {
		if(operation == 1) {
			System.out.println("Estudantes cadastrados:");
			controller.getAllStudents().forEach(student->{
				System.out.println(student.getName());
			});
			System.out.println();
		}
		
		else if(operation == 2) {
			System.out.println("\n - Assuntos Disponiveis - ");
			controller.getAllNodes().get(0).getSubjectsAvailable().forEach(subj->{
				System.out.println(subj.getLabel());
			});
			System.out.println();
		}
		
		else if(operation == 3) {
			System.out.println("\n - Nivel 0 - ");
			System.out.println();
			
			for (int i = 1; i<controller.getAllNodes().size();i++) {
				System.out.println("\n - Nivel " +controller.getAllNodes().get(i).getId() + " -");
				System.out.println(controller.getAllNodes().get(i).getSubjectsRequired().getLabel());
			}
			System.out.println();
		}
	}
}
