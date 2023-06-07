package cl.security.strategy.loaders;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import cl.security.controller.IControllerFileStrategy;
import cl.security.controller.ThreadProcessFile;
import cl.security.database.DatabaseConnection;

public abstract class AbstractLoaderClass {

	protected Set<String> files;
	protected static TXTLoader instance;
	Path p;
	protected IControllerFileStrategy strategy;

	void processFile() {

//		final File folder = new File("C:\\Users\\jails\\Downloads\\Estimar\\VAR\\");

		List<IControllerFileStrategy> map = null;
		
		map = files.stream().map(f -> new File(p.toUri().getPath() + f)).map(f -> strategy).toList();
		
		ExecutorService service = Executors.newFixedThreadPool(map.size());

		map.forEach(s -> {

			service.submit(() -> new Thread(new ThreadProcessFile(s)).start());

		});

		service.shutdown();
		try {
			service.awaitTermination(10, TimeUnit.MINUTES);
			DatabaseConnection.getInstance().shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

}
