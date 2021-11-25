package org.sushibar;

import org.sushibar.resources.MovingTableResource;
import org.sushibar.gui.Gui;
import org.sushibar.threads.*;

public class MainSingleton {
    public static void main() throws Exception {
        MovingTableResource movingTableResource = new MovingTableResource();
        for (int i = 1; i <= 4; i++) {
            CookerThread cookerThread = new CookerThread(movingTableResource, i);
            Thread thread = new Thread(cookerThread);
            thread.setDaemon(true);
            thread.start();
        }
        for (int i = 1; i < 19; i++) {
            CustomerThread customerThread = new CustomerThread(movingTableResource, i);
            Thread thread = new Thread(customerThread);
            thread.setDaemon(true);
            thread.start();
        }
        MoverThread moverThread = new MoverThread(movingTableResource);
        Thread thread = new Thread(moverThread);
        thread.setDaemon(true);
        thread.start();
        new Gui(movingTableResource);
    }
}
