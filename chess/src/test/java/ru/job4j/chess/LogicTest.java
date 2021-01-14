package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test
    public void whenMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack  bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        Cell dest = Cell.H6;
        logic.move(bishop.position(), dest);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveImposs()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack  bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        Cell dest = Cell.H7;
        logic.move(bishop.position(), dest);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenOccupied()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack  bishopFirst = new BishopBlack(Cell.C1);
        BishopBlack  bishopSecond = new BishopBlack(Cell.E3);
        logic.add(bishopFirst);
        logic.add(bishopSecond);
        Cell dest = Cell.H6;
        logic.move(bishopFirst.position(), dest);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenNotFound()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack  bishopFirst = new BishopBlack(Cell.C1);
        logic.add(bishopFirst);
        Cell dest = Cell.H6;
        logic.move(Cell.E1, dest);
    }
}