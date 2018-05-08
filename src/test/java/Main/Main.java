/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import TestEX8KFS.Polygon;
import TestEX8KFS.PolygonHandlerImpl;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Retro
 */
public class Main {
    
    public static PolygonHandlerImpl ph;
    
    public static void main (String[] args) throws Exception{
        PolygonHandlerImpl ph = new PolygonHandlerImpl();
        Polygon p1 = ph.CreatePolygon(new double[]{1,1,1});
        Polygon p2 = ph.CreatePolygon(new double[]{2,2,2});
        Polygon p3 = ph.CreatePolygon(new double[]{3,3,3});
        Polygon p4 = ph.CreatePolygon(new double[]{50,52,60});
        Polygon p5 = ph.CreatePolygon(new double[]{34,43,32});
        Polygon p6 = ph.CreatePolygon(new double[]{100,120,150});
        Polygon p7 = ph.CreatePolygon(new double[]{32,25,25});
        
        ArrayList<Polygon> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        
        list.forEach(new Consumer<Polygon>() {
            @Override
            public void accept(Polygon x) {
                try {
                    System.out.println(ph.CalculateAnglesFromTriangle(x));
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.out.println(ph.CalculateArea(x));
                System.out.println(ph.calculatePerimeter(x));
                try {
                    System.out.println(ph.CalculateTriangleType(x));
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        ArrayList<Polygon> sortedbyarea = ph.SortByArea(list);
        ArrayList<Polygon> sortedbyPerimeter = ph.SortByPerimeter(list);
        
    }
}
