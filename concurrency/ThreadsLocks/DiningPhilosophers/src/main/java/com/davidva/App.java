package com.davidva;

public class App {
  private static final int NUM_PHILOSOPHERS = 8;

  public static void main(String[] args) throws InterruptedException {
    final Chopstick[] chopsticks = buildChopsticks();

    final Philosopher[] philosophers = buildPhilosophers(chopsticks);

    for (Philosopher philosopher : philosophers) {
      philosopher.start();
    }

    for (Philosopher philosopher : philosophers) {
      philosopher.join();
    }
  }

  private static Chopstick[] buildChopsticks() {
    final Chopstick[] chopsticks = new Chopstick[NUM_PHILOSOPHERS];
    for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
      chopsticks[i] = new Chopstick(i);
    }
    return chopsticks;
  }

  private static Philosopher[] buildPhilosophers(final Chopstick[] chopsticks) {
    final Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
    for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
      philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % NUM_PHILOSOPHERS]);
    }
    return philosophers;
  }
}