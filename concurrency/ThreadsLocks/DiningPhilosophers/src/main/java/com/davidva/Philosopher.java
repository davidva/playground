package com.davidva;

import java.util.Random;

class Philosopher extends Thread {
  private final int pos;
  private final Chopstick left, right;
  private final Random random;

  public Philosopher(final int pos, final Chopstick left, final Chopstick right) {
    System.out.println("Creating " + this + " using chopsticks " + left + " and " + right);
    this.pos = pos;
    this.left = left;
    this.right = right;
    random = new Random();
  }

  public void run() {
    System.out.println("Starting philosopher " + pos);
    try {
      while (true) {
        Thread.sleep(random.nextInt(1));
        System.out.println(this + " will try to take the chopsticks");
        synchronized (left) {
          synchronized (right) {
            System.out.println(this + " takes the chopsticks");
            Thread.sleep(random.nextInt(1));
            System.out.println(this + " releases the chopsticks");
          }
        }
      }
    } catch (InterruptedException e) {}
  }

  public String toString() {
    return "Philosopher " + pos;
  }
}
