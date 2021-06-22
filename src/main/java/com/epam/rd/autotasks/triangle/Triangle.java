package com.epam.rd.autotasks.triangle;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Triangle {
    double x1;
    double x2;
    double x3;
    double y1;
    double y2;
    double y3;
    double segment1;
    double segment2;
    double segment3;
    public Triangle(Point a, Point b, Point c) {
        x1 = a.getX();
        x2 = b.getX();
        x3 = c.getX();
        y1 = a.getY();
        y2 = b.getY();
        y3 = c.getY();
        segment1 = sqrt(pow((x2 - x1), 2) + pow((y2 - y1), 2));
        segment2 = sqrt(pow((x3 - x1), 2) + pow((y3 - y1), 2));
        segment3 = sqrt(pow((x3 - x2), 2) + pow((y3 - y2), 2));
        if (!((segment1 + segment2) > segment3 && (segment1 + segment3) > segment2 &&
                (segment2 + segment3) > segment1))
            throw new RuntimeException();
    }

    public double area() {
        double i = (segment1 + segment2 + segment3)/2;
        return sqrt((i * (i - segment1) * (i - segment2) * (i - segment3)));

    }

    public Point centroid(){
        double centrX = (x1 + x2 + x3)/3;
        double centrY = (y1 +y2 + y3)/3;
        return new Point(centrX, centrY);
    }

}
