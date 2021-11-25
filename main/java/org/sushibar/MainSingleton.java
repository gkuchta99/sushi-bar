package org.sushibar;

import org.sushibar.resources.MovingTableResource;

public class MainSingleton {
    //todo set threads to deamon
    public static void main() throws Exception {
        MovingTableResource movingTableResource = new MovingTableResource();
        movingTableResource.display();
    }
}
