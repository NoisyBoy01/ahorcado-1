// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Ahorcado;

/************************************************************/
/**
 * 
 */
public class Palabra {
	private static final int NUM_LETRAS_ABECEDARIO = 27;
	/**
	 * 
	 */
	private String palabraOculta;
	/**
	 * son las letras que el jugador ha acertado
	 */
	private char[] letrasDescubiertas = new char[NUM_LETRAS_ABECEDARIO];
	/**
	 * son las letras que el jugador ha dicho pero no estaban en la palabra
	 */
	private char[] letrasFallidas = new char[NUM_LETRAS_ABECEDARIO];

	/**
	 * 
	 */
	public String elegirPalabra() {
		String[] palabras = { "Jirafa", "Perro", "Gato", "Gallo", "Elefante", "Rata", "Tortuga" };
		String elegida = palabras[(int) (Math.round(Math.random() * (palabras.length - 1)))];
		return elegida;
	}

	/**
	 * Comprueba si la letra ya ha sido usada.
	 */
	public boolean comprobarLetraUsada(char letra) {
		for (int i = 0; i < letrasDescubiertas.length; i++) {
			if (letra == letrasDescubiertas[i]) {
				return true;
			}
		}
		for (int i = 0; i < letrasFallidas.length; i++) {
			if (letra == letrasFallidas[i]) {
				return true;
			}

		}
		return false;
	}

	/**
	 * comprueba si letra está en la palabra oculta (no comprueba si la letra ha
	 * sido usada) y la almacena como acertada o fallida
	 * 
	 * @param letra
	 *            es la letra a comprobar si está en la palabra a adivinar
	 * @return estaba devuelve verdadero si la letra está al menos una vez en la
	 *         palabra y falso en caso contrario
	 */
	public boolean comprobarLetra(char letra) {

		if (palabraOculta.indexOf(letra) == -1) {
			insertarLetra(letra, letrasFallidas);
			return false;
		} else {
			insertarLetra(letra, letrasDescubiertas);
			return true;
		}
	}

	private void insertarLetra(char letra, char[] destino) {
		// inserta la letra en la primera posicion vacía
		for (int i = 0; i < destino.length; i++) {
			if (destino[i] == '\u0000') {
				destino[i] = letra;
				break;
			}
		}
	}

	/**
	 * mostramos el estado de la palabra, las letras acertadas y las letras
	 * fallidas
	 */
	public void mostrarResultados() {
	}

	/**
	 * comprueba si hemos acertado todas las letras
	 * 
	 * @return ganado
	 */
	public boolean comprobarSiGanado() {
		boolean estanTodas = true;
		char[] descompuesta = palabraOculta.toCharArray();
		
		for (int i = 0; i < descompuesta.length; i++) {
			boolean estaEnDescubiertas = false;
			for (int j = 0; j < letrasDescubiertas.length; j++) {
				if (descompuesta[i] == letrasDescubiertas[j]) {
					estaEnDescubiertas = true;
					break;
				}
			}
			if (!estaEnDescubiertas) {
				estanTodas = false;
				break;
			}
		}
		
		return estanTodas;
	}

	/**
	 * comprueba si la palabra propuesta por el jugador coincide con la palabra
	 * oculta (quiero resolver)
	 * 
	 * @param palabra
	 * @return adivinada adivinada es verdadero si la palabra coincide con la
	 *         que buscábamos
	 */
	public boolean comprobarPalabra(String palabra) {
		return palabraOculta.equals(palabra);
	}
};
