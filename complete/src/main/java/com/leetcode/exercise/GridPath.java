package com.leetcode.exercise;

public class GridPath {
    public static int[][] gGrid;
    public static int gK, m, n, mSteps = -1;

    public int shortestPath(int[][] grid, int k) {
        gGrid = grid;
        m = gGrid.length;
        n = grid[0].length;
        gK = k;

        Pointer start = new Pointer(0, 0,  0, gK - gGrid[0][0]);
        navigate(start);
        return mSteps;
    }

    private void navigate(Pointer p) {
        if (p.getX() == m -1 && p.getY() == n - 1) {
            if (mSteps == -1) {
                mSteps = p.getSteps();
            } else {
                mSteps = p.getSteps() < mSteps ? p.getSteps() : mSteps;
            }
            return;
        }
        Pointer moveRight = p.move(p, 1, 0);
        if (moveRight != null) {
            navigate(moveRight);
        }
        Pointer moveLeft = p.move(p, -1, 0);
        if (moveLeft != null) {
            navigate(moveLeft);
        }
        Pointer moveDown = p.move(p, 0, 1);
        if (moveDown != null) {
            navigate(moveDown);
        }
    }

    public static class Pointer {
        private int x;
        private int y;
        private int steps;
        private int k;

        public Pointer(int x, int y, int steps, int k) {
            this.x = x;
            this.y = y;
            this.steps = steps;
            this.k = k;
        }

        Pointer move(Pointer p, int dx, int dy) {
            if (p == null) return null;
            if (dx == 1 && dy == 0) {
                if (p.getX() < gGrid.length - 1) {
                    if (gGrid[p.getX() + 1][p.getY()] == 0 || p.getK() > 0) {
                        return new Pointer(p.getX() + 1, p.getY(), p.getSteps() + 1,p.getK() - gGrid[p.getX() + 1][p.getY()]);
                    }
                }
            } else if (dx == -1 && dy == 0) {
                if (p.getX() > 0) {
                    if (gGrid[p.getX() - 1][p.getY()] == 0 || p.getK() < gK) {
                        return new Pointer(p.getX() - 1, p.getY(), p.getSteps() + 1,p.getK() - gGrid[p.getX() - 1][p.getY()]);
                    }
                }
            } else if (dx == 0 && dy == 1) {
                if (p.getY() < gGrid[1].length - 1) {
                    if (gGrid[p.getX()][p.getY() + 1] == 0 || p.getK() < gK) {
                        return new Pointer(p.getX(), p.getY() + 1, p.getSteps() + 1,p.getK() - gGrid[p.getX()][p.getY() + 1]);
                    }
                }
            }
            return null;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getSteps() {
            return steps;
        }

        public int getK() {
            return k;
        }
    }
}
