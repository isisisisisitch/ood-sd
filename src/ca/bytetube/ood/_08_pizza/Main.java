package ca.bytetube.ood._08_pizza;

public class Main {
    public interface Component {
        void draw();
    }

    static class Button implements Component {

        @Override
        public void draw() {
            System.out.println("drawing button");
        }
    }

    static class BoardDecorator implements Component {
        private Component wrappedComponent;

        public BoardDecorator(Component component) {
            this.wrappedComponent = component;
        }

        @Override
        public void draw() {
            wrappedComponent.draw();
            drawBoard();
        }

        private void drawBoard() {
            System.out.println("drawing board");
        }


    }

    public static void main(String[] args) {
        Component button = new Button();
        button.draw();
        System.out.println("=================");
        Component boardDecoratorButton = new BoardDecorator(button);
        boardDecoratorButton.draw();

    }
}
