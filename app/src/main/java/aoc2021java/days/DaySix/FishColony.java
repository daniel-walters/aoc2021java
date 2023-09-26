package aoc2021java.days.DaySix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FishColony {
    private final int DEFAULT_DAYS_TO_SPAWN = 8;
    private final int MAX_DAYS = 8;
    private final int RESPAWN_DAYS = DEFAULT_DAYS_TO_SPAWN - 2;
    private Map<Integer, Long> spawnMap;

    public FishColony(ArrayList<Integer> initialFish) {
        this.spawnMap = this.createInitialMap();

        for (Integer fish : initialFish) {
            this.addFish(fish);
        }
    }

    public void simulate(int days) {
        for (int i = 0; i < days; i++) {
            this.advanceDay();
        }
    }

    public long getNumFish() {
        long count = 0;

        for (long i : this.spawnMap.values()) {
            count += i;
        }

        return count;
    }

    private void advanceDay() {
        long numFishToAdd = this.spawnMap.get(0);
        this.spawnMap.put(0, (long) 0);

        for (int i = 1; i <= this.MAX_DAYS; i++) {
            long curDayFish = this.spawnMap.get(i);
            long prevDayFish = this.spawnMap.get(i - 1);

            this.spawnMap.put(i - 1, prevDayFish + curDayFish);
            this.spawnMap.put(i, (long) 0);
        }

        this.spawnMap.put(this.RESPAWN_DAYS,
            numFishToAdd + this.spawnMap.get(this.RESPAWN_DAYS));
        this.spawnMap.put(this.DEFAULT_DAYS_TO_SPAWN, numFishToAdd);
    }

    private void addFish(int daysUntilSpawn) {
        long curr = this.spawnMap.get(daysUntilSpawn);
        this.spawnMap.put(daysUntilSpawn, curr + 1);
    }

    private HashMap<Integer, Long> createInitialMap() {
        HashMap<Integer, Long> map = new HashMap<>();

        for (int i = 0; i <= this.MAX_DAYS; i++) {
            map.put(i, (long) 0);
        }

        return map;
    }
}
