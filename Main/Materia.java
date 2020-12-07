import java.util.ArrayList;
import java.util.List;

public class Materia {
	String nombre; // Nombre de la Materia
	int creditos, semestre; // Creditos y semestre al que pertenece la Materia
	List<Materia> requisitos = new ArrayList<Materia>(); // Lista de Pre-Requisitos de la Materia
	boolean aprovada; // Materia aprovada true o false

	
	public boolean Ver(){
		boolean puede = true;
		for (Materia i: this.requisitos) {
			if (i.aprovada == false) {
				puede = false;
			}
		}
		return (puede && !aprovada);
	}
	public Materia (String nombre, int creditos,int semestre, List<Materia> requisitos) {
		this.nombre = nombre;
		this.creditos = creditos;
		this.semestre = semestre;
		this.requisitos = new ArrayList<Materia>(requisitos);
		this.aprovada = false;
	}
}