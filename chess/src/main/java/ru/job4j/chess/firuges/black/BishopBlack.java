package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)){
            throw new ImpossibleMoveException(
                String.format("Could not way by diagonal from %s to %s", position, dest)
        );
        }
        int size = length(position, dest);
        Cell[] steps = new Cell[size];
        int deltaX = position.getX() < dest.getX() ? 1 : -1;
        int deltaY = position.getY() < dest.getY() ? 1 : -1;
        for (int i = 0; i < size; i++) {
            int x = position.getX();
            int y = position.getY();
            steps[i] = Cell.findBy(deltaX * (i + 1) + x, deltaY * (i + 1) + y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
            return ((Math.abs(source.getY() - dest.getY())) == length(source, dest));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    private int length(Cell position, Cell dest) {
        return Math.abs(position.getX() - dest.getX());
    }
}
