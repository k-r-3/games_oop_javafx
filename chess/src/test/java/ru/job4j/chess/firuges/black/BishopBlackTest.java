package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void whenPosition() {
        Cell in = Cell.A1;
        BishopBlack bishop = new BishopBlack(in);
        Cell out = bishop.position();
        assertThat(in, is(out));
    }

    @Test
    public void whenCopy() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Cell in = Cell.B2;
        Cell out = bishop.copy(in).position();
        assertThat(in, is(out));
    }

    @Test
    public void whenC1WayThenD2E3F4G5() {
        BishopBlack start = new BishopBlack(Cell.C1);
        Cell[] cells = start.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(cells, is(expected));
    }

    @Test
    public void whenIsDiagonalRightAndDown() {
        BishopBlack start = new BishopBlack(Cell.C1);
        Cell dest = start.copy(Cell.E3).position();
        assertTrue(start.isDiagonal(start.position(), dest));
    }

    @Test
    public void whenIsDiagonalLeftAndDown() {
        BishopBlack start = new BishopBlack(Cell.D4);
        Cell dest = start.copy(Cell.G1).position();
        assertTrue(start.isDiagonal(start.position(), dest));
    }

    @Test
    public void whenIsDiagonalRightAndUp() {
        BishopBlack start = new BishopBlack(Cell.C1);
        Cell dest = start.copy(Cell.A3).position();
        assertTrue(start.isDiagonal(start.position(), dest));
    }

    @Test
    public void whenIsDiagonalLeftAndUp() {
        BishopBlack start = new BishopBlack(Cell.D4);
        Cell dest = start.copy(Cell.A1).position();
        assertTrue(start.isDiagonal(start.position(), dest));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNotDiagonal() {
        BishopBlack start = new BishopBlack(Cell.D4);
        start.way(Cell.A2);
    }
}