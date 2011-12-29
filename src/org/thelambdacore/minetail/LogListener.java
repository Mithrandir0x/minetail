package org.thelambdacore.minetail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Mithrandir
 */
public class LogListener implements TailerListener
{
    
    private Logger log;

    @Override
    public void init(Tailer tailer)
    {
        try
        {
            this.loadLog4J();
        }
        catch ( Exception ex )
        {
        }
    }

    @Override
    public void fileNotFound()
    {
        System.out.println("File not available.");
    }

    @Override
    public void fileRotated()
    {
        System.out.println("File is being rotated");
    }

    @Override
    public void handle(String line)
    {
        log.info(line);
    }

    @Override
    public void handle(Exception ex)
    {
    }
    
    private void loadLog4J() throws IOException
    {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(MineTail.PluginFolder, "log4j.properties")));
        
        PropertyConfigurator.configure(properties);
        log = Logger.getLogger(LogListener.class);
    }
    
}
