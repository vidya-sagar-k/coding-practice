// https://leetcode.com/problems/design-snake-game/solutions/82668/java-deque-and-hashset-design-with-detailed-comments/?envType=company&envId=atlassian&favoriteSlug=atlassian-six-months

class SnakeGame {
    int score;
    int[][] food;
    int width;
    int height;

    int foodIndex;

    Set<Integer> set; // look up for self bite
    Deque<Integer> body; // updating tail

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        set.add(0);
        body = new LinkedList<>();
        body.offerLast(0);
    }
    
    public int move(String direction) {
        if (score == -1) return -1;

        int rowHead = body.peekFirst() / width;
        int colHead = body.peekFirst() % width;

        switch(direction) {
            case "U" :rowHead--;
            break;

            case "D" :rowHead++;
            break;

            case "L" :colHead--;
            break;

            default :colHead++;
            
        }
        
        int head = rowHead*width + colHead;
        set.remove(body.peekLast()); // remove tail
        // out of boundary or eating self
        if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            return -1;
        }

        set.add(head);
        body.offerFirst(head);

        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            foodIndex++;
            set.add(body.peekLast());  // old tail 
            return ++score;
        }

        // normal move, remove tail, add head
        body.pollLast();
        return score;

        
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
