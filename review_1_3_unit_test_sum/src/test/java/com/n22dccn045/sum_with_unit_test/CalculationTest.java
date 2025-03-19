/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.n22dccn045.sum_with_unit_test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author trungkieen
 */
public class CalculationTest {
    
    public CalculationTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of sum method, of class Calculation.
     */
    @Test
    public void testSum() {
        assertEquals(Calculation.sum(0, 0), 0);
        assertEquals(Calculation.sum(0, -1), -1);
        assertEquals(Calculation.sum(-2, -1), -3);

        assertEquals(Calculation.sum(2, 5), 7);
        

    }
    
}
