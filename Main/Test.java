import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test {
	static List<Materia> materias = new ArrayList<Materia>();
	static List<Materia> req = new ArrayList<Materia>();
	static int semestreActual;

	// Anadir prerequisitos a la materia
	public static void addReq(int num) {
		req.add(materias.get(num));
	}

	// Anadir Materia nueva
	public static void newMateria(String nombre, int creditos, int semestre) {
		materias.add(new Materia(nombre, creditos, semestre, req));
		req.clear();
	}

	// Malla de Ingenieria de Sistemas (Declaracion en Codigo)
	public static void create() {
		newMateria("Matematicas Basicas", 4, 0); // 0 Matebasicas..

		addReq(0);
		newMateria("Calculo Diferencial", 4, 1); // 1 Diferencial..
		newMateria("Introduccion a la ingenieria de sistemas y computacion", 3, 1); // 2 Introduccion..
		newMateria("Programacion de computadores", 3, 1); // 3 Estructurada..

		addReq(1);
		newMateria("Fundamentos de Mecanica", 4, 2); // 4 FisicaI..
		addReq(1);
		newMateria("Calculo Integral", 4, 2); // 5 Integral..
		addReq(1);
		newMateria("Algebra Lineal", 4, 2); // 6 Lineal..
		addReq(3);
		newMateria("Programacion Orientada a Objetos", 4, 2); // 7 Objetos..

		addReq(5);
		newMateria("Probabilidad y estadistica", 3, 3); // 8 Probabilidad..
		addReq(5);
		addReq(6);
		newMateria("Calculo en varias variables", 4, 3); // 9 Multi..
		addReq(6);
		newMateria("Matematicas discretas I", 4, 3); // 10 DiscretasI..
		addReq(7);
		newMateria("Bases de Datos", 3, 3); // 11 Bases..
		addReq(2);
		newMateria("Elementos de Computadores", 3, 3); // 12 Elementos..

		addReq(4);
		addReq(5);
		newMateria("Fundamentos de electricidad y magnetismo", 4, 4); // 13 FisicaII..
		addReq(9);
		newMateria("Ingenieria economica", 3, 4); // 14 Ingeco..
		addReq(10);
		newMateria("Matematicas Discretas II", 4, 4); // 15 DiscretasII..
		addReq(7);
		newMateria("Estructuras de Datos", 3, 4); // 16 Estructuras..
		addReq(12);
		newMateria("Arquitectura de Computadores", 3, 4); // 17 Arquitectura..

		addReq(7);
		addReq(8);
		addReq(9);
		addReq(15);
		newMateria("Modelos y simulacion", 3, 5); // 18 Simulacion..
		addReq(14);
		newMateria("Gerencia y gestion de proyectos", 3, 5); // 19 Proyectos..
		addReq(13);
		addReq(16);
		addReq(17);
		newMateria("Redes y computadores", 3, 5); // 20 Redes..
		addReq(11);
		addReq(16);
		newMateria("Ingenieria de Software I", 3, 5); // 21 IngesoftI..
		addReq(10);
		addReq(17);
		newMateria("Introduccion a la teoria de la computacion", 4, 5); // 22 TeoriaCompu..

		addReq(18);
		newMateria("Optimizacion", 3, 6); // 23 Optimizacion..
		addReq(9);
		addReq(15);
		newMateria("Metodos Numericos", 3, 6); // 24 Metodos..
		addReq(7);
		addReq(19);
		newMateria("Sistemas de informacion", 3, 6); // 25 Informacion..
		addReq(20);
		addReq(21);
		newMateria("Ingenieria de Software II", 3, 6); // 26 IngesoftII..
		addReq(8);
		addReq(15);
		addReq(16);
		newMateria("Algoritmos", 3, 6); // 27 Algoritmos..
		addReq(17);
		newMateria("Sistemas Operativos", 3, 6); // 28 Operativos..

		addReq(23);
		newMateria("Modelos estocasticos y simulacion en computacion y comunicaciones", 3, 7); // 29 Modelos..
		addReq(9);
		addReq(15);
		newMateria("Teoria de la Informacion y Sistemas de Comunicaciones", 3, 7); // 30 TeoriaInfo..
		addReq(18);
		addReq(25);
		newMateria("Pensamiento Sistematico", 3, 7); // 31 Pensamiento..
		addReq(26);
		newMateria("Arquitectura de Software", 3, 7); // 32 ArquiSoft..
		addReq(16);
		addReq(22);
		newMateria("Lenguages de Programacion", 3, 7); // 33 Lenguages..
		addReq(27);
		newMateria("Introduccion a los sistemas intelingentes", 3, 7); // 34 Inteligentes..

		addReq(20);
		addReq(27);
		addReq(28);
		newMateria("Computacion Paralela y Distribuida", 3, 8); // 35 CompuPara..
		addReq(27);
		addReq(30);
		newMateria("Computacion Visual", 3, 8); // 36 CompuVisu..
		addReq(25);
		addReq(28);
		addReq(32);
		newMateria("Arquitectura de Infraestructura y Gobierno de TICs", 3, 8); // 37 ArquiInfra..
		addReq(8);
		addReq(20);
		addReq(27);
		newMateria("Criptografia y Seguridad de la Informacion", 3, 8); // 38 Criptografia..
	}

	public static void malla() {
		List<Materia> tmp = new ArrayList<Materia>(); // Lista de Materias por semestre
		int creditosT = 0;
		for (; semestreActual <= 15; semestreActual++) {
			System.out.println("Semestre " + semestreActual + ": ");
			for (Materia i : materias) {
				if (i.Ver()) { // Verifica las materias que se pueden ver en el semestre
					System.out.println("----------" + i.nombre);
					tmp.add(i); // Las anade a la lista de materias por semestre
					creditosT += i.creditos; // Tiene la suma de creditos total
				}
			}
			System.out.println("---------------------------------------------------------creditos total: " + creditosT);
			creditosT = 0; // resetea los creditos para el siguiente semestre
			for (Materia j : tmp) {
				j.aprovada = true; // aprueva todas las materias del semestre actual para poder anadir las del
									// siguiente semestre
			}
			tmp.clear(); // resetea la lista de materias por semestre
		}
	}

	public static void main(String[] args) throws IOException {
		create();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Semestre actual: ");
		semestreActual = Integer.parseInt(br.readLine()) + 1;

		System.out.println("Materias aprovadas: ");
		String[] tokens = br.readLine().split(" ");

		for (int i = 0; i < tokens.length; i++) {
			materias.get(Integer.parseInt(tokens[i])).aprovada = true;
		}

		malla();
	}
}

// Numero de las Materias para la Malla de Ingenieria de sistemas
// 0 Matebasicas..
// 1 Diferencial..
// 2 Introduccion..
// 3 Estructurada..
// 4 FisicaI..
// 5 Integral..
// 6 Lineal..
// 7 Objetos..
// 8 Probabilidad..
// 9 Multi..
// 10 DiscretasI..
// 11 Bases..
// 12 Elementos..
// 13 FisicaII..
// 14 Ingeco..
// 15 DiscretasII..
// 16 Estructuras..
// 17 Arquitectura..
// 18 Simulacion..
// 19 Proyectos..
// 20 Redes..
// 21 IngesoftI..
// 22 TeoriaCompu..
// 23 Optimizacion..
// 24 Metodos..
// 25 Informacion..
// 26 IngesoftII..
// 27 Algoritmos..
// 28 Operativos..
// 29 Modelos..
// 30 TeoriaInfo..
// 31 Pensamiento..
// 32 ArquiSoft..
// 33 Lenguages..
// 34 Inteligentes..
// 35 CompuPara..
// 36 CompuVisu..
// 37 ArquiInfra..
// 38 Criptografia..

// 0 1 2 3 4 5 6 7 8 9 10 11 12 16 17 21 22 28