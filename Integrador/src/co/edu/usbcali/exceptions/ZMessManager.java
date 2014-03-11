package co.edu.usbcali.exceptions;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura/
 * 
 */
public class ZMessManager extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public final static String ALL = "Todo ";
	public final static String ENTCHILD = "tablas relacionadas (hijos)";
	public final static String FOREIGNDATA = "datos de clases externas: ";
	public static String ENTITY_SUCCESFULLYSAVED = "Entidad guardo exitosamente";
	public static String ENTITY_SUCCESFULLYDELETED = "Entidad borro exitosamente";
	public static String ENTITY_SUCCESFULLYMODIFIED = "Entidad modificada exitosamente";
	public static String ENTITY_WITHSAMEKEY = "Otra Entidad con la misma llave se encontro ";
	public static String ENTITY_NOENTITYTOUPDATE = "Ninguna entidad encontrada, con el tipo de llave ";

	public ZMessManager() {
	}

	public ZMessManager(String exception) {
		super(exception);
	}

	public class NotValidFieldException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public NotValidFieldException(String info) {
			super("El valor para el campo: \"" + info + "\" no es valido");
		}
	}

	public class NullEntityExcepcion extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public NullEntityExcepcion(String info) {
			super("El" + info + " Entidad no puede ser nulo o vacio");
		}
	}

	public class EmptyFieldException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public EmptyFieldException(String info) {
			super("El valor para el campo: \"" + info
					+ "\" no puede ser nulo o vacio");
		}
	}

	public class NotValidFormatException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public NotValidFormatException(String info) {
			super("El fotmato o el tamaño para el campo: \"" + info
					+ "\" no es valido");
		}
	}

	public class DeletingException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public DeletingException(String info) {
			super("La entidad que está tratando de eliminar "
					+ "pueda tener información relacionada, "
					+ "por favor antes de volver a intentarlo, "
					+ "comprobar los datos de la entidad, \"" + info + "\"");
		}
	}

	public class ForeignException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public ForeignException(String info) {
			super("No había ningún dato relacionado con la entrada \"" + info
					+ "\"");
		}
	}

	public class GettingException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public GettingException(String info) {
			super("Hubo una excepción al conseguir " + info);
		}
	}

	public class FindingException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public FindingException(String info) {
			super("Hubo una excepción tratando de encontrar " + info);
		}
	}

}
