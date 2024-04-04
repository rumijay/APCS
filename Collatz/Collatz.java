class Collatz {
    private int startNum;

    public Collatz() {
        this(1); 
    }

    public Collatz(int startNum) {
        this.startNum = startNum;
    }

    public int steps() {
        int steps = 0;
        int num = startNum;

        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            steps++;
        }

        return steps;
    }

    public int[] sequence() {
        int num = startNum;
        int length = steps() + 1;
        int[] sequence = new int[length];
        sequence[0] = num;

        for (int i = 1; i < length; i++) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            sequence[i] = num;
        }

        return sequence;
    }

    public int maxValue() {
        int[] sequence = sequence();
        int max = Integer.MIN_VALUE;

        for (int num : sequence) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public int minOddValue() {
        int[] sequence = sequence();
        int minOdd = Integer.MAX_VALUE;

        for (int num : sequence) {
            if (num % 2 == 1 && num < minOdd && num != 1) {
                minOdd = num;
            }
        }

        return (minOdd == Integer.MAX_VALUE) ? 1 : minOdd;
    }

    public int[] oddValues() {
        int[] sequence = sequence();
        int oddCount = 0;

        for (int num : sequence) {
            if (num % 2 == 1) {
                oddCount++;
            }
        }

        int[] oddValues = new int[oddCount];
        int index = 0;

        for (int num : sequence) {
            if (num % 2 == 1) {
                oddValues[index] = num;
                index++;
            }
        }

        return oddValues;
    }

    public int sumValues() {
        int[] sequence = sequence();
        int sum = 0;

        for (int num : sequence) {
            sum += num;
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Starting number " + startNum + " takes " + steps() + " steps";
    }
}
