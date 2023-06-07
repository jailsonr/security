package cl.security.strategy.loaders;

import java.nio.file.Path;
import java.util.HashSet;

import cl.security.factory.TXTFileValidator;
import cl.security.strategy.AssetLoader;

public final class TXTLoader extends AbstractLoaderClass implements AssetLoader {

	@Override
	public Object load(String name) throws Exception {

		return this;

	}

	@Override
	public void processFile() {
		super.processFile();

	}

	@Override
	public AssetLoader setStrategy(Path p) {
		super.p = p;
		super.strategy = TXTFileValidator.getDirectoryObject(p);
		return this;
	}

	@Override
	public void addFileToList(String file) {
		if (files == null) {
			files = new HashSet<>();
		}
		files.add(file);
	}

}
