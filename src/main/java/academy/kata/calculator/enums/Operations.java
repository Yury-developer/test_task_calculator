package academy.kata.calculator.enums;

public enum Operations {

    ADDITION("+") {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },

    SUBTRACTION("-") {
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
    },

    MULTIPLICATION("*") {
        @Override
        public int calculate(int a, int b) {
            return a * b;
        }
    },

    DIVISION("/") {
        @Override
        public int calculate(int a, int b) {
            return a / b;
        }
    };


    private String operation;


    Operations(String operation) {
        this.operation = operation;
    }


    public String getOperation() {
        return operation;
    }

    public abstract int calculate(int a, int b);

    @Override
    public String toString() {
        return operation;
    }
}
