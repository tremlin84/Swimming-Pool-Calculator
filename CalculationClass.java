package com.company;

public class CalculationClass {
    /*
     * These methods are the main calculations for the application they are all protected static methods designed to be inherited,
     * all methods have a return type of double and handle all mathematical logic within the application.
     */
    // Calculates the volume of a rectangle pool
    protected static double CalculateVolume(double depth, double length, double width){
        return length * width * depth;
    }

    // Calculates the volume of a rectangle pool with deep end & shallow end
    protected static double CalculateVolumeGrad(double depthDeep, double depthShallow, double length, double width ){
        double depth = (depthDeep + depthShallow) /2;
        return length * width * depth;
    }

    // Calculates the internal surface area of a rectangle pool
    protected static double CalculateInternalSurface(double depth, double length, double width){
        double base = (length * width);
        double sides = (length + width) *2;
        return sides * depth + base;
    }

    // Calculates the internal surface area of a rectangle pool with deep end & shallow end
    protected static double CalculateInternalSurfaceGrad(double depthDeep, double depthShallow, double length, double width){
        double depth = (depthDeep + depthShallow) /2;
        double base = (length * width);
        double sides = (length + width) *2;
        return sides * depth + base;
    }

    // Calculates the volume of a circular pool
    protected static double CalculateVolumePie(double depth, double radius){
        double pi = Math.PI * radius * radius;
        return pi * depth;
    }

    // Calculates the volume of a circular pool with deep end & shallow end
    protected static double CalculateVolumePieGrad(double depthShallow, double depthDeep, double radius){
        double depth = (depthDeep + depthShallow) /2;
        double pi = Math.PI * radius * radius * depth;
        return pi;
    }

    // Calculates the internal surface area of a circular pool
    protected static double CalculateSurfaceAreaPie(double depth, double radius){
        double area = 2* Math.PI * radius * (radius + depth);
        return area;
    }

    // Calculates the internal surface area of a circular pool with deep end & shallow end
    protected static double CalculateSurfaceAreaPieGrad(double depthShallow, double depthDeep, double radius){
        double depth = (depthDeep + depthShallow) /2;
        double area = 2* Math.PI * radius * (radius + depth);
        return area;
    }

    // Level depth calculates the base of a pool with deep end
    protected static double LevelDepth(double depthDeep,double depthShallow){
        return (depthDeep + depthShallow)/2;
    }
}
