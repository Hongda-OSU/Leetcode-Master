class SnakeGame {
    private int len, rows, cols;
    private int[][] food;
    private LinkedList<Position> snake;

    public SnakeGame(int width, int height, int[][] food) {
        this.len = 0;
        this.rows = height;
        this.cols = width;
        this.food = food;
        this.snake = new LinkedList<>();
        snake.add(new Position(0, 0));
    }
    
    public int move(String direction) {
        Position curr = new Position(snake.get(0).x, snake.get(0).y);
        switch (direction) {
            case "U" -> curr.x--;
            case "L" -> curr.y--;
            case "R" -> curr.y++;
            case "D" -> curr.x++;
        }
        if (curr.x < 0 || curr.x >= rows || curr.y < 0 || curr.y >= cols)
            return -1;
        for (int i = 1; i < snake.size() - 1; i++) {
            Position next = snake.get(i);
            if (next.equal(curr))
                return -1;
        }
        snake.addFirst(curr);
        if (len < food.length) {
            Position p = new Position(food[len][0], food[len][1]);
            if (curr.equal(p))
                len++;
        }
        while (snake.size() > len + 1)
            snake.removeLast();
        return len;
    }
}

class Position {
    public int x, y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean equal(Position p) {
        return this.x == p.x && this.y == p.y;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */