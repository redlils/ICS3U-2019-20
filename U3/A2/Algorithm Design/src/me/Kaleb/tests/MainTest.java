package me.Kaleb.tests;

import me.Kaleb.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
  
  Main main;
  
  @BeforeEach
  void setUp() {
    main = new Main();
  }
  
  @AfterEach
  void tearDown() {
    main = null;
  }
  
  @Test
  void factorial() {
    assertEquals(1, main.factorial(1));
    assertEquals(2, main.factorial(2));
    assertEquals(6, main.factorial(3));
    assertEquals(24, main.factorial(4));
    assertEquals(120, main.factorial(5));
  }
  
  @Test
  void prime() {
    assertTrue(main.prime(1));
    assertTrue(main.prime(2));
    assertTrue(main.prime(3));
    assertFalse(main.prime(4));
    assertTrue(main.prime(5));
  }
  
  @Test
  void fibonacci() {
    assertEquals(1, main.fibonacci(1));
    assertEquals(1, main.fibonacci(2));
    assertEquals(2, main.fibonacci(3));
    assertEquals(3, main.fibonacci(4));
    assertEquals(5, main.fibonacci(5));
  }
}