package OOP;

public class Robot {
    int x = 0;
    int y = 0;
    Direction direction = Direction.UP;

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        System.out.println("Поворот против часовой стрелки");
        if (direction == Direction.DOWN) {
            this.direction = Direction.RIGHT;
            return;
        }

        if (direction == Direction.UP) {
            this.direction = Direction.LEFT;
            return;
        }

        if (direction == Direction.LEFT) {
            this.direction = Direction.DOWN;
            return;
        }

        if (direction == Direction.RIGHT) {
            this.direction = Direction.UP;
            return;
        }
    }

    public void turnRight() {
        System.out.println("поворот по часовой стрелке");
        if (this.direction == Direction.DOWN) {
            System.out.println("Вниз -> влево");
            this.direction = Direction.LEFT;
            return;
        }

        if (this.direction == Direction.UP) {
            System.out.println("Вверх -> вправо");
            this.direction = Direction.RIGHT;
            return;
        }

        if (this.direction == Direction.LEFT) {
            System.out.println("Влево -> вверх");
            this.direction = Direction.UP;
            return;
        }

        if (this.direction == Direction.RIGHT) {
            System.out.println("Вправо -> вниз");
            this.direction = Direction.DOWN;
            return;
        }
    }

    public void stepForward() {
        System.out.println("движение");
        if (direction == Direction.DOWN) {
            System.out.println("вниз");
            this.y--;
        }

        if (direction == Direction.UP) {
            System.out.println("вверх");
            this.y++;
        }

        if (direction == Direction.LEFT) {
            System.out.println("налево");
            this.x--;
        }

        if (direction == Direction.RIGHT) {
            System.out.println("направо");
            this.x++;
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        BEGIN:
        if (robot.getX() < toX) {
            switch (robot.getDirection()) {
                case UP: {
                    robot.turnRight();
                    break;
                }
                case DOWN: {
                    robot.turnLeft();
                    break;
                }
                case LEFT: {
                    robot.turnRight();
                    robot.turnRight();
                    break;
                }
                case RIGHT:
                    break;
            }
        } else if (robot.getX() > toX) {
            switch (robot.getDirection()) {
                case UP: {
                    robot.turnLeft();
                    break;
                }
                case DOWN: {
                    robot.turnRight();
                    break;
                }
                case RIGHT: {
                    robot.turnRight();
                    robot.turnRight();
                    break;
                }
                case LEFT:
                    break;
            }
        }
        while (robot.getX() != toX) {
            robot.stepForward();
        }
        switch (robot.getDirection()){
            case LEFT : {
                if(robot.getY() > toY){
                    robot.turnLeft();
                } else if (robot.getY() < toY){
                    robot.turnRight();
                }
            }
            case RIGHT : {
                if(robot.getY() > toY){
                    robot.turnRight();
                } else if (robot.getY() < toY){
                    robot.turnLeft();
                }
            }
            case UP: break;
            case DOWN: break;
        }
        while (toY != robot.getY()){
            robot.stepForward();

        }
    }
}
