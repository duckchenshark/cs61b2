package gh2;

import deque.Deque;
import deque.LinkedListDeque;

public class GuitarString {
    private static final int SR = 44100;
    private static final double DECAY = .996;
    private Deque<Double> buffer;

    public GuitarString(double frequency) {
        int cap = (int) Math.round(SR / frequency);
        buffer = new LinkedListDeque<>();
        for (int i = 0; i < cap; i++) {
            buffer.addFirst(0.0);
        }
    }

    public void pluck() {
        int size = buffer.size();
        for (int i = 0; i < size; i++) {
            double r = Math.random() - 0.5;
            buffer.addLast(r);
            buffer.removeFirst();
        }
    }

    public void tic() {
        double first = buffer.get(0);
        buffer.removeFirst();
        double second = buffer.get(0);
        double a = ((first + second) / 2) * DECAY;
        buffer.addLast(a);
    }

    public double sample() {
        return buffer.get(0);
    }
}
