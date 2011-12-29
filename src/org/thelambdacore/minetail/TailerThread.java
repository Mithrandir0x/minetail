package org.thelambdacore.minetail;

import java.io.File;
import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;

/**
 *
 * @author Mithrandir
 */
public class TailerThread 
{
    
    private Thread t;
    
    public void start()
    {
        TailerListener listener = new LogListener();
        Tailer tail = new Tailer(new File("server.log"), listener, 1000, true);
        t = new Thread(tail);
        t.start();
    }
    
    public void stop()
    {
        try 
        {
            t.join(500);
        }
        catch ( InterruptedException ex )
        {
        }
    }
    
}
