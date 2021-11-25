package org.sushibar.threads;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.sushibar.resources.MovingTableResource;

@RequiredArgsConstructor
@Getter
@Setter
public class CookerThread implements Runnable {
    MovingTableResource tableResource;
    private int spot;

    @Override
    public void run() {

    }
}
