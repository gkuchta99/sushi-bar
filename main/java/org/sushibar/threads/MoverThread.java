package org.sushibar.threads;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.sushibar.resources.MovingTableResource;

@Getter
@Setter
public class MoverThread implements Runnable {
    private MovingTableResource tableResource;

    public MoverThread(MovingTableResource movingTableResource) {
        this.tableResource = movingTableResource;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true){
            tableResource.moveLine();
            Thread.sleep(1500);
        }
    }

}
