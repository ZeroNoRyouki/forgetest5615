package test.forgetest5615;

public interface IInputOutputPort {

    enum Direction {
        Input,
        Output;

        public Direction opposite() {
            return Input == this ? Output : Input;
        }

        public boolean isInput() {
            return Input == this;
        }

        public boolean isOutput() {
            return Output == this;
        }

        public static Direction from(boolean isInput) {
            return isInput ? Input : Output;
        }
    }

    Direction getDirection();

    void setDirection(Direction direction, boolean markForUpdate);

    void toggleDirection(boolean markForUpdate);

}
