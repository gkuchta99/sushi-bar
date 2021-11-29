package org.sushibar.threads;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.sushibar.resources.MovingTableResource;

import static org.sushibar.resources.MovingTableResource.EMPTY;
import static org.sushibar.resources.MovingTableResource.FOOD;

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
            addPlate(spot);
            Thread.sleep(4000);
        }
    }

    private synchronized void addPlate(int cookerIndex) throws Exception {
        if (cookerIndex > 4 || cookerIndex < 1)
            throw new Exception("Cooker index out of bound when adding plate!");
        if (cookerIndex == 1) {
            if (tableResource.getFoodLine()[0] == EMPTY)
                tableResource.setFoodLineElement(0, FOOD);
            else if (tableResource.getFoodLine()[17] == EMPTY)
                tableResource.setFoodLineElement(17, FOOD);
        } else if (cookerIndex == 2) {
            if (tableResource.getFoodLine()[5] == EMPTY)
                tableResource.setFoodLineElement(5, FOOD);
            else if (tableResource.getFoodLine()[6] == EMPTY)
                tableResource.setFoodLineElement(6, FOOD);
        } else if (cookerIndex == 3) {
            if (tableResource.getFoodLine()[8] == EMPTY)
                tableResource.setFoodLineElement(8, FOOD);
            else if (tableResource.getFoodLine()[9] == EMPTY)
                tableResource.setFoodLineElement(9, FOOD);
        } else {
            if (tableResource.getFoodLine()[14] == EMPTY) {
                tableResource.setFoodLineElement(14, FOOD);
            } else if (tableResource.getFoodLine()[15] == EMPTY) {
                tableResource.setFoodLineElement(15, FOOD);
            }
        }
        tableResource.updateFoodLine();
    }
}
