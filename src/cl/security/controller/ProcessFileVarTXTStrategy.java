package cl.security.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessFileVarTXTStrategy implements IControllerFileStrategy {

	public BufferedReader fileReader;
	Path file;
	
	

	public ProcessFileVarTXTStrategy(Path f) {
		this.file = f;

		try {
			fileReader = new BufferedReader(new FileReader(f.toFile()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
	}

//	public static void main(String[] args) {
////		File file = new File("C:\\Users\\jails\\Downloads\\Estimar\\VAR\\2023_05_29_REP_7_VALORES_RF.txt");
//		
//		Path path = Paths.get("C:\\Users\\jails\\Downloads\\Estimar\\VAR\\2023_05_29_REP_7_VALORES_RF.txt");
//		
//		
//		ProcessFileVarTXTStrategy pd = new ProcessFileVarTXTStrategy(path);
//		
//		pd.getDataAsList();
//				
//	}

	@Override
	public String[] getHeader() {

		String findFirst[] = fileReader.lines().skip(5).findFirst().get().split(";");

		return findFirst;
		
		
	}

	@Override
	public List<String> getDataAsList() {
		
		List<String> lines;
		List<String> data = null;
        try {
            lines = Files.readAllLines(file.toFile().toPath(), StandardCharsets.UTF_8);
            
            data = lines.stream().skip(6).collect(Collectors.toList());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		return data;
	}

	@Override
	public String getFileName() {
		String name = file.toFile().getName().substring(11, file.toFile().getName().length() - 4).replace(".", "_").replace("-", "_");
		return name;
	}

}
