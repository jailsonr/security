package cl.security.strategy;

import java.io.File;
import java.nio.file.Path;

public interface AssetLoader {

	public Object load(String name) throws Exception;

	void processFile();

	AssetLoader setStrategy(Path p);

	void addFileToList(String file);

}
