package com.gamewerks.bgm;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import com.gamewerks.bgm.engine.Well;

public class WellTests {
    private static boolean x = true;
    private static boolean o = false;

    @Test
    public void emptyWellTest() {
        boolean[][] grid = {
          {o, o, o, o},
          {o, x, x, o},
          {o, x, x, o},
          {o, o, o, o}
        };
        Well well = new Well(grid);
        assertFalse(well.isCompletedRow(0));
        assertFalse(well.isCompletedRow(1));
        assertFalse(well.isCompletedRow(2));
        assertFalse(well.isCompletedRow(3));
    }

    @Test
    public void allTrueWellTest() {
        boolean[][] grid = {
          {x, x, x, x},
          {x, x, x, x},
          {x, x, x, x},
          {x, x, x, x}
        };
        Well well = new Well(grid);
        assertTrue(well.isCompletedRow(0));
        assertTrue(well.isCompletedRow(1));
        assertTrue(well.isCompletedRow(2));
        assertTrue(well.isCompletedRow(3));
    }

    @Test
    public void MixedWellTest() {
        boolean[][] grid = {
          {x, o, x, x},
          {x, x, o, x},
          {o, x, x, x},
          {x, x, x, x}
        };
        Well well = new Well(grid);
        assertFalse(well.isCompletedRow(0));
        assertFalse(well.isCompletedRow(1));
        assertFalse(well.isCompletedRow(2));
        assertTrue(well.isCompletedRow(3));
    }

    
    @Test
    public void DeleteRowTest() {
        boolean[][] grid = {
          {x, o, x, x},
          {x, x, x, x},
          {x, x, x, x},
          {x, x, x, x}
        };
        Well well = new Well(grid);
        well.deleteRow(1);
        assertTrue(well.isCompletedRow(1));
        assertTrue(well.isCompletedRow(2));
        assertFalse(well.isCompletedRow(3));
    }

    @Test
    public void DeleteRowTest2() {
        boolean[][] grid = {
          {o, o, o, o},
          {x, x, x, x},
          {x, x, x, x},
          {x, x, x, x},
          {o, o, o, o}
        };
        Well well = new Well(grid);
        well.deleteRow(3);
        assertTrue(well.isCompletedRow(1));
        assertFalse(well.isCompletedRow(0));
    }
}
