import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;


public class DEMO01 {
    public static void main(String[] args) {
        new exex();


    }
}

class exex extends JFrame {
    private static final long serialVersionUID = 1172300329115978744L;

    final int size = 5; // 介面視窗大小
    int bingos = 0; // 賓果連線數
    JButton[][] btn = new JButton[size + 10][size + 10]; // actual display of btns (bingo
    // board)---不知道什麼東西但和下面共生死
    char[][] grid = new char[size + 10][size + 10]; // grid to check whether it's bingo or
    // not----不知道什麼東西但和上面共生死
    int presscount = 1; // 賓果步數

    boolean[] rowBingos = new boolean[size];
    boolean[] columnBingos = new boolean[size];
    boolean se, sw, n1, n2, n3, n4, n5, e1, e2, e3, e4, e5;

    exex() {
        setTitle("Bingo for everyone!!!!");//介面視窗標題
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(size, size));// basic board setup
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                btn[i][j] = new JButton(Integer.toString((int) (Math.random() * 25) + 1)); // setting
                // buttons
                // 亂數1~25;
                //賓果數字排列
                // if(contain(btn,i)==false)//過濾重複的數字

                grid[i][j] = '0'; // make a grid board to check bingos--就是0就對了

                btn[i][j].addActionListener(new ActionListener() {//畫格子吧?大概
                    public void actionPerformed(ActionEvent e) {
                        JButton btnR = (JButton) e.getSource();
                        System.out.println(presscount);
                        presscount++;
                        for (int i = 0; i < 5; i++) {
                            for (int j = 0; j < 5; j++) {
                                if (btn[i][j] == btnR) {
                                    int row = i;
                                    int column = j;
                                    grid[row][column] = 'X'; // set pressed
                                    // button to 'X'
                                    // char on my
                                    // grid(2D char
                                    // array)
                               }
                                //System.out.print(grid[i][j]); //印出賓果目前對錯圖形

                          }
                          //  System.out.println("");//賓果目前對錯圖形的印出空間
                        }
                        boolean bingo = isBingo('X'); // check if grid has
                        // any bingos, if it
                        // does, then set
                        // bingo to true.
                        System.out.print(bingo);
                        if (bingo) {
                            bingos++;
                        }
                        System.out.print(bingos);
                        System.out.println("-----------");

                        // Color change when pressed,
                        btnR.setBackground(Color.CYAN);
                        btnR.setOpaque(true);

                    }

                });
                add(btn[i][j]);
            }
            System.out.println();
        }
        setSize(500, 500);//視窗介面開啟時大小
        setVisible(true);


    }


    public boolean isBingo(char g) {
        boolean gg = false;
        if (grid[0][0] == g && grid[1][1] == g
                && grid[2][2] == g && grid[3][3] == g
                && grid[4][4] == g && se != true) { // check for S.E
            // diagonal bingos
            se = true;
            return true;
        } else if (grid[0][4] == g && grid[1][3] == g
                && grid[2][2] == g && grid[3][1] == g
                && grid[4][0] == g && sw != true) { // check for S.W
            // diagonal bingos
            sw = true;
            return true;
        } else if (grid[0][0] == g && grid[0][1] == g
                && grid[0][2] == g && grid[0][3] == g
                && grid[0][4] == g && n1 != true) { // check for S.W
            // diagonal bingos
            n1 = true;
            return true;
        } else if (grid[1][0] == g && grid[1][1] == g
                && grid[1][2] == g && grid[1][3] == g
                && grid[1][4] == g && n2 != true) { // check for S.W
            // diagonal bingos
            n2 = true;
            return true;
        } else if (grid[2][0] == g && grid[2][1] == g
                && grid[2][2] == g && grid[2][3] == g
                && grid[2][4] == g && n3 != true) { // check for S.W
            // diagonal bingos
            n3 = true;
            return true;
        } else if (grid[3][0] == g && grid[3][1] == g
                && grid[3][2] == g && grid[3][3] == g
                && grid[3][4] == g && n4 != true) { // check for S.W
            // diagonal bingos
            n4 = true;
            return true;
        } else if (grid[4][0] == g && grid[4][1] == g
                && grid[4][2] == g && grid[4][3] == g
                && grid[4][4] == g && n5 != true) { // check for S.W
            // diagonal bingos
            n5 = true;
            return true;
        } else if (grid[0][0] == g && grid[1][0] == g
                && grid[2][0] == g && grid[3][0] == g
                && grid[4][0] == g && e1 != true) { // check for S.W
            // diagonal bingos
            e1 = true;
            return true;
        } else if (grid[0][1] == g && grid[1][1] == g
                && grid[2][1] == g && grid[3][1] == g
                && grid[4][1] == g && e2 != true) { // check for S.W
            // diagonal bingos
            e2 = true;
            return true;
        }else  if(grid[0][2] == g && grid[1][2] == g
                && grid[2][2] == g && grid[3][2] == g
                && grid[4][2] == g && e3!= true) { // check for S.W
            // diagonal bingos
            e3 = true;
            return true;
        }else  if(grid[0][3] == g && grid[1][3] == g
                && grid[2][3] == g && grid[3][3] == g
                && grid[4][3] == g && e4!= true) { // check for S.W
            // diagonal bingos
            e4 = true;
            return true;
        }else  if(grid[0][4] == g && grid[1][4] == g
                && grid[2][4] == g && grid[3][4] == g
                && grid[4][4] == g && e5!= true) { // check for S.W
            // diagonal bingos
            e5 = true;
            return true;
        }

        return gg;
    }
//--------------------------------
    public boolean contain(JButton[][] btn, int i) {//過濾重複的數
        boolean res = false;
        for (int b = 0; i < btn.length; i++) {
            if (btn[b].equals(i))
                res = true;

        }
        return res;
    }
}




