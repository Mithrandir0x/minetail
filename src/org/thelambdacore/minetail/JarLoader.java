package org.thelambdacore.minetail;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * The purpose of this class is to load a Java Archive during application
 * execution.
 * 
 * This implementation is based (almost 99% of it) on MassiveCraft's
 * ClassLoadHack class implementation.
 *
 * @author Mithrandir
 */
public class JarLoader 
{
    
    static {
        systemClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
    }
    
    private static URLClassLoader systemClassLoader;
    
    public static boolean load(File file)
    {
        try
        {
            //System.out.println("Loading file " + file.getAbsolutePath() + "...");
            
            if ( file.exists() )
            {
                URL fileUrl = file.toURI().toURL();

                for ( URL url : systemClassLoader.getURLs() )
                {
                    if ( url.sameFile(fileUrl) )
                    {
                        //System.out.println("File was already available in class loader. Skipping.");
                        return true;
                    }
                }

                Method addURLMethod = URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{ URL.class });
                addURLMethod.setAccessible(true);
                addURLMethod.invoke(systemClassLoader, new Object[]{ fileUrl });

                return true;
            }
            else
            {
                return false;
            }
        }
        catch ( Exception ex )
        {
            return false;
        }
    }
    
}
