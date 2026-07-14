class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // two pointer approach, read to iterate through the array, write for 
        // the asteroid at the top of the 'stack'
        // value of write is the size of the 'stack',
        // top of the stack given by asteroids[write - 1]
        int write = 0; 

        for (int read = 0; read < asteroids.length; read++) {
            int current = asteroids[read];
            boolean currentDestroyed = false;
            // top of the stack moving to the right, current moving to the left
            while (write > 0 && asteroids[write - 1] > 0 && current < 0) {
                if (asteroids[write - 1] < Math.abs(current)) { // top is smaller than current
                    write--;
                } else if (asteroids[write - 1] > Math.abs(current)) { // top is larger
                    currentDestroyed = true;
                    break; // read the next asteroid
                } else { // equal in magnitude, opposite direction
                    currentDestroyed = true;
                    write--;
                    break; // move on to the next asteroid
                }
            }

            // at the end, if the current asteroid survives, takes the position of the write
            if (!currentDestroyed) {
                asteroids[write] = current;
                write++;
            }
        }

        // create resulting array of asteroids
        return Arrays.copyOf(asteroids, write);
    }
}