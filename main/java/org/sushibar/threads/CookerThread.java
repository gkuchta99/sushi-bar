package org.sushibar.threads;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.sushibar.resources.MovingTableResource;

@Getter
@Setter
public class CookerThread implements Runnable {
    MovingTableResource tableResource;
    private int spot;

    public CookerThread(MovingTableResource movingTableResource, int spot) throws Exception {
        if (spot > 4 || spot < 1) {
            throw new Exception("out of bounds");
        }
        this.tableResource = movingTableResource;
        this.spot = spot;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            Thread.sleep(1000);
            tableResource.addPlate(spot);
            Thread.sleep(4000);
        }
    }
}
