class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int refill = 0;
        int a = 0;
        int b = plants.length - 1;

        int ca = capacityA;
        int cb = capacityB;

        while (a <= b) {

        
            if (a == b) {
                if (Math.max(ca, cb) < plants[a]) {
                    refill++;
                }
                break;
            }

            // Alice (left)
            if (ca < plants[a]) {
                refill++;
                ca = capacityA;
            }
            ca -= plants[a];

            // Bob (right)
            if (cb < plants[b]) {
                refill++;
                cb = capacityB;
            }
            cb -= plants[b];

            a++;
            b--;
        }

        return refill;
    }
}
