package org.thelambdacore.minetail;

import java.io.File;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Plugin 
 *
 * @author Mithrandir
 */
public class MineTail extends JavaPlugin
{
    
    private TailerThread tt;
    public static File PluginFolder;
    
    @Override
    public void onEnable()
    {
        //Plugin Configuration
        MineTail.PluginFolder = this.getDataFolder();
        
        log("Loading jars...");
        //Load dinamically libraries
        if ( JarLoader.load(new File(this.getDataFolder(), "commons-io.jar")) && JarLoader.load(new File(this.getDataFolder(), "log4j.jar")) )
        {
            log("Setting up tailer thread...");
            System.setProperty("log4j.defaultInitOverride", "true");
            
            // Tailer Configuration
            tt = new TailerThread();
            tt.start();
            
            log("Started succesfully.");
        }
        else
        {
            log(Level.WARNING, "Libraries are not available.");
        }
    }

    @Override
    public void onDisable()
    {
        if ( tt != null )
            tt.stop();
        
        log("Disabled.");
    }
    
    public void log(Object message)
    {
        Logger.getLogger("Minecraft").log(Level.INFO, "[" + this.getDescription().getFullName() + "] " + message);
    }
    
    public void log(Level level, Object message)
    {
        Logger.getLogger("Minecraft").log(level, "[" + this.getDescription().getFullName() + "] " + message);
    }
    
}
