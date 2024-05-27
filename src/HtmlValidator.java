import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack<HtmlTag> pilaHTML = new Stack<>();

		for (HtmlTag etiqueta : tags) {
			if (etiqueta.isOpenTag()) {// Si es una etiqueta de apertura, agrégala a la pila.
				pilaHTML.push(etiqueta);

			} else if (!etiqueta.isSelfClosing()) {// Si es una etiqueta de cierre y no es auto-cierre.

				if (pilaHTML.isEmpty()) {// Si la pila está vacía, la etiqueta de cierre no tiene una apertura correspondiente.
					return null;
				}
				else if (!pilaHTML.peek().matches(etiqueta)) {// Si la etiqueta de la parte superior de la pila no coincide con la etiqueta de cierre.
					return pilaHTML;
				} else {
					pilaHTML.pop();// Si coincide, quita la etiqueta de apertura de la pila.
				}
			}
		}

.......
		return pilaHTML;

	}
}
