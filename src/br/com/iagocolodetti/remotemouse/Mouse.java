package br.com.iagocolodetti.remotemouse;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 *
 * @author iagov
 */
public class Mouse {
    
    public void click(int button) {
        
        /*
            1 = Esquerdo
            2 = Meio
            3 = Direito
            4 = Esquerdo Duplo
        */
        
        try {
            Robot robot = new Robot();
            switch (button) {
                case 1: // Esquerdo
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    break;
                case 2: // Meio
                    robot.mousePress(InputEvent.BUTTON2_MASK);
                    robot.mouseRelease(InputEvent.BUTTON2_MASK);
                    break;
                case 3: // Direito
                    robot.mousePress(InputEvent.BUTTON3_MASK);
                    robot.mouseRelease(InputEvent.BUTTON3_MASK);
                    break;
                case 4: // Esquerdo Duplo
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cursor(int move, int direction) {
        
        /*
            1 = ↑
            2 = ↓
            3 = ←
            4 = →
            5 = ↑ + ←
            6 = ↑ + →
            7 = ↓ + ←
            8 = ↓ + →
        */
        
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        int y = (int) b.getY();
        
        try {
            Robot robot = new Robot();
            switch (direction) {
                case 1: // ↑
                    robot.mouseMove(x, y - move);
                    break;
                case 2: // ↓
                    robot.mouseMove(x, y + move);
                    break;
                case 3: // ←
                    robot.mouseMove(x - move, y);
                    break;
                case 4: // →
                    robot.mouseMove(x + move, y);
                    break;
                case 5: // ↑ + ← 
                    robot.mouseMove(x - move, y - move);
                    break;
                case 6: // ↑ + →
                    robot.mouseMove(x + move, y - move);
                    break;
                case 7: // ↓ + ←
                    robot.mouseMove(x - move, y + move);
                    break;
                case 8: // ↓ + →
                    robot.mouseMove(x + move, y + move);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void scroll(int direction) {
        
        /*
            1 - Cima
            2 - Baixo
        */
        
        try {
            Robot robot = new Robot();
            if (direction == 1) {
                robot.mouseWheel(-1);
            } else if (direction == 2) {
                robot.mouseWheel(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
