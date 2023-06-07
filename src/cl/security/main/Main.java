package cl.security.main;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cl.security.strategy.AssetLoader;
import cl.security.strategy.AssetManager;
import cl.security.strategy.loaders.AbstractLoaderClass;
import cl.security.strategy.loaders.TXTLoader;

public class Main {

	public static void main(String[] args) {
		
		Path path = Paths.get("C:\\Users\\jailson.viana\\Downloads\\VAR\\");
		
		AssetLoader loadTXT = null;
		AssetLoader loadCSV = null;
		
		AssetManager assets = new AssetManager();
		assets.addLoader(new TXTLoader().setStrategy(path), "txt");
		
		Set<String> files = listFilesUsingJavaIO(path.toFile().getPath());
		
		for (String file: files) {
			
			loadTXT = assets.load(file);
			
			loadTXT.addFileToList(file);
			
//			loadCSV = assets.load(file);
//			
//			loadCSV.addFileToList(file);
		}

		try {
			loadTXT.processFile();
			loadCSV.processFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static Set<String> listFilesUsingJavaIO(String dir) {
	    return Stream.of(new File(dir).listFiles())
	      .filter(file -> !file.isDirectory())
	      .map(File::getName)
	      .collect(Collectors.toSet());
	}

}
