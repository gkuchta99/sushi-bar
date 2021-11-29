package org.sushibar.threads;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.sushibar.resources.MovingTableResource;

import java.util.Arrays;

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
        while (true) {
            moveLine();
            Thread.sleep(1500);
        }
    }

    private synchronized void moveLine() {
        char[] tempFoodLine = new char[18];
        for (int i = 0; i < tempFoodLine.length; i++) {
            if (i == 17) {
                tempFoodLine[0] = tableResource.getFoodLine()[17];
            } else {
                tempFoodLine[i + 1] = tableResource.getFoodLine()[i];
            }
        }
        tableResource.setFoodLine(tempFoodLine);
        tableResource.updateFoodLine();
    }

}
