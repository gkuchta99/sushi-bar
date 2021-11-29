package org.sushibar.threads;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.sushibar.resources.MovingTableResource;

import static org.sushibar.resources.MovingTableResource.EMPTY;
import static org.sushibar.resources.MovingTableResource.FOOD;


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
            takePlate(spot);
            Thread.sleep(8000);
        }
    }

    private void takePlate(int customerSeat) throws Exception {
        if (customerSeat > 18 || customerSeat < 1)
            throw new Exception("index out of bounds");
        if (tableResource.getFoodLine()[customerSeat - 1] == FOOD) {
            tableResource.setFoodLineElement(customerSeat - 1, EMPTY);
            tableResource.updateFoodLine();
        }
    }
}
