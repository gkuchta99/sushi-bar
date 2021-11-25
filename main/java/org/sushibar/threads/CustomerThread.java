package org.sushibar.threads;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.sushibar.resources.MovingTableResource;


@Setter
@Getter
public class CustomerThread implements Runnable {
    private MovingTableResource tableResource;
    private int spot;

    public CustomerThread(MovingTableResource movingTableResource, int spot) throws Exception {
        if (spot > 18 || spot < 1)
            throw new Exception("Out of bounds");
        this.tableResource = movingTableResource;
        this.spot = spot;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            tableResource.takePlate(spot);
            Thread.sleep(8000);
        }
    }
}
