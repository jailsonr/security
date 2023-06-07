package cl.security.factory;

import java.nio.file.Path;

import cl.security.controller.IControllerFileStrategy;
import cl.security.controller.ProcessFileVarTXTStrategy;

public abstract class TXTFileValidator {

	public static IControllerFileStrategy getDirectoryObject(Path p) {

		// Encontrar logica para identificar archivos TXT VAR
		if (true)
			return getVARDirectoryObject(p);
		return null;
	}

	private static IControllerFileStrategy getVARDirectoryObject(Path p) {

		// Encontrar logica para identificar archivos TXT VAR
		if (true)
			return new ProcessFileVarTXTStrategy(p);
		return null;
	}

	private static IControllerFileStrategy getTXTDotCommaDelimiterObject(Path p) {
		return null;
	}

	private static IControllerFileStrategy getTXTTabCommaDelimiterObject(Path p) {
		return null;
	}

	private static IControllerFileStrategy getCSVTabCommaDelimiterObject(Path p) {
		return null;
	}

}
