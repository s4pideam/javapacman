/* Ghost class controls the ghost. */
class Ghost extends Mover {

    /* The pellet the ghost was last on top of */
    int lastPelletX, lastPelletY;

    /*Constructor places ghost and updates states*/
    public Ghost(int x, int y) {
        super(x, y);
        lastPelletX = pelletX;
        lastPelletY = pelletY;
    }

    /* update pellet status */
    public void updatePellet() {
        int tempX, tempY;
        tempX = x / gridSize - 1;
        tempY = y / gridSize - 1;
        if (tempX != pelletX || tempY != pelletY) {
            lastPelletX = pelletX;
            lastPelletY = pelletY;
            pelletX = tempX;
            pelletY = tempY;
        }

    }

    /* Random move function for ghost */
    public void move() {
        lastX = x;
        lastY = y;

        /* If we can make a decision, pick a new direction randomly */
        if (isChoiceDest()) {
            direction = newDirection();
        }

        /* If that direction is valid, move that way */
        switch (direction) {
            case 'L':
                if (isValidDest(x - increment, y))
                    x -= increment;
                break;
            case 'R':
                if (isValidDest(x + gridSize, y))
                    x += increment;
                break;
            case 'U':
                if (isValidDest(x, y - increment))
                    y -= increment;
                break;
            case 'D':
                if (isValidDest(x, y + gridSize))
                    y += increment;
                break;
        }
    }
}
