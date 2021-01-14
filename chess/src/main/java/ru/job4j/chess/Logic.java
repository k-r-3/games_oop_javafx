package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Figure figure = figures[index];
        Cell[] steps = figure.way(dest);
        free(steps);
        figures[index] = figure.copy(dest);
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < steps.length; j++) {
                Figure figure = figures[i];
                Cell cell = steps[j];
                if (figure.position() == cell) {
                    throw new OccupiedCellException("Cell " + cell + "occupied by " + figure);
                }
            }
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

     private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }
}
