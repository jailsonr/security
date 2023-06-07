package cl.security.strategy;

import java.util.HashMap;

public class AssetManager {
	
	private HashMap<String, AssetLoader> loaders = new HashMap<>();

    public void addLoader(AssetLoader loader, String extension)
    {
        loaders.put(extension, loader);
    }

    @SuppressWarnings("unchecked")
    public <T> T load(String name)
    {
        int i = name.lastIndexOf('.');
        if (i == -1)
            throw new RuntimeException("\"" + name + "\" has no extension, and so has no associated asset loader");

        String extension = name.substring(i+1);
        AssetLoader loader = loaders.get(extension);
        if (loader == null)
            throw new RuntimeException("No loader registered for \"." + extension + "\" files");
        try
        {
            return (T) loader.load(name);
        }
        catch(ClassCastException e)
        {
            throw new RuntimeException("\"" + name + "\" could not be loaded as the expected type");
        }
        catch(Exception e)
        {
            throw new RuntimeException("Failed to load " + name, e);
        }
    }

}
