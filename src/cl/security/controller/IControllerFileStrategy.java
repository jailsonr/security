package cl.security.controller;

import java.nio.file.Path;
import java.util.List;

public interface IControllerFileStrategy {

	String getFileName();

	String[] getHeader();

	List<String> getDataAsList();

}
